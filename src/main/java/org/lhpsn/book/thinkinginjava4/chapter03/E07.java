package org.lhpsn.book.thinkinginjava4.chapter03;

import java.util.Random;

/**
 * @author tsy
 */
public class E07 {

    public static void main(String[] args) {
        // 模拟扔硬币
        doSomething();
    }

    static void doSomething() {
        Random random = new Random();
        double frontProbability = random.nextDouble();
        double backProbability = random.nextDouble();
        System.out.println(frontProbability);
        System.out.println(backProbability);
        if (frontProbability == backProbability) {
            System.out.println("优秀！立起了");
            doSomething();
            return;
        }
        if (frontProbability > backProbability) {
            System.out.println("国徽");
        } else {
            System.out.println("菊花");
        }
    }
}
