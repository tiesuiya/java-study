package org.lhpsn.common.util;

import org.junit.Test;
import org.lhpsn.thirdparty.lucene4.service.LuceneIndexServiceTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * 文件查找帮助类测试
 *
 * @author lh
 * @since 1.0.0
 */
public class FileFinderUtilTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LuceneIndexServiceTest.class);

    @Test
    public void find() throws Exception {
        List<File> files = FileFinderUtil.find("/Users/Hong/IdeaProjects/java-study", 3, Arrays.asList("xml", "MD"));
        for (File file : files) {
            LOGGER.debug("绝对路径：" + file.getAbsoluteFile());
        }
        LOGGER.debug("size：" + files.size());
    }
}