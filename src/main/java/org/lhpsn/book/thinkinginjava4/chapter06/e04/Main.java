package org.lhpsn.book.thinkinginjava4.chapter06.e04;

/**
 * @author tsy
 * @date 2019-04-11 16:37
 */
public class Main {

    // protected也有包访问权限
    public static void main(String[] args) {
        new ProtectedClass().protectedMethod();
    }
}
