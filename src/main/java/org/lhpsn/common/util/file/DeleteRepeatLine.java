package org.lhpsn.common.util.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author tsy
 */
public class DeleteRepeatLine {

    public static void main(String[] args) {
        String file = "C:/Users/RQ021/Desktop/out.txt";
        int count = 0;
        Set<String> noRepeatSet = deleteRepeatLine(file);
        // 排除
        noRepeatSet.removeIf(s -> s.indexOf("\"transStatus\":\"00\"") > 0 || s.indexOf("\"transStatus\":\"01\"") > 0 || s.indexOf("\"transStatus\":\"02\"") > 0);
        for (String s : noRepeatSet) {
            System.out.println(++count + "\t" + s);
        }
    }

    public static Set<String> deleteRepeatLine(String name) {
        Set<String> set = new TreeSet<>();
        try {
            FileReader fr = new FileReader(name);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                set.add(str);
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return set;
    }
}
