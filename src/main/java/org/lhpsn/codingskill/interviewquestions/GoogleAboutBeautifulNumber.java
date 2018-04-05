package org.lhpsn.codingskill.interviewquestions;

/**
 * Beautiful Numbers
 * 计算数据在多少进制的时候是beautiful的（值全都是1）
 * 其中：
 * 13的2进制表示为111 （1最多的为正确答案）
 * 13的3进制表示为11
 *
 * @author lh
 * @since 1.0.0
 */
public class GoogleAboutBeautifulNumber {

    public static void main(String[] args) {
        GoogleAboutBeautifulNumber beautifulNumber = new GoogleAboutBeautifulNumber();
        System.out.println(beautifulNumber.beautiful(2));
        System.out.println(beautifulNumber.beautiful(3));
        System.out.println(beautifulNumber.beautiful(4));
        System.out.println(beautifulNumber.beautiful(5));
        System.out.println(beautifulNumber.beautiful(6));
    }

    /**
     * 计算数据在多少进制的时候是beautiful的
     * 从二进制开始找，直到n-1进制
     *
     * @param n 数据
     * @return 进制
     */
    private int beautiful(int n) {
        for (int radix = 2; radix < n; radix++) {
            if (isBeautiful(n, radix)) {
                return radix;
            }
        }
        // this code should never be executed
        return -1;
    }

    /**
     * @param n     数据
     * @param radix 进制
     * @return
     */
    private boolean isBeautiful(int n, int radix) {
        while (n > 0) {
            if (n % radix != 1) {
                return false;
            }
            n /= radix;
        }
        return true;
    }

}
