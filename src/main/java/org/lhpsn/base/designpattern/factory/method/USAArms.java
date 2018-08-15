package org.lhpsn.base.designpattern.factory.method;

/**
 * 美国军火
 *
 * @Author: lihong
 * @Date: 2018/8/15
 * @Description
 */
public class USAArms extends Arms {

    public USAArms(ArmsType armsType) {
        setCountry("美国");
        setType(armsType);
    }


    @Override
    String getInfo() {
        String armsName;
        switch (getType()) {
            case GENERAL:
                armsName = "玩具车";
                break;
            case HIGH_END:
                armsName = "遥控车";
                break;
            default:
                armsName = "玩具玩具遥控车";
                break;
        }
        setName(armsName);
        return getCountry() + "的" + getType().getNote() + "：" + getName();
    }

}
