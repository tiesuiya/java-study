package org.lhpsn.book.thinkinginjava4.chapter02;

/**
 * @author tsy
 */
public class E01 {

    int intValue;

    char charValue;

    public static void main(String[] args) {
        // 验证成员变量都有默认初始化值
        System.out.println("int:" + new E01().intValue);
        System.out.println("char:" + new E01().charValue);
    }
}
