package threadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Basic {
    public static void main(String args[]) {

        int coreNo = Runtime.getRuntime().availableProcessors();
        int queueNo = 10;
        BlockingQueue queue = new LinkedBlockingQueue(queueNo);

        System.out.println("the core num:\r\n" + coreNo);
        ThreadFactory factory = new ThreadFactory() {
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        };
        RejectedExecutionHandler handler = new RejectedExecutionHandler() {
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

                System.out.println("reject accept\r\n");
            }
        };

        ExecutorService executor = new ThreadPoolExecutor(coreNo/2 + 1, coreNo, 5, TimeUnit.SECONDS, queue, factory, handler);

        for (int i = 0; i < 100; i++) {
            executor.submit(new Runnable() {
                public void run() {
                    long sum = 0;
                    for (int j = 0; j < 10000; j++) {
                        sum += j;
                    }
                }
            });
        }
        executor.shutdown();
    }
}
