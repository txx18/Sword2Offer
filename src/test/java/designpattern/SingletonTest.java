package designpattern;

import designpattern.singleton.lazy.SingletonEnum;
import designpattern.singleton.hungry.SingletonStaticMember;
import designpattern.singleton.lazy.SingletonDoubleCheckLock;
import designpattern.singleton.lazy.SingletonLockClassOrMethod;
import designpattern.singleton.lazy.SingletonStaticInnerClass;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author ShaneTang
 * @create 2021-04-09 21:54
 */
public class SingletonTest {

    @Test
    public void testEnum() {
        // 返回枚举类对象，枚举类对象是单例
        SingletonEnum instance1 = SingletonEnum.INSTANCE;
        SingletonEnum instance2 = SingletonEnum.INSTANCE;
        System.out.println(instance1 == instance2);
    }

    @Test
    public void testStaticMember() {
        SingletonStaticMember instance1 = SingletonStaticMember.getInstance();
        SingletonStaticMember instance2 = SingletonStaticMember.getInstance();
        System.out.println(instance1 == instance2);
    }

    @Test
    public void testStaticInnerClass() {
        SingletonStaticInnerClass instance1 = SingletonStaticInnerClass.getInstance();
        SingletonStaticInnerClass instance2 = SingletonStaticInnerClass.getInstance();
        System.out.println(instance1 == instance2);
    }

    @Test
    public void testLockClassOrMethod() {
        SingletonLockClassOrMethod instance1 = SingletonLockClassOrMethod.getInstanceStyle1();
        SingletonLockClassOrMethod instance2 = SingletonLockClassOrMethod.getInstanceStyle1();
        SingletonLockClassOrMethod instance3 = SingletonLockClassOrMethod.getInstanceStyle2();
        SingletonLockClassOrMethod instance4 = SingletonLockClassOrMethod.getInstanceStyle2();
        // ??居然提示总为true
        System.out.println(instance1 == instance2);
        System.out.println(instance3 == instance4);
    }

    @Test
    public void testDCL() throws ExecutionException, InterruptedException {
        for (int i = 0; i < 100000; i++) {
            FutureTask<SingletonDoubleCheckLock> futureTask = new FutureTask<>(() -> {
                return SingletonDoubleCheckLock.getInstance();
            });
            Thread t1 = new Thread(futureTask);
            t1.start();
            SingletonDoubleCheckLock instance1 = futureTask.get();

            SingletonDoubleCheckLock instance2 = SingletonDoubleCheckLock.getInstance();
//            System.out.println(instance1 == instance2);
            if (instance1 != instance2) {
                System.out.println("oops");
                break;
            }
        }
        System.out.println("finish");

    }
}
