package org.lhpsn.util;

import java.util.Arrays;

/**
 * 排序帮助类
 *
 * @author lh
 * @since 1.0.0
 */
public final class SortUtil {

    /**
     * 冒泡排序
     *
     * @param list 待排序集合
     * @param <T>  待排序对象
     */
    public static <T extends Comparable<T>> void sort(T[] list) {
        boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped; ++i) {
            System.out.println("外第" + i + "轮(本次需要比较" + (len - i) + "次)：");
            swapped = false;
            for (int j = 0; j < len - i; ++j) {
                System.out.print(Arrays.asList(list));
                System.out.print("\t内第" + (j + 1) + "轮：" + list[j] + "和" + list[j + 1] + "相比;\t\n");
                if (list[j].compareTo(list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

    public static void mySort(Integer[] array) {
        int i, j, len = array.length;
        for (i = 0; i < len - 1; i++) {
            System.out.println("外第" + (i + 1) + "轮(本次需要比较" + len + "次)：");
            for (j = i + 1; j < len; j++) {
                System.out.print(Arrays.asList(array));
                System.out.print("\t内第" + j + "轮：" + array[i] + "和" + array[j] + "相比;\t\n");
                if (array[i] < array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

}
