package org.lhpsn.codingskill.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 关于排序的冒泡实现
 *
 * @author lh
 * @since 1.0.0
 */
public class SortAboutBubbleSort {

    public static void main(String[] args) {
        SortAboutBubbleSort sortAboutBubbleSort = new SortAboutBubbleSort();

        Integer[] array = new Integer[]{111, 32, 3, 45, 6, 1};
        sortAboutBubbleSort.sort(array);
        System.out.println(Arrays.asList(array));

        array = new Integer[]{33, 322, 13, 45, 14, 5};
        sortAboutBubbleSort.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(Arrays.asList(array));
    }

    /**
     * 冒泡排序
     * 注意：效率天差于Collections.sort
     *
     * @param list 待排序集合
     * @param <T>  待排序对象
     */
    public <T extends Comparable<T>> void sort(T[] list) {
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
    public <T> void sort(T[] list, Comparator<T> comp) {
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


