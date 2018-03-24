package org.lhpsn.util;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * @author lh
 * @since 1.0.0
 */
public class SortUtilTest {
    @Test
    public void testMySort() throws Exception {
        Integer[] arr = getTestIntegerArray();
        Integer[] arr1 = CloneUtil.clone(arr);
        Integer[] arr2 = CloneUtil.clone(arr);

        SortUtil.mySort(arr2);
        SortUtil.sort(arr1);
    }

    public Integer[] getTestIntegerArray() {
        int len = 15;
        Integer[] arr = new Integer[len];
        for (int i = 0; i < len; i++) {
            arr[i] = new Random().nextInt();
        }
        arr[len - 5] = 6;
        arr[len - 4] = 6;
        arr[len - 3] = 6;
        arr[len - 2] = 6;
        arr[len - 1] = 6;
        System.out.println(Arrays.asList(arr));
        return arr;
    }
}
