package org.lhpsn.book.thinkinginjava4.chapter06.e02;

import org.lhpsn.book.thinkinginjava4.chapter06.e02.package1.*;
// 放开下面一行会报错
// import org.lhpsn.book.thinkinginjava4.chapter06.e02.package2.*;

/**
 * @author tsy
 * @date 2019-04-10 15:35
 */
public class Main {

    // 观察导入有重复类名的两个包会出现什么
    public static void main(String[] args) {
        Jack jack_1 = new Jack();
        Jack jack_2 = new Jack();
    }
}
