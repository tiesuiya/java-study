package org.lhpsn.base.designpattern.decorator;

/**
 * 装饰器模式
 *
 * @Author: lihong
 * @Date: 2018/8/14
 * @Description
 */
public class Application {

    public static void main(String[] args) {

        // 穿衣系统，要求计算人在打扮后的价值和描述
        // 1、人，开始没穿衣服，总价值0
        // 2、各种饰品有各种饰品的价值和描述

        DressUp dressUp1 = new Pants(new Pants(new Pants(new Person())));
        System.out.println("\n穿了三条胖次的人");
        System.out.println("价值：" + dressUp1.getValue());
        System.out.println("描述：" + dressUp1.getDescription());

        // 镶嵌了3种宝石的武器
        DressUp dressUp2 = new Cap(new Shoes(new Pants(new Person())));
        System.out.println("\n穿了三种饰品的人");
        System.out.println("价值：" + dressUp2.getValue());
        System.out.println("描述：" + dressUp2.getDescription());
    }
}

