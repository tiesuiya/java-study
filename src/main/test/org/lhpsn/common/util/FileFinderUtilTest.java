package org.lhpsn.common.util;

import org.junit.Test;

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

    @Test
    public void find() throws Exception {
        List<File> files = FileFinderUtil.find("/Users/Hong/IdeaProjects/java-study", 3, Arrays.asList("xml", "MD"));
        for (File file : files) {
            System.out.println(file.getAbsoluteFile());
        }
        System.out.println("文件个数：" + files.size());
    }
}