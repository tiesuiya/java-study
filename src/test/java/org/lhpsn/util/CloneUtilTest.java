package org.lhpsn.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.Serializable;

/**
 * 克隆测试
 *
 * @author lh
 * @since 1.0.0
 */
public class CloneUtilTest {

    @Test
    public void testClone() throws Exception {
        Car car = new Car("Benz", 300);
        Person person1 = new Person("Hao LUO", 33, car);
        // 深度克隆
        Person person2 = CloneUtil.clone(person1);
        person2.getCar().setBrand("BYD");

        // p1关联的汽车不会受到任何影响
        Assert.assertTrue("Benz".equals(person1.getCar().getBrand()));
    }
}

/**
 * 小汽车类
 */
class Car implements Serializable {

    private String brand;       // 品牌
    private int maxSpeed;       // 最高时速

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

    private String name;    // 姓名
    private int age;        // 年龄
    private Car car;        // 座驾

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
