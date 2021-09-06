package concurrent;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ShaneTang
 * @create 2021-05-27 10:46
 */
public class NewThreadDemo {


    public class MyThread extends Thread {

        // 继承里面可以重写，不是必须重写；但是只有重写run方法才能执行
        public void run() {
            System.out.println("MyThread1");
        }
    }

    public class MyRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("MyRunnable1");
        }
    }


    public static class MyCallable implements Callable {
        @Override
        public Object call() throws Exception {
            return 123;
        }
    }

    @Test
    public void testRunnable() {
        //
        MyRunnable target = new MyRunnable();
        Thread thread = new Thread(target);
        thread.start();
        //
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("MyRunnable2");
            }
        }).start();
        //
        new Thread(() -> {
            System.out.println("MyRunnable3");
        }).start();
    }

    @Test
    public void testCallable() throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask futureTask1 = new FutureTask<>(myCallable);
        //
        FutureTask<Object> futureTask2 = new FutureTask<>(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return 234;
            }
        });

        new Thread(futureTask1).start();
        System.out.println(futureTask1.get()); // 不t.start()就ft.get()就死循环了

        new Thread(futureTask2).start();
        System.out.println(futureTask2.get());

    }

    @Test
    public void testExtends() {
        new MyThread().start();
    }
}
