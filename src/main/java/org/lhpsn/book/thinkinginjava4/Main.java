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
            add(new MyDate("0405", 202, 238));
            add(new MyDate("0407", 238, 247));
        }};
        list.forEach(item -> {
            int page = item.getEnd() - item.getStart() + 1;
            PrintStream printStream = page < 36 ? System.err : System.out;
            printStream.println(item.getDate() + " finish:" + page);
        });
        printProcess(list.get(list.size() - 1).getEnd());
    }

    private static final int TOTAL_PAGE = 767;

    public static void printProcess(int pages) {
        for (int page = 0; page < pages; page++) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String finish = "";
            int p = page * 100 / TOTAL_PAGE;
            for (int i = 0; i < p; i++) {
                finish += "▓";
            }
            for (int i = 0; i < 100 - p; i++) {
                finish += "░";
            }
            finish += " " + p + "%";
            System.out.print("\r");
            System.out.print(finish);
        }
    }


    @Data
    @AllArgsConstructor
    static class MyDate {
        private String date;
        private int start;
        private int end;
    }
}
