package concurrent.syncmutex;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ShaneTang
 * @create 2021-05-30 10:04
 */
public class CASDemo {

    static class Test {
        public static void main(String[] args) {
            SequenceSynchronized obj1 = new SequenceSynchronized();
            obj1.value = 0;
            Thread t1 = new Thread(() -> {
                System.out.println();
                int next = obj1.next();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ": next = " + next);
            });

            t1.start();

            Thread t2 = new Thread(() -> {
                int next = obj1.next();
                System.out.println(Thread.currentThread().getName() + ": next = " + next);
            });

            t2.start();


//            SequenceCompareAndSwap obj2 = new SequenceCompareAndSwap();
//            System.out.println("obj2.next() = " + obj2.next());

        }
    }

    static class SequenceSynchronized {
        /**
         * 共享变量
         */
        private volatile int value;

        /**
         * 悲观锁访问共享变量
         *
         * @return
         */
        public int next() {
            value++;
            return value;
        }
    }

    static class SequenceCompareAndSwap {

        private AtomicInteger countInMemory = new AtomicInteger(0);

        public int next() {
            while (true) {
                // 获取内存值
                int cur = countInMemory.get();
                // 准备写入的值
                int next = cur + 1;
                // （此时countInMemory可能被别人改过）
                // compare内存值countInMemory是否和cur不相等，不相等就继续循环；否则相等就原子操作set并返回
                if (countInMemory.compareAndSet(cur, next)) {
                    return next;
                }
            }
        }
    }


}
