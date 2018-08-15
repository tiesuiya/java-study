package org.lhpsn.base.designpattern.proxy;

/**
 * 微商代购
 *
 * @Author: lihong
 * @Date: 2018/8/15
 * @Description
 */
public class MicroBusinessProxy implements Sale {

    /**
     * 微商账户
     */
    private double money;

    /**
     * 代理商家
     */
    private Sale sale;

    public MicroBusinessProxy(Sale sale) {
        this.sale = sale;
    }

    @Override
    public void salePhone(Customer customer) {
        // 中间商赚差价
        double proxyPrice = 2000;
        // 实际价格
        double phonePrice = 5000;
        double customerMoney = customer.getMoney() - proxyPrice - phonePrice;
        if (customerMoney >= 0) {
            // 购买成功
            this.money += proxyPrice;
            customer.setMoney(customerMoney);
            // 执行代理代码
            sale.salePhone(customer);
        } else {
            // 购买失败
            System.out.println("用户钱不够了！");
        }
    }

    @Override
    public String toString() {
        return "代理商账户：\t￥" + money;
    }
}
