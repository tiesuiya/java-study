package org.lhpsn.base.designpattern.prototype;

import org.lhpsn.common.util.ObjectUtil;

/**
 * 电脑
 *
 * @Author: lihong
 * @Date: 2018/8/16
 * @Description
 */
public class Computer extends AbstractPrototype {

    private Peripheral peripheral;

    private String cpu;

    private String memory;

    private String disk;

    @Override
    protected Computer clone() {
        try {
            // 应用深度克隆
            return ObjectUtil.clone(this);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Peripheral getPeripheral() {
        return peripheral;
    }

    public void setPeripheral(Peripheral peripheral) {
        this.peripheral = peripheral;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "peripheral=" + peripheral +
                ", cpu='" + cpu + '\'' +
                ", memory='" + memory + '\'' +
                ", disk='" + disk + '\'' +
                '}';
    }
}
