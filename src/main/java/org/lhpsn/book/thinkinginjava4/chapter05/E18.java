package org.lhpsn.book.thinkinginjava4.chapter05;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tsy
 * @date 2019-04-10 10:59
 */
@Slf4j
public class E18 {

    public E18(String args) {
        System.out.println(args);
    }

    // 观察创建引用并赋值，是否会触发构造器的执行
    public static void main(String[] args) {
        E18[] e18s = {new E18("param1"), new E18("param2")};
    }
}
