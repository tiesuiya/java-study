package org.lhpsn.book.thinkinginjava4.chapter05.e13;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tsy
 * @date 2019-04-09 18:30
 */
@Slf4j
public class Main {
//    private Cups cups = new Cups(); // 1

    // 尝试注释和放开代码1 2 3 4，来理解类的初始化
    public static void main(String[] args) {
        System.out.println("Main()");
//        Cups.cup1.f(99); // 2
    }


//    static Cups cups1 = new Cups(); // 3
//    static Cups cups2 = new Cups(); // 4
}
