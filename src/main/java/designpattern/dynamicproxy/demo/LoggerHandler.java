package designpattern.dynamicproxy.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ShaneTang
 * @create 2021-05-20 22:23
 */
public class LoggerHandler implements InvocationHandler {

    private Object target;

    public LoggerHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Logger.startLog();
        Object result = method.invoke(target, args);
        Logger.endLog();
        return result;
    }
}
