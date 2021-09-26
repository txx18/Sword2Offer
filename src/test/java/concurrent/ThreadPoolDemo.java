package concurrent;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author ShaneTang
 * @create 2021-06-01 16:54
 */
public class ThreadPoolDemo {

    @Test
    public void testConstruct() {
        ExecutorService executorService = new ThreadPoolExecutor(3,
                10,
                120,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10));
        executorService.execute(() -> {
            System.out.println("executorService = " + executorService);
        });
    }

    @Test
    public void testFixed() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(() -> {
            System.out.println("executorService = " + executorService);
        });
    }

    @Test
    public void testCached() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            System.out.println("executorService = " + executorService);
        });
    }

    @Test
    public void testSingle() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            System.out.println("executorService = " + executorService);
        });
    }


}
