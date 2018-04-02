package org.lhpsn.javabase.multithread;

import org.lhpsn.javabase.common.CodingTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 关于多线程的固定线程池
 *
 * @author lh
 * @since 1.0.0
 */
public class FixedThreadPool {

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        int len = 10;
        for (int i = 0; i < len; i++) {
            pool.submit(new CodingTask(i));
        }
        pool.shutdown();

// 编码规范推荐的方式
//        ThreadFactory nameThreadFactory = new ThreadFactoryBuilder().setNameFormat("pool-%d").build();
//        ExecutorService pool = new ThreadPoolExecutor(
//                3,
//                200,
//                0L,
//                TimeUnit.MILLISECONDS,
//                new LinkedBlockingQueue<Runnable>(1024),
//                nameThreadFactory,
//                new ThreadPoolExecutor.AbortPolicy());
    }

}
