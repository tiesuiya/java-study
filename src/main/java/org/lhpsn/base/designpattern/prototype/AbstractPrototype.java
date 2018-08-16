package org.lhpsn.base.designpattern.prototype;

import java.io.Serializable;

/**
 * 原型类
 *
 * @Author: lihong
 * @Date: 2018/8/16
 * @Description
 */
public abstract class AbstractPrototype implements Cloneable, Serializable {

    /**
     * 具备clone能力
     *
     * @return 对象原型
     */
    @Override
    protected abstract AbstractPrototype clone() throws CloneNotSupportedException;
}
