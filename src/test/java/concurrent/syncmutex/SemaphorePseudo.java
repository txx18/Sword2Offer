package concurrent.syncmutex;

import java.util.List;

/**
 * @author ShaneTang
 * @create 2021-05-30 15:33
 */
public class SemaphorePseudo {
    int lock = 1;
    int empty = 5;
    int full = 0;

    class Mutex {
        int lock = 1;

        /**
         * 信号量实现互斥
         */
        public void mutex() {
            while (true) {
                Semaphore.wait(lock);
                // 临界区...
                Semaphore.signal(lock);
                // 剩余区...
            }
        }

    }

    class Producer {

        void produce() {
            while (true) {
                Semaphore.wait(empty);
                Semaphore.wait(lock);
                // 临界区... 生产
                Semaphore.signal(lock);
                Semaphore.signal(full);

            }
        }
    }

    class Consumer {
        void consume() {
            while (true) {
                Semaphore.wait(full);
                Semaphore.wait(lock);
                // 临界区... 消费
                Semaphore.signal(lock);
                Semaphore.signal(empty);
            }
        }
    }

    static class Semaphore {

        public static void wait(int s) {
            while (s <= 0) {
                ;
            }
            s--;
        }

        public static void signal(int s) {
            s++;
        }
    }

    static class SemaphoreBlock {

        static class Semaphore {

            int value;

            List processList;
        }

        public static void wait(Semaphore semaphore) {
            semaphore.value--;
            if (semaphore.value < 0) {
                block();
            }
        }

        public static void signal(Semaphore semaphore) {
            semaphore.value++;
            if (semaphore.value <= 0) {
                wakeup();
            }
        }

        private static void wakeup() {
            // 从s.processList取出一个进程
        }

        private static void block() {
            // 把当前进程加到 s.processList中
        }
    }
}
