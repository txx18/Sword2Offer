package designpatterns.singleton;

/**
 * @author ShaneTang
 * @create 2021-03-02 0:46
 */
public final class SingletonLazyLockClass {

    private static SingletonLazyLockClass instance = null;

    private SingletonLazyLockClass() {

    }

    public static synchronized SingletonLazyLockClass getInstance1() {
        if (instance == null) {
            instance = new SingletonLazyLockClass();
        }
        return instance;
    }

    /**
     * 等价写法
     *
     * @return
     */
    public static SingletonLazyLockClass getInstance2() {
        // t1线程每次都得进入同步代码块
        synchronized (SingletonLazyLockClass.class) {
            if (instance != null) {
                return instance;
            }
            instance = new SingletonLazyLockClass();
            return instance;
        }
    }
}
