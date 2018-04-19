package org.lhpsn.base.typeofdata;

/**
 * 关于String类型的intern()方法
 * <p>
 * intern()方法会得到字符串对象在`常量池中对应的版本的引用`（如果常量池中有一个字符串与String对象的equals结果是true），
 * 如果常量池中没有对应的字符串，则该字符串将被添加到常量池中，然后返回常量池中字符串的引用
 *
 * @author lh
 * @since 1.0.0
 */
public class StringAboutIntern {

    public static void main(String[] args) {

        String str1 = "Programming";
        String str2 = "Program";
        String str3 = "ming";
        String str4 = "Program" + "ming";
        String str5 = str2 + str3;

        // true
        System.out.println(str1.intern() == str4);
        // false
        System.out.println(str1.intern() == str5);

        // true
        System.out.println(str4.intern() == str1);
        // true
        System.out.println(str5.intern() == str1);
    }
}