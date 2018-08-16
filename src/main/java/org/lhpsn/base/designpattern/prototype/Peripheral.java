package org.lhpsn.base.designpattern.prototype;

import java.io.Serializable;

/**
 * 外设
 *
 * @Author: lihong
 * @Date: 2018/8/16
 * @Description 注意这里要实现Serializable接口，不然克隆时报错NotSerializableException
 */
public class Peripheral implements Serializable {

    /**
     * 键盘
     */
    private String keyboard;

    /**
     * 鼠标
     */
    private String mouse;

    public Peripheral() {
    }

    public Peripheral(String keyboard, String mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    @Override
    public String toString() {
        return "Peripheral{" +
                "keyboard='" + keyboard + '\'' +
                ", mouse='" + mouse + '\'' +
                '}';
    }
}
