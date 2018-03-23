package org.lhpsn.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * 字符串帮助类测试
 *
 * @author lh
 * @since 1.0.0
 */
public class StringUtilTest {

    @Test
    public void testReverse() throws Exception {
        File file = new File("");
        String str = "abc123";
        str = StringUtil.reverse(str);
        Assert.assertTrue("321cba".equals(str));
    }
}
