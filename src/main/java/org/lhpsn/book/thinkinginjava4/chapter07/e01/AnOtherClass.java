package org.lhpsn.book.thinkinginjava4.chapter07.e01;

/**
 * @author tsy
 * @version 1.0
 */
public class AnOtherClass {

    private ASimpleClass simpleClass;

    public void go() {
        simpleClass = new ASimpleClass();
        simpleClass.doSome();
    }

    // 惰性初始化：在正要使用这些对象之前初始化
    public static void main(String[] args) {
        new AnOtherClass().go();
    }
}
