package org.lhpsn.codingskill.loop;

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
        System.out.println(eachBinarySearch.binarySearch1(ints, 6));
        ints = new int[]{1, 3};
        System.out.println(eachBinarySearch.binarySearch1(ints, 6));
        ints = new int[]{1};
        System.out.println(eachBinarySearch.binarySearch1(ints, 0));
        ints = new int[]{1, 2, 3, 4, 5};
        System.out.println(eachBinarySearch.binarySearch1(ints, 0));
        ints = new int[]{1, 2, 3, 4, 5};
        System.out.println(eachBinarySearch.binarySearch1(ints, 1));
        ints = new int[]{1, 2, 3, 4, 5};
        System.out.println(eachBinarySearch.binarySearch1(ints, 5));
        System.out.println(".....................................");
        ints = new int[]{1, 2, 3, 4, 5};
        System.out.println(eachBinarySearch.binarySearch1(ints, -1));
        ints = new int[]{10, 20, 30, 40, 50};
        System.out.println(eachBinarySearch.binarySearch1(ints, 25));
        ints = new int[]{10, 20, 30, 40, 50};
        System.out.println(eachBinarySearch.binarySearch1(ints, 55));
        ints = new int[]{1, 2};
        System.out.println(eachBinarySearch.binarySearch1(ints, 1));
        ints = new int[]{1, 2};
        System.out.println(eachBinarySearch.binarySearch1(ints, 2));
    }


    /**
     * 二分查找的循环实现
     *
     * @param arr 需要查找的数组，必须是一个sorted数组
     * @param k   需要查找值
     * @return 值所在数组位置
     */
    public int binarySearch1(int[] arr, int k) {
        // 这里使用arr.length原因：[a,b) 开闭区间具有查找优势:
        // [a,m) + [m,b) = [a,b)
        int a = 0;
        int b = arr.length;
        while (b > a) {
            int m = a / 2 + b / 2;
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

    /**
     * 二分查找的循环实现(自己实现的)
     *
     * @param arrays     需要查找的数组，必须是一个sorted数组
     * @param searchData 需要查找值
     * @return 值所在数组位置
     */
    public int binarySearchDiy(int[] arrays, int searchData) {

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
                return m;
            }

        }
        return index;
    }
}
