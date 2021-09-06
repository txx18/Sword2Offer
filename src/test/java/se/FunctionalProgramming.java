package se;

import org.junit.Test;

/**
 * @author ShaneTang
 * @create 2021-06-02 10:57
 */
public class FunctionalProgramming {

    @Test
    public void test() {
        String res1 = run(str -> str.toUpperCase(), "Hello World!");
        System.out.println("res1 = " + res1);

        String res2 = run(new IStringFunction() {
            @Override
            public String apply(String str) {
                return str.toUpperCase();
            }
        }, "Hello World!");
        System.out.println("res2 = " + res2);

        String res3 = run(new IStringFunctionImpl(), "Hello World!");
        System.out.println("res3 = " + res3);
    }

    public String run(IStringFunction f, String str) {
        return f.apply(str);
    }

    class IStringFunctionImpl implements IStringFunction {

        @Override
        public String apply(String str) {
            return str.toUpperCase();
        }
    }

    public interface IStringFunction {
        public String apply(String str);
    }


}
