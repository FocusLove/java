package lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 栅栏的基本用法实例
 */
public class Barrier {

    public static void main(String args[]) {
        /**
         * 循环栅栏，可用于线程同步
         * 此处的parties参数为多少就表示多少个线程为一组同步；但是哪几个线程为一个同步组不确定
         * 因为await的实现是可重入锁的不公平锁
         */
        final CyclicBarrier barrier = new CyclicBarrier(2);

        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new Runnable() {
                public void run() {
                    try {
                        System.out.println("thread##" + Thread.currentThread().getName() + ":begin");
                        barrier.await();
                        System.out.println("thread##" + Thread.currentThread().getName() + ":end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }, "thread##" + i);

            t.start();

        }
    }
}
