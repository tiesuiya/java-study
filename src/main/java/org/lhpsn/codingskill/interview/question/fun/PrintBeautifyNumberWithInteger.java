package org.lhpsn.codingskill.interview.question.fun;

import org.lhpsn.codingskill.interview.question.GoogleAboutBeautifulNumberLargeData;

/**
 * 打印整数中的Beautiful Number
 *
 * @author lh
 * @since 1.0.0
 */
public class PrintBeautifyNumberWithInteger {
    public static void main(String[] args) {
        GoogleAboutBeautifulNumberLargeData largeData = new GoogleAboutBeautifulNumberLargeData();

        for (int n = 3; n < Integer.MAX_VALUE; n++) {
            long bd = largeData.getBeautifulRadix(n);
            if (bd != -1 && bd != n - 1) {
                System.out.println(n + "\t" + largeData.getBeautifulRadix(n));
            }
        }
    }

}
