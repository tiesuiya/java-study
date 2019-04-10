package org.lhpsn.book.thinkinginjava4.chapter05.e08;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tsy
 * @date 2019-04-09 17:47
 */
@Slf4j
public class Main {

    public void method1() {
        method2();
        this.method2();
    }

    public void method2() {
        System.out.println("method2");
    }

    // 看看this关键字是否起作用
    public static void main(String[] args) {
        new Main().method1();
    }
}
