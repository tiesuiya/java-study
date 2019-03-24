package org.lhpsn.book.thinkinginjava4.chapter03;

/**
 * @author tsy
 */
public class E06 {

    public static void main(String[] args) {
        // 比较==和equals区别
        Dog dogSpot = new Dog();
        dogSpot.name = "spot";
        dogSpot.says = "Ruff!";
        Dog dogNew = dogSpot;
        System.out.println(dogSpot == dogNew);
        System.out.println(dogSpot.equals(dogNew));
    }

    static class Dog {
        String name;
        String says;
    }
}
