package org.lhpsn.codingskill.interview.question;

import java.util.Scanner;

/**
 * 谷歌面试题：Beautiful Numbers（大数据量1000 ~ 10^18）
 * 要求计算给定数据在多少进制的时候是beautiful的（进制表示下值全都是1）
 * 其中限制：
 * 比如13的2进制表示为111，3进制表示为11（2进制下为正确答案，取1最多的）
 *
 * @author lh
 * @since 1.0.0
 */
public class GoogleAboutBeautifulNumberLargeData {

    public static void main(String[] args) {

        GoogleAboutBeautifulNumberLargeData beautifulNumber = new GoogleAboutBeautifulNumberLargeData();
        Scanner in = new Scanner(System.in);
        // 首位表示个数
        int cases = in.nextInt();
        for (int i = 1; i <= cases; ++i) {
            long n = in.nextLong();
            System.out.println("Case #" + i + ": " + beautifulNumber.getBeautifulRadix(n));
        }
    }

    /**
     * 计算beautiful
     *
     * @param n 数据
     * @return 进制
     */
    public long getBeautifulRadix(long n) {
        // 已知：10^18在一个64位的长整型范围内（long：-2^63 ~ 2^63-1）
        // 故可以假定数据在bits位下全是1
        int minBit = 1;
        int maxBit = 64;
        for (int bits = maxBit; bits >= minBit; bits--) {
            long radix = getRadixByBinary(n, bits);
            if (radix != -1) {
                return radix;
            }
        }
        throw new IllegalStateException("this code should never be executed");
    }

    /**
     * 二分查找计算进制
     *
     * @param n    数据
     * @param bits 位数
     * @return 进制
     */
    private long getRadixByBinary(long n, int bits) {
        long minRadix = 2;
        long maxRadix = n;
        while (maxRadix > minRadix) {
            // 2 3 ... 1000000 1000001
            long midRadix = minRadix + (maxRadix - minRadix) / 2;
            long midValue = convert(midRadix, bits);
            if (midValue == n) {
                return midRadix;
            } else if (midValue > n) {
                maxRadix = midRadix;
            } else {
                minRadix = midRadix + 1;
            }
        }
        return -1;
    }

    /**
     * 计算在固定进制和位数下全1表示的值
     *
     * @param radix 进制
     * @param bits  位数
     * @return 固定进制和位数下全1表示的值
     */
    private long convert(long radix, int bits) {
        long component = 1;
        long sum = 0;
        // 等差计算 1 + 1*radix^1 + 1*radix^2 +  ... + 1*radix^(bits-1)
        for (int bit = 0; bit < bits; bit++) {
            // 防止溢出
            if (sum > Long.MAX_VALUE - component) {
                return Long.MAX_VALUE;
            }
            sum += component;
            // 更新hold值
            // 防止溢出
            if (component > Long.MAX_VALUE / radix) {
                component = Long.MAX_VALUE;
            } else {
                component *= radix;
            }
        }
        return sum;
    }
}