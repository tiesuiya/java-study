package org.lhpsn.codingskill.loop;

import java.util.Arrays;

/**
 * 关于二分查找的循环实现
 *
 * @author lh
 * @since 1.0.0
 */
public class EachAboutBinarySearch {

    public static void main(String[] args) {
        EachAboutBinarySearch eachBinarySearch = new EachAboutBinarySearch();
        int[] ints = new int[]{1, 2, 3, 4, 5};
        System.out.println(eachBinarySearch.binarySearch(ints, 6));
        ints = new int[]{1,3};
        System.out.println(eachBinarySearch.binarySearch(ints, 6));
        ints = new int[]{1};
        System.out.println(eachBinarySearch.binarySearch(ints, 0));
        ints = new int[]{1, 2, 3, 4, 5};
        System.out.println(eachBinarySearch.binarySearch(ints, 0));
        ints = new int[]{1, 2, 3, 4, 5};
        System.out.println(eachBinarySearch.binarySearch(ints, 1));
        ints = new int[]{1, 2, 3, 4, 5};
        System.out.println(eachBinarySearch.binarySearch(ints, 5));
        ints = new int[]{};
        System.out.println(eachBinarySearch.binarySearch(ints, 0));
        ints = new int[]{};
        System.out.println(eachBinarySearch.binarySearch(ints, 10));
    }

    /**
     * 二分查找的循环实现
     *
     * @param arrays     需要查找的数组，必须是一个sorted数组
     * @param searchData 需要查找值
     * @return 值所在数组位置
     */
    public int binarySearch(int[] arrays, int searchData) {

        if (arrays == null || arrays.length == 0) {
            return -1;
        }

        int index = -(arrays.length + 1);
        int a = 0;
        int b = arrays.length - 1;

        // a-b必须是一个有效区间
        while (a < b) {
            // 查找中间值
            int scope = b - a;
            // 边界：当塞选到最后两个，不存在中间值，就需要单独处理
            if (scope == 1) {
                if (arrays[a] == searchData) {
                    index = a;
                    break;
                } else if (arrays[b] == searchData) {
                    index = b;
                    break;
                } else {
                    break;
                }
            }
            int median = scope % 2 == 1 ? (scope - 1) / 2 : scope / 2;
            int m = median + a;
            int mValue = arrays[m];
            // 比较中间值
            if (mValue > searchData) {
                b = m;
            } else if (mValue < searchData) {
                a = m;
            } else {
                index = m;
                break;
            }

        }
        return index;
    }
}
