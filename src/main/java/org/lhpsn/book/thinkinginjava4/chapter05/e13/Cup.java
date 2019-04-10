package org.lhpsn.book.thinkinginjava4.chapter05.e13;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tsy
 * @date 2019-04-09 18:27
 */
@Slf4j
public class Cup {

    public Cup(int marker) {
        System.out.println("Cup(" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}
