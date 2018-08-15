package org.lhpsn.base.designpattern.factory.method;

/**
 * 美国黑市
 *
 * @Author: lihong
 * @Date: 2018/8/15
 * @Description
 */
public class USABlackMarket implements BlackMarket {

    @Override
    public Arms doSmuggling(ArmsType armsType) {
        return new USAArms(armsType);
    }
}
