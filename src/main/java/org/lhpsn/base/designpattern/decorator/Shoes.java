package org.lhpsn.base.designpattern.decorator;

/**
 * 鞋子
 *
 * @Author: lihong
 * @Date: 2018/8/14
 * @Description
 */
public class Shoes implements DressUpDecorator {

    private DressUp dressUp;

    public Shoes(DressUp dressUp) {
        this.dressUp = dressUp;
    }

    @Override
    public double getValue() {
        return dressUp.getValue() + 1500;
    }

    @Override
    public String getDescription() {
        return dressUp.getDescription() + " + " + "鞋子";
    }
}
