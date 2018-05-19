package org.lhpsn.thirdparty.lucene4.service;


import org.lhpsn.thirdparty.lucene4.dto.IndexDTO;
import org.lhpsn.thirdparty.lucene4.dto.IndexScheduleDTO;
import org.lhpsn.thirdparty.lucene4.dto.SearchResultDTO;

import java.io.File;
import java.util.List;

/**
 * lucene索引服务
 *
 * @author lh
 * @since 1.0.0
 */
public interface LuceneIndexService extends LuceneConfig {

    /**
     * 异步刷新所有索引
     */
    void syncRefreshAllIndex(String webRootPath);

    /**
     * 获取刷新进度
     *
     * @return 进度实体
     */
    IndexScheduleDTO getSyncRefreshSchedule();

    /**
     * 添加索引
     *
     * @param file 文件
     */
    void addIndex(File file);

    /**
     * 更新索引
     *
     * @param searchFile 索引实体
     */
    // void updateIndex(IndexDTO searchFile);

    /**
     * 删除索引
     *
     * @param id 索引id
     */
    // void deleteIndex(Integer id);

    /**
     * 根据关键字搜索
     *
     * @param keyword  关键字
     * @param pageNo   起始页
     * @param pageSize 每页要显示的记录数
     * @return LuceneSearchResult对象
     */
    SearchResultDTO<IndexDTO> doSearcher(String keyword, int pageNo, int pageSize);

    /**
     * 获取所有文件集合
     *
     * @return 所有文件集合
     */
    List<File> getAllFileList(String webRootPath);

}
