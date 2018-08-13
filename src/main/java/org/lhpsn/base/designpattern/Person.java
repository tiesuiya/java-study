package org.lhpsn.base.designpattern;

/**
 * @Author: lihong
 * @Date: 2018/8/13
 * @Description
 */
public class Person {

    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public void sayName() {
        System.out.println("被绿的了" + name);
    }
}

abstract class AbstractClothes extends Person {

    private Person component;

    public void wear(Person person2) {
        this.component = person2;
    }

    public void show() {
        component.sayName();
    }
}

class TShirt extends AbstractClothes {

    @Override
    public void show() {
        System.out.println("T恤");
    }
}

class Cap extends AbstractClothes {
    @Override
    public void show() {
        System.out.println("帽子");
    }
}

class Pants extends AbstractClothes {

    @Override
    public void show() {
        System.out.println("胖次");
    }
}

class Shoes extends AbstractClothes {

    @Override
    public void show() {
        System.out.println("鞋子");
    }
}


