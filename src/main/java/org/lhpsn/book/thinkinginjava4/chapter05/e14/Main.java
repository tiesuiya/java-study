package org.lhpsn.book.thinkinginjava4.chapter05.e14;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tsy
 * @date 2019-04-09 18:37
 */
@Slf4j
public class Main {

    static String s1 = "丑丑";
    static String s2;

    static {
        s2 = "熊熊";
    }

    static void print() {
        System.out.println(s1);
        System.out.println(s2);
    }

    // 证明静态字符串能在被使用前初始化
    public static void main(String[] args) {
        Main.print();
    }
}
