package org.lhpsn.base.designpattern.factory.method;

/**
 * 朝鲜黑市
 *
 * @Author: lihong
 * @Date: 2018/8/15
 * @Description
 */
public class NorthKoreaBlackMarket implements BlackMarket {

    @Override
    public Arms doSmuggling(ArmsType armsType) {
        return new NorthKoreaArms(armsType);
    }
}
