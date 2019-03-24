package org.lhpsn.base.multithread;

/**
 * 关于多线程的状态
 *
 * @author http://redspider.group:4000/article/01/4.html
 * @since 1.0.0
 */
public class MultiThreadAboutState {

    public static void main(String[] args) {
        new MultiThreadAboutState().blockedTest();

        // 已知会有三种情况

        // a:RUNNABLE
        // b:RUNNABLE
        // 这种是两个线程在start后，还没等两个线程真正开始争夺锁，就打印了

        // a:RUNNABLE
        // b:TIMED_WAITING
        // a线程start后为开始争夺锁，b线程争夺到锁执行中并且超时等待

        // a:RUNNABLE
        // b:BLOCKED
        // a线程start后为开始争夺锁，b线程等锁（打印a后，打印b前，a争夺到了锁，故b等待）
    }

    private void blockedTest() {
        Thread a = new Thread(this::testMethod, "a");
        Thread b = new Thread(this::testMethod, "b");
        a.start();
        b.start();
        System.out.println(a.getName() + ":" + a.getState());
        System.out.println(b.getName() + ":" + b.getState());
    }

    // 同步方法争夺锁
    private synchronized void testMethod() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
