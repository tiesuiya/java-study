package org.lhpsn.book.thinkinginjava4.chapter02;

/**
 * @author tsy
 */
public class E06 {

    public static void main(String[] args) {
        // 尝试调用一个方法
        System.out.println(new E06().storage("what happen?"));
    }

    private int storage(String s) {
        return s.length() * 2;
    }
}
