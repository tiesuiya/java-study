package org.lhpsn.book.thinkinginjava4.chapter05.e01;

/**
 * @author tsy
 * @version 1.0
 */
public class Main {

    private String classScope;

    public static void main(String[] args) {
        String funcScope;

        System.out.println(new Main().classScope);
        // 编译不通过
        // System.out.println(funcScope);
    }
}
