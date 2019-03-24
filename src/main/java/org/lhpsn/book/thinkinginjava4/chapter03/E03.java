package org.lhpsn.book.thinkinginjava4.chapter03;

/**
 * @author tsy
 */
public class E03 {

    public static void main(String[] args) {
        // 展示方法调用时的"别名机制"
        Wapper wapper = new Wapper();
        wapper.c = '哼';
        System.out.println(wapper.c);
        method(wapper);
        System.out.println(wapper.c);
    }

    static void method(Wapper w) {
        w.c = '哈';
    }

    static class Wapper {
        char c;
    }
}
