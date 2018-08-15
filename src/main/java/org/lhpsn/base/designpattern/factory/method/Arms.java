package org.lhpsn.base.designpattern.factory.method;

/**
 * 军火
 *
 * @Author: lihong
 * @Date: 2018/8/15
 * @Description
 */
public abstract class Arms {

    /**
     * 名称
     */
    private String name;

    /**
     * 国家
     */
    private String country;

    /**
     * 类型
     */
    private ArmsType type;

    /**
     * 展示信息
     *
     * @return
     */
    abstract String getInfo();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArmsType getType() {
        return type;
    }

    public void setType(ArmsType type) {
        this.type = type;
    }
}
