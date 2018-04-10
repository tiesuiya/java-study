package org.lhpsn.base.param;

/**
 * 关于参数传递类型
 * <p>
 * java中只有值传递，没有引用传递
 * （将需要通过方法调用修改的引用置于一个Wrapper类中，再将Wrapper对象传入方法）
 *
 * @author lh
 * @since 1.0.0
 */
public class ParamAboutTransportType {

    public static void main(String[] args) {
        // 改变参数对象中的值
        Wrapper wrapper = new Wrapper("六", 6);
        // 更改前
        System.out.println(wrapper);
        changeObjInnerValue(wrapper);
        // 更改后
        System.out.println(wrapper);

        // 改变参数对象的值
        String valueStr = "六";
        Integer valueInt = 6;
        // 更改前
        System.out.println(valueStr + " - " + valueInt);
        // 此处无效
        changeParamValue(valueStr, valueInt);
        // 更改后
        System.out.println(valueStr + " - " + valueInt);
    }

    /**
     * 改变参数对象中的值
     *
     * @param wrapper 要修改的对象
     */
    private static void changeObjInnerValue(Wrapper wrapper) {
        wrapper.setValueStr("六六六");
        wrapper.setValueInt(666);
    }

    /**
     * 改变参数对象的值
     *
     * @param valueStr 要修改的参数1
     * @param valueInt 要修改的参数2
     */
    private static void changeParamValue(String valueStr, int valueInt) {
        valueInt = 666;
        valueStr = "六六六";
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
