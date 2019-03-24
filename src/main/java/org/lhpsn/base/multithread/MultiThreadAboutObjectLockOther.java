package org.lhpsn.base.multithread;

/**
 * 关于多线程的对象锁（另一种输出方式）
 *
 * @author http://redspider.group:4000/article/01/5.html
 * @since 1.0.0
 */
public class MultiThreadAboutObjectLockOther {

    public static void main(String[] args) {
        // 交替输出
        new Thread(new ThreadA()).start();
        new Thread(new ThreadB()).start();

        // notify()方法会随机叫醒一个正在等待的线程
        // wait()方法让自己进入等待状态，同时释放锁
        // 等待/通知机制适用与同一个对象锁的情况
    }

    private static final Object lock = new Object();

    static class ThreadA implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    try {
                        System.out.println("Thread A " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }

    static class ThreadB implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 100; i++) {
                    try {
                        System.out.println("Thread B " + i);
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }
    }
}