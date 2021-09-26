package concurrent.syncmutex;


/**
 * @author ShaneTang
 * @create 2021-05-30 15:25
 */
public class MutexPseudo {
    static class Test {

        boolean lock = false;

        /**
         * TestAndSet实现互斥
         */
        public void doSthInCritical() {
            // 自旋锁：循环 TestAndSet
            while (MutexLock.TestAndSet(lock)) {
                ;
            }
            // 临界区
            // ...
            lock = false;
            // 剩余区
            // ...

        }
    }

    static class MutexLock {
        /**
         * 在进入临界区之前， 都会调用TestAndSet,
         * 如果是 t1 先调用， lock会被置为true,  函数就会返回false, t1 就跳出了循环， 可以进行后续临界区操作了，
         * 而 t2 在调用 TestAndSet的时候，函数一直返回true,  t2 只好不停的在这里循环了。
         *
         * @param lock
         * @return
         */
        static boolean TestAndSet(boolean lock) {
            boolean rv = lock;
            lock = true; // 这两句是原子操作
            return rv;
        }

    }
}
