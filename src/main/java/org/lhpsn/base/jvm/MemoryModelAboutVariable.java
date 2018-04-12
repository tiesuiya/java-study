package org.lhpsn.base.jvm;

import java.util.Random;

/**
 * 关于变量的内存模型
 *
 * @author lh
 * @since 1.0.0
 */
public class MemoryModelAboutVariable {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("正常情况下是不会出现了(0, 0)的情况的，但是在多线程环境就可能了：");

        // 当寄存器还未在内存中赋值时读取，会读取到之前的值。可以通过volatile解决，这样就遵循了happens-before原则了
        while (true) {
            MemoryModelAboutVariable variable = new MemoryModelAboutVariable();
            Thread thread1 = variable.createThread1();
            Thread thread2 = variable.createThread2();
            thread1.start();
            thread2.start();

            // join()：当前线程等待join线程结束
            thread1.join();
            thread2.join();

            System.out.println("(" + variable.aRead + ", " + variable.bRead + ")");
            if (variable.aRead == 0 && variable.bRead == 0) {
                throw new RuntimeException("出现了(0, 0)了！");
            }
        }
    }

    /**
     * 本类成员变量
     */
    private int a, b, aRead, bRead;

    /**
     * 创建一个线程1
     *
     * @return 线程1
     */
    public Thread createThread1() {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                sleep();
                a = 1;
                bRead = b;
            }
        });
    }

    /**
     * 创建一个线程2
     *
     * @return 线程2
     */
    public Thread createThread2() {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                sleep();
                b = 1;
                aRead = a;
            }
        });
    }

    /**
     * private sleep random 3
     */
    private void sleep() {
        try {
            Thread.sleep(new Random().nextInt(3));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
