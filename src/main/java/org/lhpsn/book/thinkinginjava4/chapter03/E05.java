package org.lhpsn.book.thinkinginjava4.chapter03;

/**
 * @author tsy
 */
public class E05 {

    public static void main(String[] args) {
        // 创建两条狗
        Dog dogSpot = new Dog();
        dogSpot.name = "spot";
        dogSpot.says = "Ruff!";
        Dog dogScruffy = new Dog();
        dogScruffy.name = "scruffy";
        dogScruffy.says = "Wurf!";
        System.out.println(dogSpot.name + ":" + dogSpot.says);
        System.out.println(dogScruffy.name + ":" + dogScruffy.says);
    }

    static class Dog {
        String name;
        String says;
    }
}
