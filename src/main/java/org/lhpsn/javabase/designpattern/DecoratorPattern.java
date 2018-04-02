package org.lhpsn.javabase.designpattern;

import org.lhpsn.javabase.common.CodingTask;
import org.lhpsn.javabase.common.LoggingRunnable;
import org.lhpsn.javabase.common.TransactionRunnable;

/**
 * Decorator Pattern
 *
 * @author lh
 * @since 1.0.0
 */
public class DecoratorPattern {

    public static void main(String[] args) {
        new LoggingRunnable(
                new TransactionRunnable(
                        new CodingTask(0))).run();
    }
}


