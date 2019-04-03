package org.lhpsn.book.thinkinginjava4;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tsy
 * @version 1.0
 */
public class Main {

    // 16Day
    public static void main(String[] args) {
        List<MyDate> list = new ArrayList<MyDate>() {{
            add(new MyDate("0405", 202, 0));
        }};
        list.forEach(item -> {
            int page = item.getEnd() - item.getStart() + 1;
            PrintStream printStream = page < 36 ? System.err : System.out;
            printStream.println(item.getDate() + " finish:" + page);
        });
        // 767
    }


    @Data
    @AllArgsConstructor
    static class MyDate {
        private String date;
        private int start;
        private int end;
    }
}
