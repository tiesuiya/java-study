package org.lhpsn.javabase.serializable;

import java.io.*;

/**
 * 关于使用序列化实现对象克隆
 *
 * @author lh
 * @since 1.0.0
 */
public class SerializableAboutClone {

    public static void main(String[] args) throws Exception {
        SerializableAboutClone serializableAboutClone = new SerializableAboutClone();

        Car car = new Car("Benz", 300);
        Person person1 = new Person("Hao LUO", 33, car);
        System.out.println("person1:");
        System.out.println(person1);

        // 深度克隆
        Person person2 = serializableAboutClone.clone(person1);
        System.out.println("person2:");
        System.out.println(person2);

        System.out.println("修改person2，打印person1:");
        person2.getCar().setBrand("BYD");
        System.out.println(person1);

        System.out.println("person1关联的汽车不会受到任何影响");
    }

    /**
     * 通过对象的序列化和反序列化实现克隆，可以实现真正的深度克隆
     *
     * @param obj 待克隆对象
     * @param <T> Serializable泛型限定，需要特别注意的是T所包含的对象也需要实现Serializable接口，这一点在编译时无法检查到！
     * @return 克隆对象
     * @throws Exception 克隆异常
     */
    public <T extends Serializable> T clone(T obj) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);

        // 说明：调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有任何意义
        // 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T) ois.readObject();
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