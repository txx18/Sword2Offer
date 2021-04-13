package designpatterns.singleton.lazy;

/**
 * @author ShaneTang
 * @create 2021-03-02 0:46
 */
public final class SingletonLockClassOrMethod {

    private static SingletonLockClassOrMethod instance;

    private SingletonLockClassOrMethod() {

    }

    /**
     * synchronized加载方法上
     *
     * @return
     */
    public static synchronized SingletonLockClassOrMethod getInstanceStyle1() {
        if (instance != null) {
            return instance;
        }
        // 注意这里要先复制给静态成员变量，不能直接return new 啊
        instance = new SingletonLockClassOrMethod();
        return instance;
/*        if (instance == null) {
            instance = new SingletonLockClassOrMethod();
        }
        return instance;*/
    }

    /**
     * 锁住Class对象
     *
     * @return
     */
    public static SingletonLockClassOrMethod getInstanceStyle2() {
        // t1线程每次都得进入同步代码块
        synchronized (SingletonLockClassOrMethod.class) {
            if (instance != null) {
                return instance;
            }
            instance = new SingletonLockClassOrMethod();
            return instance;
        }
    }
}
