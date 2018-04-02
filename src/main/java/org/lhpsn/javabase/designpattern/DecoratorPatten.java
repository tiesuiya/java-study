package org.lhpsn.javabase.designpattern;

/**
 * Decorator Pattern
 *
 * @author lh
 * @since 1.0.0
 */
public class DecoratorPatten {

    public static void main(String[] args) {
        new LoggingRunnable(
                new TransactionRunnable(
                        new CodingTask())).run();
    }
}

interface Runnable {

    /**
     * run method
     */
    void run();
}

class CodingTask implements Runnable {

    /**
     * work
     */
    @Override
    public void run() {
        try {
            System.out.println("Coding Begin...");
            Thread.sleep(1000);
            System.out.println("...");
            Thread.sleep(1000);
            System.out.println("...");
            Thread.sleep(1000);
            System.out.println("...");
            System.out.println("Coding Over...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class LoggingRunnable implements Runnable {

    private final Runnable runnable;

    public LoggingRunnable(Runnable runnable) {
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

class TransactionRunnable implements Runnable {

    private final Runnable runnable;

    public TransactionRunnable(Runnable runnable) {
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
