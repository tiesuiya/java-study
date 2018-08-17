package org.lhpsn.base.lambda;


/**
 * lambda简单入门
 *
 * @Author: lihong
 * @Date: 2018/8/17
 * @Description 教程来自：http://www.runoob.com/java/java8-lambda-expressions.html
 */
public class LambdaAboutSimple {

    public static void main(String[] args) {
        LambdaAboutSimple tester = new LambdaAboutSimple();

        // 类型声明
        MathOperation addition = (int a, int b) -> a + b;

        // 不用类型声明
        MathOperation subtraction = (a, b) -> a - b;

        // 大括号中的返回语句
        MathOperation multiplication = (int a, int b) -> {
            return a * b;
        };

        // 没有大括号及返回语句
        MathOperation division = (int a, int b) -> a / b;

        System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
        System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
        // 也可以这样写
        System.out.println("10 x 5 = " + multiplication.operation(10, 5));
        System.out.println("10 / 5 = " + division.operation(10, 5));

        // 不用括号
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // 用括号
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Runoob");
        greetService2.sayMessage("Google");
    }

    interface MathOperation {
        int operation(int a, int b);
    }

    interface GreetingService {
        void sayMessage(String message);
    }

    private int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operation(a, b);
    }
}
