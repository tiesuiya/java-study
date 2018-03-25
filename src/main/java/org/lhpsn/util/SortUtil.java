package org.lhpsn.util;

import java.util.Comparator;

/**
 * 排序帮助类
 *
 * @author lh
 * @since 1.0.0
 */
public final class SortUtil {

    /**
     * 冒泡排序
     * 注意：效率天差于Collections.sort
     *
     * @param list 待排序集合
     * @param <T>  待排序对象
     */
    @Deprecated
    public static <T extends Comparable<T>> void sort(T[] list) {
        boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped; i++) {
            swapped = false;
            for (int j = 0; j < len - i; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

    /**
     * 冒泡排序（自定义排序重载）
     * 注意：效率天差于Collections.sort
     *
     * @param list 待排序集合
     * @param <T>  待排序对象
     * @param comp 比较方式
     */
    @Deprecated
    public static <T> void sort(T[] list, Comparator<T> comp) {
        boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped; i++) {
            swapped = false;
            for (int j = 0; j < len - i; j++) {
                if (comp.compare(list[j], list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

}
