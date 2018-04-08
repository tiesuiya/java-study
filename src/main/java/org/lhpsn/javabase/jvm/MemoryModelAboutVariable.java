package org.lhpsn.javabase.jvm;

import java.util.Random;

/**
 * 关于变量的内存模型
 *
 * @author lh
 * @since 1.0.0
 */
public class MemoryModelAboutVariable {

    public static void main(String[] args) throws InterruptedException {
        // 当寄存器还未在内存中赋值时读取，会读取到之前的值。可以通过volatile解决
        while (true) {
            MemoryModelAboutVariable variable = new MemoryModelAboutVariable();
            Thread thread1 = variable.createThread1();
            Thread thread2 = variable.createThread2();
            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            System.out.println("(" + variable.aRead + ", " + variable.bRead + ")");
            if (variable.aRead == 0 && variable.bRead == 0) {
                throw new RuntimeException("成了！");
            }
        }
    }

    private int a, b, aRead, bRead;

    /**
     * sleep random 3
     */
    private void sleep() {
        try {
            Thread.sleep(new Random().nextInt(3));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

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

}
