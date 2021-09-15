package designpattern.factory.simplefactory;

interface Product {
}

class ProductA implements Product {
}

class ProductB implements Product {
}

class ProductC implements Product {
}

class Client {

    public static void main(String[] args) {
        // 创建一个简单工厂对象
        SimpleFactory simpleFactory = new SimpleFactory();
        // 客户类不需要知道应当创建哪个实例
        // 客户类往往有多个，如果不使用简单工厂，那么所有客户类都要知道子类的细节
        Product productA = simpleFactory.creatProduct(1);
        System.out.println(productA.getClass());
        Product productB = simpleFactory.creatProduct(2);
        System.out.println(productB.getClass());
    }
}

public class SimpleFactory {

    // 简单工厂里有一个创建不同实现类（实例）的方法
    public Product creatProduct(int type) {
        if (type == 1) {
            // 在工厂中new对象
            return new ProductA();
        } else if (type == 2) {
            return new ProductB();
        }
        return new ProductC();
    }
}









