package org.lhpsn.book.thinkinginjava4.chapter05;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tsy
 * @date 2019-04-10 10:59
 */
@Slf4j
public class E17 {

    public E17(String args) {
        System.out.println(args);
    }

    // 观察只创建引用是否会触发构造器的执行
    public static void main(String[] args) {
        E17[] e17s;
    }
}
