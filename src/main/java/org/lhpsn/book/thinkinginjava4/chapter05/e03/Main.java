package org.lhpsn.book.thinkinginjava4.chapter05.e03;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tsy
 * @date 2019-04-09 17:13
 */
@Slf4j
public class Main {

    public Main() {
        System.out.println("hello default constructor");
    }

    // 创建一个待默认构造器的类对象
    public static void main(String[] args) {
        new Main();
    }
}
