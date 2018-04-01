package org.lhpsn.javabase.designpattern.decorator;

/**
 * Decorator Pattern Test
 *
 * @author lh
 * @since 1.0.0
 */
public class Aain {

    public static void main(String[] args) {
        new LoggingRunnable(
                new TransactionRunnable(
                        new CodingTask())).run();
    }
}
