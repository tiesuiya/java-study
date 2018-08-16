package org.lhpsn.base.designpattern.prototype;

/**
 * 原型模式
 *
 * @Author: lihong
 * @Date: 2018/8/16
 * @Description
 */
public class Application {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.setCpu("因特");
        computer.setDisk("三丧");
        computer.setMemory("紫琪");
        computer.setPeripheral(new Peripheral("硬桃", "达尔有"));

        // clone：应用原型模式
        Computer computer1 = computer.clone();
        computer1.setPeripheral(new Peripheral("Cherry", "DaErU"));

        System.out.println(computer);
        System.out.println(computer1);

    }
}
