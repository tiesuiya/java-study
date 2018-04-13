package org.lhpsn.base.multithread;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 关于多线程的固定线程池
 *
 * @author lh
 * @since 1.0.0
 */
public class FixedThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("创建一个线程数量为3的固定线程池，并添加10个任务：");

        ExecutorService pool = Executors.newFixedThreadPool(3);

        List<Future<?>> futures = new LinkedList<>();
        int len = 10;
        for (int i = 0; i < len; i++) {
            futures.add(pool.submit(new Task(i)));
        }

        // 非必须
        for (Future<?> future : futures) {
            // 执行成功返回null
            future.get();
        }
        pool.shutdown();

        /*
        // 编码规范推荐的方式
        ThreadFactory nameThreadFactory = new ThreadFactoryBuilder().setNameFormat("pool-%d").build();
        ExecutorService pool = new ThreadPoolExecutor(
                3,
                200,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024),
                nameThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());
                */
    }

}

/**
 * Task
 */
class Task implements Runnable {

    private final int codingId;

    public Task(int codingId) {
        this.codingId = codingId;
    }

    /**
     * work
     */
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Task Over:" + codingId);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

