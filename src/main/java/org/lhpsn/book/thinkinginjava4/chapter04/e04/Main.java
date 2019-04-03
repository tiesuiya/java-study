package org.lhpsn.book.thinkinginjava4.chapter04.e04;

/**
 * @author tsy
 * @version 1.0
 */
public class Main {

    // 用两个嵌套的for循环和取余操作符来探测和打印质数
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            boolean prime = false;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                } else {
                    prime = true;
                }
            }
            if (prime) {
                System.out.println(i);
            }
        }
    }
}
