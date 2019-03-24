package org.lhpsn.book.thinkinginjava4.chapter02;

/**
 * @author tsy
 */
public class E05 {

    public static void main(String[] args) {
        // 赋值并输出变量的数据
        DataOnly dataOnly = new DataOnly();
        dataOnly.i = 10;
        dataOnly.f = 10;
        dataOnly.b = true;
        System.out.println(dataOnly.i);
        System.out.println(dataOnly.f);
        System.out.println(dataOnly.b);
    }

    static class DataOnly {
        int i;
        float f;
        boolean b;
    }
}
