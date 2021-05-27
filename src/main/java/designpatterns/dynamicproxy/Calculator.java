package designpatterns.dynamicproxy;

/**
 * @author ShaneTang
 * @create 2021-05-20 22:35
 */
public class Calculator implements ICalculator{

    @Override
    public int add(int a, int b) {
        System.out.println(a + b);
        return a + b;
    }
}
