package designpattern.dynamicproxy.staticproxy;

import designpattern.dynamicproxy.Logger;

public class HelloWorldProxy implements IHelloWorld {
    @Override
    public void sayHello() {
        Logger.startLog();
        System.out.println("hello");
        Logger.endLog();
    }
}
