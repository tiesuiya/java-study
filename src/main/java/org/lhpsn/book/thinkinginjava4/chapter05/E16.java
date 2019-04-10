package org.lhpsn.book.thinkinginjava4.chapter05;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author tsy
 * @date 2019-04-10 10:56
 */
@Slf4j
public class E16 {

    // 创建并打印数组
    public static void main(String[] args) {
        String[] stringArray = {"A", "B", "C", "D", "E",};
        Arrays.stream(stringArray).forEach(System.out::println);
    }
}
