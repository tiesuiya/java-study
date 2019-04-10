package org.lhpsn.book.thinkinginjava4.chapter06.e01;

import org.lhpsn.book.thinkinginjava4.chapter06.e01.inner.Inner;

/**
 * @author tsy
 * @date 2019-04-10 15:32
 */
public class Main {

    // 在类所在包外部创建一个该类的实例
    public static void main(String[] args) {
        System.out.println(new Inner());
    }
}
