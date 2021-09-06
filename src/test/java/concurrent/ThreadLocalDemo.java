package concurrent;

/**
 * @author ShaneTang
 * @create 2021-05-31 9:30
 */
public class ThreadLocalDemo {

    static class Context {

        private static final ThreadLocal<String> mThreadLocal = new ThreadLocal<>();

        public static void setTrackerID(String id) {
            mThreadLocal.set(id);
        }

        public static String getTrackerID() {
            return mThreadLocal.get();
        }
    }


}
