package org.lhpsn.book.thinkinginjava4.chapter04.e03;

import java.util.Date;

/**
 * @author tsy
 * @version 1.0
 */
public class Main {

    // 尝试中断一个无限循环
    public static void main(String[] args) {
        while (true) {
            System.out.println(new Date().getTime());
        }
    }
}
