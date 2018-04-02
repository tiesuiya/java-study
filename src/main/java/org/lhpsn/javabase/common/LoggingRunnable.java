package org.lhpsn.javabase.common;

/**
 * Logging runnabler
 *
 * @author lh
 * @since 1.0.0
 */
public class LoggingRunnable implements Runnable {

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