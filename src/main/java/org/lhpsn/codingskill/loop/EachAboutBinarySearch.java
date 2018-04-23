package org.lhpsn.codingskill.loop;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * 关于二分查找的循环实现
 *
 * @author lh
 * @since 1.0.0
 */
public class EachAboutBinarySearch {

    public static void main(String[] args) {

        EachAboutBinarySearch eachBinarySearch = new EachAboutBinarySearch();

        // 边界测试
        System.out.println(eachBinarySearch.binarySearchV1(6, new int[]{}));
        System.out.println(eachBinarySearch.binarySearchV1(6, new int[]{6}));
        System.out.println(eachBinarySearch.binarySearchV1(6, new int[]{6, 1}));
        System.out.println(eachBinarySearch.binarySearchV1(6, new int[]{1, 6}));
        System.out.println(eachBinarySearch.binarySearchV1(6, new int[]{1, 6, 2}));

        // 随机测试
        Random random = new Random();
        // 1~10随机数
        int arrLength = random.nextInt(10) + 1;
        int[] arr = new int[arrLength];
        int hold = 0;
        for (int i = 0; i < arrLength; i++) {
            hold += random.nextInt(10);
            arr[i] = hold;
        }
        int k = arr[random.nextInt(arrLength)];
        int result = eachBinarySearch.binarySearchV1(k, arr);
        System.out.println("测试值：" + k + "，在数组" + Arrays.toString(arr) + "中的查找结果为：" + result);

    }

    /**
     * 二分查找的循环实现
     *
     * @param arr 需要查找的数组，必须是一个sorted数组
     * @param k   需要查找值
     * @return 值所在数组位置
     */
    public int binarySearchV1(int k, int[] arr) {
        int a = 0;
        int b = arr.length - 1;
        while (b >= a) {
            int m = a + (b - a) / 2;
            // 原先代码是：int m = (a + b)/2;但是a+b可能会溢出，所以调整一下写法
            // b == a : m = a ; m = b
            // b == a + 1 : m = a
            // b == a + 2 : (a+b+2)/2 = m -> (a+b)/2 = m -> m一定为中位数
            // b == a + n : (a+b+n)/2 = m -> m一定为中位数
            if (k > arr[m]) {
                a = m + 1;
            } else if (k < arr[m]) {
                b = m - 1;
            } else {
                return m;
            }
        }
        return -1;
    }


    /**
     * 二分查找的循环实现（另一种思路）
     *
     * @param arr 需要查找的数组，必须是一个sorted数组
     * @param k   需要查找值
     * @return 值所在数组位置
     */
    public int binarySearchV2(int k, int[] arr) {
        // 这里使用arr.length原因：[a,b) 开闭区间具有查找优势:
        // [a,m) + [m,b) = [a,b)
        int a = 0;
        int b = arr.length;
        while (b > a) {
            int m = a + (b - a) / 2;
            if (k > arr[m]) {
                a = m + 1;
            } else if (k < arr[m]) {
                b = m;
            } else {
                return m;
            }
        }
        return -1;
    }
}
