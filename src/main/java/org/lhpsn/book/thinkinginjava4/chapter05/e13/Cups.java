package org.lhpsn.book.thinkinginjava4.chapter05.e13;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tsy
 * @date 2019-04-09 18:29
 */
@Slf4j
public class Cups {
    static Cup cup1;
    static Cup cpu2;

    static {
        cup1 = new Cup(1);
        cpu2 = new Cup(2);
    }

    Cups() {
        System.out.println("Cups()");
    }

}
