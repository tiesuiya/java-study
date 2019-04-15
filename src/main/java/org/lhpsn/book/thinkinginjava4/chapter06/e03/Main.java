package org.lhpsn.book.thinkinginjava4.chapter06.e03;

import org.lhpsn.book.thinkinginjava4.chapter06.e03.debug.Debug;

/**
 * @author tsy
 * @date 2019-04-11 15:06
 */
public class Main {

    public static void main(String[] args) {
        new Debug().debug("???");
        new org.lhpsn.book.thinkinginjava4.chapter06.e03.debugoff.Debug().debug("???", "是不是这么搞哦");
    }
}
