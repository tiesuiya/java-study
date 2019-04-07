package org.lhpsn.book.thinkinginjava4.chapter05.e02;

/**
 * @author tsy
 * @version 1.0
 */
public class Main {

    private String s1 = "init";

    private String s2;

    public Main(String s2) {
        this.s2 = s2;
    }

    public String getS1() {
        return s1;
    }

    public String getS2() {
        return s2;
    }

    public static void main(String[] args) {
        Main main = new Main("init constructor");
        System.out.println(main.getS1());
        System.out.println(main.getS2());
    }
}
