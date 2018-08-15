package org.lhpsn.base.designpattern.factory.method;

/**
 * 朝鲜军火
 *
 * @Author: lihong
 * @Date: 2018/8/15
 * @Description
 */
public class NorthKoreaArms extends Arms {

    public NorthKoreaArms(ArmsType armsType) {
        setCountry("朝鲜");
        setType(armsType);
    }


    @Override
    String getInfo() {
        String armsName;
        switch (getType()) {
            case GENERAL:
                armsName = "98式突击步枪";
                break;
            case HIGH_END:
                armsName = "原子弹";
                break;
            default:
                armsName = "杂草";
                break;
        }
        setName(armsName);
        return getCountry() + "的" + getType().getNote() + "：" + getName();
    }

}
