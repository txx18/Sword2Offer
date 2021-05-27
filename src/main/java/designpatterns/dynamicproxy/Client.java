package designpatterns.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * @author ShaneTang
 * @create 2021-05-20 22:30
 */
public class Client {

    public static void main(String[] args) {
        IHelloWorld hw = new HelloWorld();
        LoggerHandler loggerHandler = new LoggerHandler(hw);
        // newProxyInstance 出一个代理对象
        IHelloWorld proxy = (IHelloWorld) Proxy.newProxyInstance(
                Thread.currentThread().getContextClassLoader(),
                hw.getClass().getInterfaces(),
                loggerHandler);
        proxy.sayHello();

        ICalculator calculator = new Calculator();
        loggerHandler = new LoggerHandler(calculator);
        ICalculator calProxy = (ICalculator) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), calculator.getClass().getInterfaces(),
                loggerHandler);
        calProxy.add(1, 2);
    }

}
