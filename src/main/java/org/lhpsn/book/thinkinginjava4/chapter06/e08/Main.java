package org.lhpsn.book.thinkinginjava4.chapter06.e08;

/**
 * @author tsy
 * @version 1.0
 */
public class Main {

    // 访问一个受private保护的类的方法
    public static void main(String[] args) {
        for (int i = 0; i < 13; i++) {
            System.out.println(ConnectionManager.get());
        }
    }

}
