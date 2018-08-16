package org.lhpsn.ost.lucene4.service;

import java.util.Arrays;
import java.util.List;

/**
 * lucene配置
 *
 * @author lh
 * @since 1.0.0
 */
interface LuceneConfig {

    /**
     * 索引字段，id
     */
    String FIELD_ID = "id";

    /**
     * 索引字段，标题
     */
    String FIELD_TITLE = "title";

    /**
     * 索引字段，内容
     */
    String FIELD_CONTENTS = "contents";

    /**
     * 索引字段，url
     */
    String FIELD_URL = "url";

    /**
     * 索引存放目录
     */
    String INDEX_DIR = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "index_dir";

    /**
     * 扫描目录
     */
    String FILE_DIR = "/Users/Hong/Documents/";

    /**
     * 扫描目录
     */
    Integer DEPTH = 2;

    /**
     * 需要被索引的文件类型列表
     */
    List<String> TYPE_LIST = Arrays.asList("doc", "xls", "xlsx", "docx", "txt");
}
