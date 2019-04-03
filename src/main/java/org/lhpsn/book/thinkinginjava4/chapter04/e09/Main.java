package org.lhpsn.book.thinkinginjava4.chapter04.e09;

/**
 * @author tsy
 */
public class Main {

    // 输出斐波那契数
    public static void main(String[] args) {
        fibonacci(100);
    }

    // count：输出个数
    private static void fibonacci(long count) {
        long holdA = 0;
        long holdB = 1;
        long temp;
        for (long i = 0; i < Math.abs(count); i++) {
            System.out.println((i + 1) + "\t" + holdB);
            temp = holdB;
            holdB += holdA;
            holdA = temp;
            if (Long.MAX_VALUE - holdB - holdB < 0) {
                System.out.println("超出Long范围！");
                System.exit(0);
            }
        }
    }
}
