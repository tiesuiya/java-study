package org.lhpsn.base.designpattern.decorator;

/**
 * 人
 *
 * @Author: lihong
 * @Date: 2018/8/14
 * @Description
 */
public class Person implements DressUp {

    @Override
    public double getValue() {
        return 0;
    }

    @Override
    public String getDescription() {
        return "果体";
    }
}
