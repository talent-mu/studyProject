package concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import pattern.singleton.Singleton1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zmh
 * @create 2017-10-10 17:04
 **/
public class CyclicBarrierDemo {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(100);
        for (int i = 0; i < 100; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(System.currentTimeMillis() + "：" + Singleton1.getInstance());
                }
            }).start();
        }
        System.out.println("hahah");

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        ExecutorService singleThreadPool = new ThreadPoolExecutor(1,
                1,
                0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024),
                namedThreadFactory,
                new ThreadPoolExecutor.AbortPolicy());

        singleThreadPool.execute(() -> System.out.println(Thread.currentThread().getName()));
        singleThreadPool.shutdown();
    }
}
