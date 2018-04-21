package org.lhpsn.codingskill.interview.question;

import java.util.Scanner;

/**
 * 谷歌面试题：Beautiful Numbers（小数据量3 ~ 1000）
 * 要求计算给定数据在多少进制的时候是beautiful的（进制表示下值全都是1）
 * 其中限制：
 * 比如13的2进制表示为111，3进制表示为11（2进制下为正确答案，取1最多的）
 *
 * @author lh
 * @since 1.0.0
 */
public class GoogleAboutBeautifulNumberSmallData {

    public static void main(String[] args) {

        GoogleAboutBeautifulNumberSmallData beautifulNumber = new GoogleAboutBeautifulNumberSmallData();
        Scanner in = new Scanner(System.in);
        // 首位表示个数
        int cases = in.nextInt();
        for (int i = 1; i <= cases; ++i) {
            int n = in.nextInt();
            int radix = beautifulNumber.getBeautifulRadix(n);
            System.out.println("Case #" + i + " : " + radix);
        }
    }

    /**
     * 计算beautiful
     *
     * @param n 数据
     * @return 进制
     */
    private int getBeautifulRadix(int n) {
        // 从二进制开始找，直到n-1进制
        for (int radix = 2; radix < n; radix++) {
            if (isBeautiful(n, radix)) {
                return radix;
            }
        }
        throw new IllegalStateException("this code should never be executed");
    }

    /**
     * 是否beautiful
     *
     * @param n     数据
     * @param radix 进制
     * @return boolean结果
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
