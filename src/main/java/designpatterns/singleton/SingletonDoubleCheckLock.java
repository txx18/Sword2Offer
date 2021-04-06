package designpatterns.singleton;

/**
 * @author ShaneTang
 * @create 2021-03-02 0:46
 */
public final class SingletonDoubleCheckLock {

    private static volatile SingletonDoubleCheckLock instance = null; // volatile加读写屏障

    private SingletonDoubleCheckLock() {

    }

    /**
     * 等价写法
     *
     * @return
     */
    public static SingletonDoubleCheckLock getInstance2() {
        if (instance != null) { // 这行代码不受同步代码块约束
            return instance;
        }
        synchronized (SingletonDoubleCheckLock.class) {
            if (instance != null) {
                return instance;
            }
            // new
            // dup
            // invokespecial
            // putstatic
            instance = new SingletonDoubleCheckLock(); // 可能指令重排
            return instance;
        }
    }
}
