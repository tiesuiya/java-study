package org.lhpsn.base.designpattern;

/**
 * 单例模式
 *
 * @author lh
 * @since 1.0.0
 */
public class SingletonPattern {

    public static void main(String[] args) {

        System.out.print("Lazy way to get two identical objects:");
        System.out.println(SingletonLazy.getInstance() == SingletonLazy.getInstance());

        System.out.print("Hungry way to get two identical objects:");
        System.out.println(SingletonHungry.getInstance() == SingletonHungry.getInstance());
    }
}

/**
 * Lazy way
 */
class SingletonLazy {

    private static SingletonLazy instance = new SingletonLazy();

    private SingletonLazy() {
    }

    public static SingletonLazy getInstance() {
        return instance;
    }
}

/**
 * Hungry way
 */
class SingletonHungry {

    private static SingletonHungry instance = null;

    private SingletonHungry() {
    }

    public synchronized static SingletonHungry getInstance() {
        if (instance == null) {
            instance = new SingletonHungry();
        }
        return instance;
    }
}