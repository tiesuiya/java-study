package org.lhpsn.book.thinkinginjava4.chapter02;

/**
 * @author tsy
 */
public class E08 {

    private static String s = "only";

    public static void main(String[] args) {
        // 证明static域只有一个实例
        for (int i = 0; i < 100; i++) {
            E08 chapter01_08 = new E08();
            System.out.println("内存地址：" + chapter01_08.s.hashCode() + "；值：" + chapter01_08.s);
        }
    }
}
