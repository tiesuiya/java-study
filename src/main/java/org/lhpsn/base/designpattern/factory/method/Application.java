package org.lhpsn.base.designpattern.factory.method;

/**
 * 工厂方法模式
 *
 * @Author: lihong
 * @Date: 2018/8/15
 * @Description
 */
public class Application {

    public static void main(String[] args) {

        // 从美国走私
        BlackMarket blackMarket = new USABlackMarket();
        Arms arms = blackMarket.doSmuggling(ArmsType.GENERAL);
        System.out.println(arms.getInfo());
        arms = blackMarket.doSmuggling(ArmsType.HIGH_END);
        System.out.println(arms.getInfo());

        // 从朝鲜走私
        blackMarket = new NorthKoreaBlackMarket();
        arms = blackMarket.doSmuggling(ArmsType.GENERAL);
        System.out.println(arms.getInfo());
        arms = blackMarket.doSmuggling(ArmsType.HIGH_END);
        System.out.println(arms.getInfo());
    }
}
