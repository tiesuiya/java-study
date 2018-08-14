package org.lhpsn.base.designpattern.decorator;

/**
 * 帽子
 *
 * @Author: lihong
 * @Date: 2018/8/14
 * @Description
 */
public class Cap implements DressUpDecorator {

    private DressUp dressUp;

    public Cap(DressUp dressUp) {
        this.dressUp = dressUp;
    }

    @Override
    public double getValue() {
        return dressUp.getValue() + 5;
    }

    @Override
    public String getDescription() {
        return dressUp.getDescription() + " + " + "帽子";
    }
}
