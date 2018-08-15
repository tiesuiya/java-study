package org.lhpsn.base.designpattern.proxy;

/**
 * 商家
 *
 * @Author: lihong
 * @Date: 2018/8/15
 * @Description
 */
public class Business implements Sale {

    /**
     * 商家账户
     */
    private double money;

    @Override
    public void salePhone(Customer customer) {
        System.out.println("欢迎用户：" + customer.getName());
        // 购买成功
        this.money += 4000;
    }

    @Override
    public String toString() {
        return "商家账户：\t￥" + money;
    }
}
