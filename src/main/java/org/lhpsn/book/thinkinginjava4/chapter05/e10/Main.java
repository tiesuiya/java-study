package org.lhpsn.book.thinkinginjava4.chapter05.e10;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tsy
 * @date 2019-04-09 17:56
 */
@Slf4j
public class Main {

    private boolean rich;

    public void makeRich() {
        rich = true;
    }

    @Override
    protected void finalize() {
        if (!rich) {
            System.out.println("AWSL");
        }
    }

    // 看看finalize在垃圾回收的时候是否执行
    public static void main(String[] args) throws InterruptedException {
        new Main();
        new Main().makeRich();
        System.gc();
        Thread.sleep(1000);
        System.out.println("SYSTEM EXIT");
    }
}
