package org.lhpsn.base.designpattern.decorator;

/**
 * 胖次
 *
 * @Author: lihong
 * @Date: 2018/8/14
 * @Description
 */
public class Pants implements DressUpDecorator {

    private DressUp dressUp;

    /**
     * 颜色，扩展字段
     */
    private String color;

    public Pants(DressUp dressUp) {
        this.dressUp = dressUp;
    }

    public Pants(DressUp dressUp, String color) {
        this.dressUp = dressUp;
        this.color = color;
    }

    @Override
    public double getValue() {
        return dressUp.getValue() + 99;
    }

    @Override
    public String getDescription() {
        return dressUp.getDescription() + " + " + "胖次";
    }
}
