package org.lhpsn.book.thinkinginjava4.chapter05.e15;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tsy
 * @date 2019-04-09 18:48
 */
@Slf4j
public class Main {

    private String param;

    public Main(String param) {
        this.param = param;
    }

    // 实例化一个有字符串域的类
    public static void main(String[] args) {
        new Main("VALUE");
    }
}
