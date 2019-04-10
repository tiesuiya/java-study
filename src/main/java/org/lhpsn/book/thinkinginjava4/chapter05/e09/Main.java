package org.lhpsn.book.thinkinginjava4.chapter05.e09;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tsy
 * @date 2019-04-09 17:52
 */
@Slf4j
public class Main {

    public Main() {
        System.out.println("default constructor");
    }

    public Main(String msg) {
        this();
        System.out.println(msg);
    }

    // 尝试用this调用重载构造器
    public static void main(String[] args) {
        new Main("parameter");
    }

}
