package org.lhpsn.base.typeofdata;

/**
 * 关于Integer类型的IntegerCache静态内部类
 * <p>
 * 1.==比较内存地址
 * 2.-128~127（包含），为IntegerCache缓存值
 *
 * @author lh
 * @since 1.0.0
 */
public class IntegerAboutIntegerCache {

    public static void main(String[] args) {

        // 引用数据类型
        Integer intA = -128, intB = -128, intC = 128, intD = 128;

        // true
        System.out.println(intA == intB);
        // false 不同的引用
        System.out.println(intC == intD);

        // 基本数据类型
        int intAs = -128, intBs = -128, intCs = 128, intDs = 128;

        // true
        System.out.println(intAs == intBs);
        // true 直接指向值
        System.out.println(intCs == intDs);
    }

}
