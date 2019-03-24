package org.lhpsn.book.thinkinginjava4.chapter02;

/**
 * @author tsy
 */
public class E10 {

    public static void main(String[] args) {
        // 打印命令行参数
        if (args.length >= 3) {
            System.out.println(args[2]);
        } else {
            System.out.println("未找到第三个命令行参数");
        }
    }
}
