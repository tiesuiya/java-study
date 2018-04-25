package org.lhpsn.codingskill.recursion;

/**
 * 关于字符串反转的递归实现
 *
 * @author lh
 * @since 1.0.0
 */
public class RecursiveAboutStringReverse {

    public static void main(String[] args) {

        RecursiveAboutStringReverse recursiveReverse = new RecursiveAboutStringReverse();

        System.out.println(recursiveReverse.reverse("0123456789"));
    }

    /**
     * 字符串反转
     *
     * @param originStr 待反转字符串
     * @return 反转字符串
     */
    public String reverse(String originStr) {
        if (originStr == null || originStr.length() <= 1) {
            return originStr;
        }
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }
}


