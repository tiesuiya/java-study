package org.lhpsn.book.thinkinginjava4.chapter04.e02;

import java.util.Random;

/**
 * @author tsy
 * @version 1.0
 */
public class Main {

    // 随机产生25个随机数，将其分为大于、小于、等于紧随它产生的随机的值。
    public static void main(String[] args) {
        Random random = new Random();
        Integer curr = null;
        for (int i = 1; i <= 25; i++) {
            int randomInt = random.nextInt();
            if (curr != null) {
                if (curr > randomInt) {
                    System.out.println("第" + (i - 1) + "个数（" + curr + "）大于第" + i + "个数（" + randomInt + ")");
                } else if (curr < randomInt) {
                    System.out.println("第" + (i - 1) + "个数（" + curr + "）小于第" + i + "个数（" + randomInt + ")");
                } else {
                    System.out.println("第" + (i - 1) + "个数（" + curr + "）等于第" + i + "个数（" + randomInt + ")");
                }
            }
            curr = randomInt;
        }
    }
}
