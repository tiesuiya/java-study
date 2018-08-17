package org.lhpsn.base.param;

/**
 * 关于参数传递类型
 * <p>
 * 传递的是引用的拷贝
 * 引用有两个含义：当传递类型为基本类型、枚举类型时，引用表示实际值；当传递类型为引用类型时，引用表示内存地址。
 *
 * @author lh
 * @since 1.0.0
 */
public class ParamAboutTransportType {

    public static void main(String[] args) {

        System.out.println("重在理解，注意看类注释：");

        // 改变参数对象中的值
        Wrapper wrapper = new Wrapper("六", 6);
        System.out.println("对象更改前：" + wrapper);
        // 提供了改变自身方法的引用类型
        tryToChangeObjInnerValue(wrapper);
        System.out.println("对象更改后：" + wrapper);

        // 改变参数对象的值
        String valueStr = "六";
        Integer valueInt = 6;
        System.out.println("参数更改前：" + valueStr + " - " + valueInt);
        // 没有提供了改变自身方法的引用类型
        tryToChangeParamValue(valueStr, valueInt);
        System.out.println("参数更改后：" + valueStr + " - " + valueInt);

        // 改变枚举对象的值
        TestEnum testEnum = TestEnum.A;
        System.out.println("枚举更改前：" + testEnum);
        // 没有提供了改变自身方法的引用类型
        tryToChangeEnumValue(testEnum);
        System.out.println("枚举更改后：" + testEnum);

    }

    /**
     * 尝试改变参数对象中的值
     *
     * @param wrapper 要修改的对象
     */
    private static void tryToChangeObjInnerValue(Wrapper wrapper) {
        wrapper.setValueStr("六六六");
        wrapper.setValueInt(666);
    }

    /**
     * 尝试改变参数对象的值
     *
     * @param valueStr 要修改的参数1
     * @param valueInt 要修改的参数2
     */
    private static void tryToChangeParamValue(String valueStr, Integer valueInt) {
        valueInt = 666;
        valueStr = "六六六";
    }

    /**
     * 尝试改变枚举对象的值
     *
     * @param testEnum 要修改的枚举对象
     */
    private static void tryToChangeEnumValue(TestEnum testEnum) {
        testEnum = TestEnum.B;
    }

}

/**
 * 传输对象
 */
class Wrapper {

    private String valueStr;
    private Integer valueInt;

    public Wrapper(String valueStr, Integer valueInt) {
        this.valueStr = valueStr;
        this.valueInt = valueInt;
    }

    public String getValueStr() {
        return valueStr;
    }

    public void setValueStr(String valueStr) {
        this.valueStr = valueStr;
    }

    public Integer getValueInt() {
        return valueInt;
    }

    public void setValueInt(Integer valueInt) {
        this.valueInt = valueInt;
    }

    @Override
    public String toString() {
        return "Wrapper{" +
                "valueStr='" + valueStr + '\'' +
                ", valueInt=" + valueInt +
                '}';
    }
}

/**
 * 枚举
 */
enum TestEnum {

    /**
     * enum XStreamAboutDefualt
     */
    A,

    /**
     * enum B
     */
    B
}