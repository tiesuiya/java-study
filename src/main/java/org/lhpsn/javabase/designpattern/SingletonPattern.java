package org.lhpsn.javabase.designpattern;

/**
 * Singleton Pattern
 *
 * @author lh
 * @since 1.0.0
 */
public class SingletonPattern {

    public static void main(String[] args) {
        SingletonLazy singletonLazy1 = SingletonLazy.getInstance();
        SingletonLazy singletonLazy2 = SingletonLazy.getInstance();
        SingletonHungry singletonHungry1 = SingletonHungry.getInstance();
        SingletonHungry singletonHungry2 = SingletonHungry.getInstance();
        System.out.println(singletonLazy1);
        System.out.println(singletonLazy2);
        System.out.println(singletonHungry1);
        System.out.println(singletonHungry2);
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