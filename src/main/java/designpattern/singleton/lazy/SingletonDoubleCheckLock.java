package designpattern.singleton.lazy;

/**
 * @author ShaneTang
 * @create 2021-03-02 0:46
 */
public final class SingletonDoubleCheckLock {

    /**
     *  volatile加读写屏障
     *  final 和 volatile 不能共存
     */
    private static volatile SingletonDoubleCheckLock instance = null;

    private SingletonDoubleCheckLock() {

    }

    public static SingletonDoubleCheckLock getInstance() {
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
