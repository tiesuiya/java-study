package org.lhpsn.base.designpattern.proxy;

/**
 * 网购萌新
 *
 * @Author: lihong
 * @Date: 2018/8/15
 * @Description
 */
public class Customer {

    /**
     * 名称
     */
    private String name;

    /**
     * 荷包
     */
    private double money;

    public Customer() {
    }

    public Customer(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return name + "账户：\t￥" + money;
    }
}
