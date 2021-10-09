package designpattern.dynamicproxy;

import designpattern.dynamicproxy.staticproxy.HelloWorld;
import designpattern.dynamicproxy.staticproxy.HelloWorldProxy;
import designpattern.dynamicproxy.staticproxy.IHelloWorld;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ShaneTang
 * @create 2021-05-20 22:30
 */
public class Client {

    @Test
    public void testStaticProxy() {
        HelloWorldProxy proxy = new HelloWorldProxy();
        proxy.sayHello();
    }

    @Test
    public void testProxy1() {
        // 想创建HelloWorld的新类，必须得有接口
        IHelloWorld hw = new HelloWorld();
        ICalculator calculator = new Calculator();
        // 把被代理类扔进一个InvocationHandler的实现类
        InvocationHandler loggerHandler1 = new LoggerHandler(hw);
        InvocationHandler loggerHandler2 = new LoggerHandler(calculator);

        // newProxyInstance创建一个代理对象 强转 IHelloWorld接口
        IHelloWorld hwProxy = (IHelloWorld) Proxy.newProxyInstance(
                // 代理类的类加载器
                Thread.currentThread().getContextClassLoader(),
                // 被代理类需要实现的接口
                hw.getClass().getInterfaces(),
                // InvocationHandler
                loggerHandler1);
        ICalculator calProxy = (ICalculator) Proxy.newProxyInstance(
                // 代理类的类加载器
                Thread.currentThread().getContextClassLoader(),
                // 被代理类需要实现的接口
                calculator.getClass().getInterfaces(),
                // InvocationHandler
                loggerHandler2);
        hwProxy.sayHello();
        calProxy.add(1, 2);
    }

    @Test
    public void testProxy2() {
        ICalculator calculator = new Calculator();
        ICalculator calProxy = (ICalculator) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                calculator.getClass().getInterfaces(),
                // 匿名内部类InvocationHandler
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
