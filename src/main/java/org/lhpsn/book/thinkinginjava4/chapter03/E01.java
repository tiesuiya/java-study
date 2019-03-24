package org.lhpsn.book.thinkinginjava4.chapter03;

import static org.lhpsn.book.thinkinginjava4.chapter03.E01.TempUtils.println;

/**
 * @author tsy
 */
public class E01 {

    public static void main(String[] args) {
        // 使用简短的和正常的打印语句
        System.out.println("使用简短的和正常的打印语句");
        println("使用简短的和正常的打印语句");
    }

    static class TempUtils {
        public static void println(String msg) {
            System.out.println(msg);
        }
    }
}
