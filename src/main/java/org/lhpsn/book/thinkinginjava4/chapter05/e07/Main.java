/**
 * java-study
 * <p>
 * Copyright 2014 Acooly.cn, Inc. All rights reserved.
 *
 * @author RQ021
 * @date 2019-04-09 17:34
 */
package org.lhpsn.book.thinkinginjava4.chapter05.e07;

import lombok.extern.slf4j.Slf4j;

/**
 * @author tsy
 * @date 2019-04-09 17:34
 */
@Slf4j
public class Main {

    // 验证没有构造函数时是否自动加入了默认构造器
    public static void main(String[] args) {
        new Main();
    }
}
