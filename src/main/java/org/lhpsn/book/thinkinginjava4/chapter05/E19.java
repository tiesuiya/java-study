package org.lhpsn.book.thinkinginjava4.chapter05;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author tsy
 * @date 2019-04-10 11:05
 */
@Slf4j
public class E19 {

    public E19(String... args) {
        System.out.println(Arrays.toString(args));
    }

    // 观察可变参数形参能接收数据的方式
    public static void main(String[] args) {
        new E19("A", "B", "C");
        String[] array = {"A", "B", "C"};
        new E19(array);
    }
}
