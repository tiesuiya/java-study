package org.lhpsn.book.thinkinginjava4.chapter06.e03.debug;

import java.util.Arrays;

/**
 * @author tsy
 * @date 2019-04-11 14:59
 */
public class Debug {

    public void debug(String... args) {
        System.out.println(Arrays.asList(args));
    }
}
