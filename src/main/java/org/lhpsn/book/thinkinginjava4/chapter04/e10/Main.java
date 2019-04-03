package org.lhpsn.book.thinkinginjava4.chapter04.e10;

import java.util.Arrays;

/**
 * @author tsy
 */
public class Main {

    // 找出4位数的所有吸血鬼数字
    // https://www.cnblogs.com/fyqx/p/7147536.html
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 11; i < 100; i++) {
            for (int j = i; j < 100; j++) {
                int k = i * j;
                // 有另一种变为字符串来操作,比较发现下面的这种方法耗时更少
                int[] a = {k / 1000, k / 100 % 10, k / 10 % 100 % 10, k % 1000 % 100 % 10};
                int[] b = {i % 10, i / 10, j % 10, j / 10};
                Arrays.sort(a);
                Arrays.sort(b);
                if (Arrays.equals(a, b)) {
                    sum++;
                    System.out.println("第" + sum + "组: " + i + " * " + j + " = " + k);
                }
            }
        }
        System.out.println("方法3共找到" + sum + "组吸血鬼数");
    }
}
