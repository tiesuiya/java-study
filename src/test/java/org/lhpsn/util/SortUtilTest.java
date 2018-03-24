package org.lhpsn.util;

import org.junit.Assert;
import org.junit.Test;
import sun.security.util.Length;

import java.lang.reflect.Array;
import java.util.Arrays;
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

    /**
     * 获取size为100的随机数组
     *
     * @return 随机Integer数组
     */
    private Integer[] getTestIntegerArray() {
        int len = 5;
        Integer[] arr = new Integer[len];
        for (int i = 0; i < len; i++) {
            arr[i] = new Random().nextInt();
        }
        return arr;
    }
}
