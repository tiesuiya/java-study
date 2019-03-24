package org.lhpsn.book.thinkinginjava4.chapter02;

/**
 * @author tsy
 */
public class E07 {

    public static void main(String[] args) {
        // 展示用方法递增一个静态变量
        StaticTest staticTest1 = new StaticTest();
        StaticTest staticTest2 = new StaticTest();
        System.out.println(staticTest1.i);
        System.out.println(staticTest2.i);

        Incrementable.incement();

        System.out.println(staticTest1.i);
        System.out.println(staticTest2.i);
    }


    static class StaticTest {
        static int i = 47;
    }

    static class Incrementable {
        static void incement() {
            StaticTest.i++;
        }
    }
}
