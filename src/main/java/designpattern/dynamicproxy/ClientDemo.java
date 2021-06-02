package designpattern.dynamicproxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ShaneTang
 * @create 2021-05-20 22:30
 */
public class ClientDemo {


    @Test
    public void testProxy1() {
        // 想创建HelloWorld的新类，必须得有接口
        IHelloWorld hw = new HelloWorld();
        // 把被代理类扔进一个InvocationHandler的实现类
        InvocationHandler loggerHandler = new LoggerHandler(hw);
        // newProxyInstance创建一个代理对象 强转 IHelloWorld接口
        IHelloWorld proxy = (IHelloWorld) Proxy.newProxyInstance(
                // 代理类的类加载器
                Thread.currentThread().getContextClassLoader(),
                // 被代理类需要实现的接口
                hw.getClass().getInterfaces(),
                // InvocationHandler
                loggerHandler);
        proxy.sayHello();
    }

    @Test
    public void testProxy2() {
        ICalculator calculator = new Calculator();
        ICalculator calProxy = (ICalculator) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                calculator.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Logger.startLog();
                        // 反射调用 calculator对象 的方法
                        Object result = method.invoke(calculator, args);
                        Logger.endLog();
                        return result;
                    }
                });
        calProxy.add(1, 2);
        calProxy.sub(1, 2);
    }

}
