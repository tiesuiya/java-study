package org.lhpsn.book.thinkinginjava4.chapter06.e05;

/**
 * @author tsy
 * @date 2019-04-11 16:43
 */
public class Main {

    public static void main(String[] args) {
        AccessClass accessClass = new AccessClass();
        // System.out.println(accessClass.fieldPrivate);
        System.out.println(accessClass.fieldProtectd);
        System.out.println(accessClass.fieldPublic);
        // System.out.println(accessClass.fieldPrivate());
        System.out.println(accessClass.fieldProtectd());
        System.out.println(accessClass.fieldPublic());
    }
}
