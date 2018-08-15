package org.lhpsn.base.designpattern.factory.method;

/**
 * 军火类型
 *
 * @Author: lihong
 * @Date: 2018/8/15
 * @Description
 */
public enum ArmsType {

    /**
     * 高端军火
     */
    HIGH_END("高端军火"),

    /**
     * 普通军火
     */
    GENERAL("普通军火");

    private final String note;

    ArmsType(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }
}

