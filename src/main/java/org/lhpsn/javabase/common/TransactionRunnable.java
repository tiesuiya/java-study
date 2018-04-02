
package org.lhpsn.javabase.common;

/**
 * Transaction runnable
 *
 * @author lh
 * @since 1.0.0
 */
public class TransactionRunnable implements Runnable {

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
