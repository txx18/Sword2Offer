package designpatterns.singleton.lazy;

/**
 * @author ShaneTang
 * @create 2021-04-09 20:52
 */
public class SingletonStaticInnerClass {

    private SingletonStaticInnerClass() {
    }

    private static class LazyHolder {
        static final SingletonStaticInnerClass instance = new SingletonStaticInnerClass();
    }

    public static SingletonStaticInnerClass getInstance() {
        return LazyHolder.instance;
    }
}
