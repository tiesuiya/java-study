package org.lhpsn.util;

import org.junit.Assert;
import org.junit.Test;
import sun.security.util.Length;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * 测试排序帮助类
 *
 * @author lh
 * @since 1.0.0
 */
public class SortUtilTest {

    @Test
    public void testSort1() throws Exception {
        // 第一种方法
        Integer[] arr = getTestIntegerArray();
        SortUtil.sort(arr);
        String flag = arr[0] > arr[1] ? "DESC" : "ASC";
        for (int i = 0; i < arr.length; i++) {
            if ("ASC".equals(flag)) {
                if (i != arr.length - 1) {
                    Assert.assertTrue(arr[i] < arr[i + 1]);
                }
            } else {
                if (i != arr.length - 1) {
                    Assert.assertTrue(arr[i] > arr[i + 1]);
                }
            }
        }
    }

    @Test
    public void testSort2() {
        // 第二种方法
        Integer[] arr = getTestIntegerArray();
        SortUtil.sort(arr, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        String flag = arr[0] > arr[1] ? "DESC" : "ASC";
        for (int i = 0; i < arr.length; i++) {
            if ("ASC".equals(flag)) {
                if (i != arr.length - 1) {
                    Assert.assertTrue(arr[i] < arr[i + 1]);
                }
            } else {
                if (i != arr.length - 1) {
                    Assert.assertTrue(arr[i] > arr[i + 1]);
                }
            }
        }
    }


    @Test
    public void testSort3() {
        // Collections自带
        Integer[] arr = getTestIntegerArray();
        Collections.sort(Arrays.asList(arr));
        String flag = arr[0] > arr[1] ? "DESC" : "ASC";
        for (int i = 0; i < arr.length; i++) {
            if ("ASC".equals(flag)) {
                if (i != arr.length - 1) {
                    Assert.assertTrue(arr[i] < arr[i + 1]);
                }
            } else {
                if (i != arr.length - 1) {
                    Assert.assertTrue(arr[i] > arr[i + 1]);
                }
            }
        }
    }

    @Test
    public void testSortSpeed() throws Exception {
        // 速度测试
        String[] arr = getTestStringArray();
        String[] arr1 = CloneUtil.clone(arr);
        String[] arr2 = CloneUtil.clone(arr);

        long timestamp = System.currentTimeMillis();
        SortUtil.sort(arr1);
        long timestamp1 = System.currentTimeMillis() - timestamp;

        timestamp = System.currentTimeMillis();
        Collections.sort(Arrays.asList(arr2));
        long timestamp2 = System.currentTimeMillis() - timestamp;
        // 预计Collections一定比自己实现的
        Assert.assertTrue(timestamp1 - timestamp2 > 0);
    }

    /**
     * 获取随机数字数组
     *
     * @return 随机数字
     */
    private Integer[] getTestIntegerArray() {
        int len = 100;
        Integer[] arr = new Integer[len];
        for (int i = 0; i < len; i++) {
            arr[i] = new Random().nextInt();
        }
        return arr;
    }

    /**
     * 获取随机汉字数组
     *
     * @return 随机汉字
     */
    private String[] getTestStringArray() {
        int len = 100;
        String[] arr = new String[len];
        for (int i = 0; i < len; i++) {
            arr[i] = String.valueOf((char) (0x4e00 + (int) (Math.random() * (0x9fa5 - 0x4e00 + 1))));
            // arr[i] = String.valueOf((char) (Math.random() * 26 + 'a'));
        }
        return arr;
    }
}
