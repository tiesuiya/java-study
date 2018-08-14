package org.lhpsn.base.designpattern.decorator;

/**
 * 打扮
 *
 * @Author: lihong
 * @Date: 2018/8/14
 * @Description
 */
public interface DressUp {

    /**
     * 获取价值
     *
     * @return 价值
     */
    double getValue();

    /**
     * 获取描述
     *
     * @return 描述
     */
    String getDescription();
}
