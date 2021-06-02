package designpattern.dynamicproxy;

/**
 * @author ShaneTang
 * @create 2021-05-20 22:19
 */
public class HelloWorld implements IHelloWorld{

    @Override
    public void sayHello() {
        System.out.println("hello");
    }

    public void sayHello(String language) {
        System.out.println("hello, " + language);
    }
}
