package org.lhpsn.base.typeofdata;

/**
 * 关于String类型数据'+'操作
 * <p>
 * 字面量相加不会产生新对象
 * 变量相加会产生新对象
 *
 * @author lh
 * @since 1.0.0
 */
public class StringAboutAdd {

    public static void main(String[] args) {

        String str1 = "Programming";
        String str2 = "Program";
        String str3 = "ming";
        String str4 = "Program" + "ming";
        // 注意！这里相加产生了新对象
        String str5 = str2 + str3;

        // true
        System.out.println(str1 == str4);
        // false
        System.out.println(str1 == str5);
    }
}