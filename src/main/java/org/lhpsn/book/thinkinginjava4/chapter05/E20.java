package org.lhpsn.book.thinkinginjava4.chapter05;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author tsy
 * @date 2019-04-10 11:10
 */
public class E20 {

    // String... args效果和String[] args都能启动main
    public static void main(String... args) {
        System.out.println("Hello String... args");
        Arrays.stream(args).forEach(System.out::println);
    }

    /*
        这里由于带了package，所以编译后需要退回到根目录/去执行
        cd C:\Users\RQ021\IdeaProjects\java-study\src\main\java\org\lhpsn\book\thinkinginjava4\chapter05
        javac -encoding UTF-8 E20.java
        cd C:\Users\RQ021\IdeaProjects\java-study\src\main\java
        java org.lhpsn.book.thinkinginjava4.chapter05.E20
     */
}
