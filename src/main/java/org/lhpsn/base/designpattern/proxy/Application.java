package org.lhpsn.base.designpattern.proxy;

/**
 * 代理模式
 *
 * @Author: lihong
 * @Date: 2018/8/15
 * @Description
 */
public class Application {

    public static void main(String[] args) {

        Business business = new Business();
        MicroBusinessProxy proxy = new MicroBusinessProxy(business);

        // 土豪用户代购手机
        System.out.println("\n土豪用户代购手机");
        Customer aMao = new Customer("阿猫",100000);
        proxy.salePhone(aMao);
        System.out.println(business);
        System.out.println(proxy);
        System.out.println(aMao);

        // 吃土用户购买手机
        System.out.println("\n吃土用户购买手机");
        Customer aGou = new Customer("阿狗",1000);
        proxy.salePhone(aGou);
        System.out.println(business);
        System.out.println(proxy);
        System.out.println(aGou);

    }
}
