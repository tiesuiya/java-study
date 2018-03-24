package org.lhpsn.util;

/**
 * 字符串帮助类
 *
 * @author lh
 * @since 1.0.0
 */
public final class StringUtil {

    /**
     * 字符串反转
     *
     * @param originStr 待反转字符串
     * @return 反转字符串
     */
    public static String reverse(String originStr) {
        if (originStr == null || originStr.length() <= 1) {
            return originStr;
        }
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }
}
