package org.lhpsn.base.designpattern;

/**
 * Decorator Pattern
 *
 * @author lh
 * @since 1.0.0
 */
public class DecoratorPattern {

    public static void main(String[] args) {

        System.out.println("Run task by decorator pattern:");
        new LoggingRunnable(
                new TransactionRunnable(
                        new CodingTask())).run();
    }
}

/**
 * Transaction runnable
 */
class TransactionRunnable implements Runnable {

    private final Runnable runnable;

    TransactionRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    /**
     * transaction
     */
    @Override
    public void run() {
        System.out.println("transaction begin...");
        runnable.run();
        System.out.println("transaction end...");
    }
}

/**
 * Logging runnable
 */
class LoggingRunnable implements Runnable {

    private final Runnable runnable;

    LoggingRunnable(Runnable runnable) {
        this.runnable = runnable;
    }

    /**
     * logging
     */
    @Override
    public void run() {
        System.out.println("logging begin...");
        runnable.run();
        System.out.println("logging end...");
    }
}

/**
 * Coding task
 */
class CodingTask implements Runnable {

    /**
     * work
     */
    @Override
    public void run() {
        try {
            System.out.println("Coding Begin...");
            Thread.sleep(3000);
            System.out.println("Coding End...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



