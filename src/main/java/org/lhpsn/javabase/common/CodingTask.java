package org.lhpsn.javabase.common;

/**
 * Coding task
 *
 * @author lh
 * @since 1.0.0
 */
public class CodingTask implements Runnable {

    private final int codingId;

    public CodingTask(int codingId) {
        this.codingId = codingId;
    }

    /**
     * work
     */
    @Override
    public void run() {
        try {
            System.out.println("Coding " + codingId + " Begin...");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
