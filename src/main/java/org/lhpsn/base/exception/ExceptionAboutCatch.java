package org.lhpsn.base.exception;

/**
 * 关于异常捕获原则
 *
 * @author lh
 * @since 1.0.0
 */
public class ExceptionAboutCatch {

    public static void main(String[] args) throws Exception {
        try {
            try {
                throw new Son();
            } catch (Parent a) {
                // 里氏替换原则，父类能做更多
                System.out.println("Caught Parent");
                throw a;
            }
        } catch (Son s) {
            System.out.println("Caught Son");
            return;
        } finally {
            System.out.println("Hello World!");
        }
    }
}

class Parent extends Exception {
}

class Son extends Parent {
}