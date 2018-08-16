package org.lhpsn.base.serializable;

import org.lhpsn.common.util.ObjectUtil;

import java.io.*;

/**
 * 关于使用序列化实现对象克隆
 *
 * @author lh
 * @since 1.0.0
 */
public class SerializableAboutClone {

    public static void main(String[] args) throws Exception {

        System.out.println("使用序列化实现对象克隆：");

        Car car = new Car("Benz", 300);
        Person person1 = new Person("Hao LUO", 33, car);
        System.out.println("person1:");
        System.out.println(person1 + "\n");

        // 深度克隆
        Person person2 = ObjectUtil.clone(person1);
        System.out.println("person2:");
        System.out.println(person2 + "\n");

        System.out.println("修改person2，打印person1:");
        person2.getCar().setBrand("BYD");
        System.out.println(person1 + "\n");

        System.out.println("person1关联的汽车不会受到任何影响");
    }
}


/**
 * 小汽车类
 */
class Car implements Serializable {

    /**
     * 品牌
     */
    private String brand;

    /**
     * 最高时速
     */
    private int maxSpeed;

    public Car(String brand, int maxSpeed) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", maxSpeed=" + maxSpeed + "]";
    }

}

/**
 * 人类
 */
class Person implements Serializable {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 座驾
     */
    private Car car;

    public Person(String name, int age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", car=" + car + "]";
    }

}