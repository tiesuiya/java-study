package org.lhpsn.base.designpattern.factory.method;

/**
 * 黑市
 *
 * @Author: lihong
 * @Date: 2018/8/15
 * @Description
 */
public interface BlackMarket {

    /**
     * 走私军火
     *
     * @param armsType 军火类型
     * @return 军火
     */
    Arms doSmuggling(ArmsType armsType);
}
