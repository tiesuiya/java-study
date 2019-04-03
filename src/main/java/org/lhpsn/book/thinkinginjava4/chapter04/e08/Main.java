package org.lhpsn.book.thinkinginjava4.chapter04.e08;

/**
 * @author tsy
 */
public class Main {

    // 尝试去掉switch里的break，看看会发生什么
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            switch (i) {
                case 0:
                    System.out.println("零");
//                    break;
                case 1:
                    System.out.println("一");
//                    break;
                case 2:
                    System.out.println("二");
//                    break;
                case 3:
                    System.out.println("三");
//                    break;
                default:
            }
        }
    }
}
