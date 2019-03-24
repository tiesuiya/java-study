package org.lhpsn.base.multithread;

/**
 * 关于多线程的对象锁
 *
 * @author http://redspider.group:4000/article/01/5.html
 * @since 1.0.0
 */
public class MultiThreadAboutObjectLock {

    public static void main(String[] args) throws InterruptedException {
        // 控制先输出A，后输出B
        new Thread(new ThreadA()).start();
        Thread.sleep(10);
        new Thread(new ThreadB()).start();
    }

    private static final Object lock = new Object();

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Thread A " + i);
                }
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Thread B " + i);
                }
            }
        }
    }
}