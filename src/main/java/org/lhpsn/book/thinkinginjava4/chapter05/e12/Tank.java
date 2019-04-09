/**
 * java-study
 * <p>
 * Copyright 2014 Acooly.cn, Inc. All rights reserved.
 *
 * @author RQ021
 * @date 2019-04-09 17:56
 */
package org.lhpsn.book.thinkinginjava4.chapter05.e12;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tsy
 * @date 2019-04-09 17:56
 */
@Slf4j
public class Tank {

    private String status;

    public void full() {
        status = "VALUE";
    }

    @Override
    protected void finalize() {
        if (status != null) System.err.println("ERROR");
    }

    // 看看finalize在垃圾回收的时候是否执行
    public static void main(String[] args) throws InterruptedException {
        new Tank();
        new Tank().full();
        System.gc();
        Thread.sleep(1000);
        System.out.println("SYSTEM EXIT");
    }
}
