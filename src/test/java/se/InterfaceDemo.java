package se;

/**
 * @author ShaneTang
 * @create 2021-04-09 22:49
 */
public class InterfaceDemo {

    public static void main(String[] args) {
        Inter i = new InterImpl();
// i.num = 20;
        System.out.println(i.num);
// i.num2 = 40;
        System.out.println(i.num2);
        System.out.println(Inter.num);
    }

    public interface Inter {
        public int num = 10;
        public final int num2 = 20;
        // public static final int num3 = 30;
        int num3 = 30;

        // public Inter() {}
// public void show() {}
        public abstract void method();

        void show();
    }

    public static class InterImpl extends Object implements Inter {
        public InterImpl() {
            super();
        }

        @Override
        public void method() {
            System.out.println("method");
        }

        @Override
        public void show() {
            System.out.println("show");
        }
    }


}
