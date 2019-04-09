/**
 * java-study
 * <p>
 * Copyright 2014 Acooly.cn, Inc. All rights reserved.
 *
 * @author RQ021
 * @date 2019-04-09 17:19
 */
package org.lhpsn.book.thinkinginjava4.chapter05.e05;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tsy
 * @date 2019-04-09 17:19
 */
@Slf4j
public class Dog {

    void bark(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("wang~");
        }
        System.out.println();
    }

    void bark(long count) {
        for (int i = 0; i < count; i++) {
            System.out.print("汪~");
        }
        System.out.println();
    }

    // 什么沙雕练习
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark(1);
        dog.bark(2l);
    }
}
