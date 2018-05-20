package org.lhpsn.thirdparty.lucene4.service;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.lhpsn.common.util.FileFinderUtil;
import org.lhpsn.common.util.FileReaderUtil;
import org.lhpsn.thirdparty.lucene4.dto.IndexDTO;
import org.lhpsn.thirdparty.lucene4.dto.IndexScheduleDTO;
import org.lhpsn.thirdparty.lucene4.dto.SearchResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * lucene索引服务实现
 *
 * @author lh
 * @since 1.0.0
 */
public class LuceneIndexServiceImpl implements LuceneIndexService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LuceneIndexServiceImpl.class);

    /**
     * 索引执行器
     */
    private final IndexExecutor indexExecutor = new IndexExecutor();

    @Override
    public void syncRefreshAllIndex(String webRootPath) {
        try {
            // 删除索引
            deleteIndex();

            // 按文件类型查找文件
            List<File> files = getAllFileList(webRootPath);

            // 使用线程池建立索引
            indexExecutor.execute(files);
        } catch (IOException e) {
            LOGGER.error("创建索引任务失败！");
        }
    }

    @Override
    public IndexScheduleDTO getSyncRefreshSchedule() {
        return indexExecutor.getStatus();
    }

    @Override
    public void addIndex(File file) {
        IndexDTO indexDTO = new IndexDTO();

        try {
            // 标题设置成文件名
            String title = file.getName().substring(0, file.getName().lastIndexOf("."));
            indexDTO.setId(UUID.randomUUID().toString());
            indexDTO.setTitle(title);
            // 文件访问路径
            String absolutePath = file.getAbsolutePath();
            String filePath = absolutePath.substring(absolutePath.indexOf(LuceneIndexService.FILE_DIR), absolutePath.length());
            indexDTO.setFileUrl(filePath);

            // 设置内容
            indexDTO.setContents(FileReaderUtil.readContent(file));

            doIndexSingle(indexDTO);
        } catch (Exception e) {
            LOGGER.error("索引失败：{}（{}）", indexDTO.getFileUrl(), new Date());
        }
    }

    @Override
    public SearchResultDTO<IndexDTO> doSearcher(String keyword, int pageNo, int pageSize) {
        SearchResultDTO<IndexDTO> lsr = new SearchResultDTO<>();

        if (keyword == null || keyword.isEmpty()) {
            return lsr;
        }
        lsr.setPageNo(pageNo);
        lsr.setPageSize(pageSize);
        lsr.setKeyword(keyword);

        // 读取索引并查询
        try (DirectoryReader reader = DirectoryReader.open(this.openDirectory())) {

            // 创建一个索引搜索器
            IndexSearcher searcher = new IndexSearcher(reader);

            // 用多域查询解析器来创建一个查询器
            Query query = MultiFieldQueryParser.parse(keyword, new String[]{FIELD_TITLE, FIELD_CONTENTS},
                    new BooleanClause.Occur[]{BooleanClause.Occur.SHOULD, BooleanClause.Occur.SHOULD}, this.getAnalyzer());
            long begin = System.currentTimeMillis();
            // 查询结集信息类
            TopDocs ts = searcher.search(query, null, 100000);
            // 获取命中的数量
            lsr.setRecordCount(ts.totalHits);
            // 进行高亮显示，默认是<b>..</b>
            SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<span style='color:red'>", "</span>");
            // 构造高亮:指定高亮的格式,指定查询评分
            Highlighter highlighter = new Highlighter(simpleHTMLFormatter, new QueryScorer(query));
            // 设置Fragmenter的长度,实现对检索关键字出现频率最高的一段文字作为摘要字段长度的控制
            highlighter.setTextFragmenter(new SimpleFragmenter(300));
            // 获取匹配到的结果集
            ScoreDoc[] hits = ts.scoreDocs;
            List<IndexDTO> ais = new ArrayList<>();
            // 总页数
            int pageCount = (lsr.getRecordCount() + pageSize - 1) / pageSize;
            lsr.setTotalPage(pageCount);
            // 要开始返回的文档编号
            int start = 0;
            // 要结束返回的文档编号
            int end = 0;
            if (pageCount > 0) {
                start = (pageNo - 1) * pageSize;
                end = start + pageSize;
                // 处理最后一页的结束文档的编号
                if (pageNo == pageCount) {
                    if (lsr.getRecordCount() % pageSize == 0) {
                        end = start + 1;
                    } else {
                        end = start + (lsr.getRecordCount() % pageSize);
                    }
                }
            }
            if (start < end) {
                lsr.setStartNo(start + 1);
                lsr.setEndNo(end);
            }
            // 循环获取分页数据
            for (int i = start; i < end; i++) {
                // 通过内部编号从搜索器中得到对应的文档
                Document doc = searcher.doc(hits[i].doc);
                IndexDTO news = new IndexDTO();
                news.setId(doc.getField(FIELD_ID).stringValue());
                news.setTitle(doc.getField(FIELD_TITLE).stringValue());
                news.setContents(doc.getField(FIELD_CONTENTS).stringValue());
                news.setFileUrl(doc.getField(FIELD_URL).stringValue());
                // 处理文件名称的高亮显示问题
                String title = doc.getField(FIELD_TITLE).stringValue();
                String title2 = highlighter.getBestFragment(this.getAnalyzer(), FIELD_TITLE, title);
                if (title2 == null) {
                    news.setTitle(title);
                } else {
                    news.setTitle(title2);
                }
                // 文件描述高亮显示
                String contents1 = doc.getField(FIELD_CONTENTS).stringValue();
                // 提取检索关键字出现频率最高的一段文字作为摘要
                String contents2 = highlighter.getBestFragment(this.getAnalyzer(), FIELD_CONTENTS, contents1);
                if (contents2 == null) {
                    news.setContents(contents1);
                } else {
                    // 此处的数值应和上边设置的 Fragmenter长度保持一致
                    if (contents2.length() > 300) {
                        news.setContents(contents2.substring(0, 300) + "...");
                    } else {
                        news.setContents(contents2);
                    }
                }
                // 把符合条件的数据添加到List
                ais.add(news);
            }
            lsr.setTime((System.currentTimeMillis() - begin) / 1000.0); // 计算搜索耗时秒数
            lsr.setDatas(ais); // 把查询到的数据添加到LuceneSearchResult
        } catch (IOException | ParseException | InvalidTokenOffsetsException e) {
            e.printStackTrace();
        }
        return lsr;
    }

    /**
     * 获取所有需要被索引的文件
     *
     * @return 需要被索引的文件集合
     */
    public List<File> getAllFileList(String webRootPath) {
        String absolutePath = webRootPath + LuceneIndexService.FILE_DIR;
        return FileFinderUtil.find(absolutePath, DEPTH, TYPE_LIST);
    }

    /**
     * 删除所有索引
     */
    private void deleteIndex() throws IOException {
        IndexWriterConfig writerConfig = new IndexWriterConfig(Version.LUCENE_4_10_2, getAnalyzer());
        IndexWriter indexWriter = new IndexWriter(openDirectory(), writerConfig);
        indexWriter.deleteAll();
        indexWriter.close();
    }

    /**
     * 单文件索引
     *
     * @param indexDTO 索引DTO
     * @throws IOException
     */
    private void doIndexSingle(IndexDTO indexDTO) throws IOException {
        IndexWriterConfig writerConfig = new IndexWriterConfig(Version.LUCENE_4_10_2, getAnalyzer());
        writerConfig.setOpenMode(OpenMode.CREATE_OR_APPEND);
        writerConfig.setRAMBufferSizeMB(1024.0);
        writerConfig.setMaxBufferedDocs(100);

        // 创建索引写入器
        try (IndexWriter indexWriter = new IndexWriter(openDirectory(), writerConfig)) {

            // 创建文件文档对象
            Document doc = new Document();
            //id 域   不分词、不被索引
            Field field = new Field(FIELD_ID, indexDTO.getId(), Field.Store.YES, Field.Index.NO);
            doc.add(field);
            // title域   分词、被索引
            Field field1 = new Field(FIELD_TITLE, indexDTO.getTitle(), Field.Store.YES, Field.Index.ANALYZED);
            doc.add(field1);
            // content域    分词、被索引
            Field field2 = new Field(FIELD_CONTENTS, indexDTO.getContents(), Field.Store.YES, Field.Index.ANALYZED);
            doc.add(field2);
            // url域   不分词、不被索引
            Field field3 = new Field(FIELD_URL, indexDTO.getFileUrl(), Field.Store.YES, Field.Index.NO);
            doc.add(field3);

            indexWriter.addDocument(doc);

            LOGGER.debug("索引成功：{}（{}）", indexDTO.getFileUrl(), new Date());
        }
    }

    /**
     * 获取语法解析器
     *
     * @return 语法解析器
     */
    private Analyzer getAnalyzer() {
        return new IKAnalyzer();
    }

    /**
     * 打开索引的存放目录
     *
     * @return 索引的存放目录对象
     * @throws IOException IOException
     */
    private Directory openDirectory() throws IOException {
        return FSDirectory.open(new File(INDEX_DIR));
    }


    /**
     * 索引执行器
     *
     * @author lh
     * @since 1.0.0
     */
    private class IndexExecutor {

        /**
         * 索引任务线程池
         */
        private ExecutorService indexTaskPool;

        /**
         * 索引进度
         */
        private IndexScheduleDTO holder;

        IndexExecutor() {
            init();
        }

        private void init() {
            holder = new IndexScheduleDTO(IndexScheduleDTO.StatusEnum.IDLE.getState(), 0, 0);
        }

        /**
         * 执行建立索引
         *
         * @param fileList 需要索引的文件
         */
        void execute(List<File> fileList) {

            // 如果任务没有执行
            if (IndexScheduleDTO.StatusEnum.IDLE.getState().equals(holder.getStatus())) {

                if (fileList == null || fileList.size() == 0) {
                    return;
                }

                // 初始化任务状态
                holder.setStatus(IndexScheduleDTO.StatusEnum.RUNNING.getState());
                holder.setTotalNum(fileList.size());
                holder.setFinishNum(0);

                // 初始化线程池（默认开启20个，最大开启50个线程）
                indexTaskPool = new ThreadPoolExecutor(10, 20, 0L, TimeUnit.MILLISECONDS,
                        // 设置为无界的队列，但是有OOM的风险
                        new LinkedBlockingQueue<Runnable>(),
                        new ThreadFactoryBuilder().build(),
                        new ThreadPoolExecutor.AbortPolicy());

                for (File file : fileList) {
                    indexTaskPool.submit(new IndexTask(holder, file));
                }
            }
        }

        /**
         * 获取刷新进度
         *
         * @return 进度实体
         */
        IndexScheduleDTO getStatus() {
            return holder;
        }

        /**
         * 索引任务
         */
        private class IndexTask implements Runnable {

            /**
             * 索引进度
             */
            private final IndexScheduleDTO currentHolder;

            /**
             * 被索引文件
             */
            private final File file;

            IndexTask(IndexScheduleDTO holder, File file) {
                this.currentHolder = holder;
                this.file = file;
            }

            @Override
            public void run() {
                synchronized (currentHolder) {
                    // 添加索引
                    addIndex(file);
                    int finishNum = currentHolder.getFinishNum();

                    // 完成数+1
                    finishNum++;
                    currentHolder.setFinishNum(finishNum);

                    int total = currentHolder.getTotalNum();
                    int finish = currentHolder.getFinishNum();
                    if (finish == total) {
                        destroyExecute();
                    }
                }
            }
        }

        /**
         * 销毁
         */
        private void destroyExecute() {
            // 重置状态
            holder.setStatus(IndexScheduleDTO.StatusEnum.IDLE.getState());
            holder.setFinishNum(0);
            holder.setTotalNum(0);

            // 关闭线程池
            indexTaskPool.shutdown();
        }
    }
}
