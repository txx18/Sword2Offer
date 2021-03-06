package designpatterns.simplefactory;



interface Product {

}

class ProductA implements Product {

}

class ProductB implements Product {

}

class ProductC implements Product {

}

/**
 * @author ShaneTang
 * @create 2021-03-04 20:47
 */
public class SimpleFactory {

    /**
     * 简单工厂里有一个创建不同实现类（实例）的方法
     * @param type
     * @return
     */
    public Product creatProduct(int type) {
        if (type == 1) {
            return new ProductA();
        }else if (type == 2) {
            return new ProductB();
        }
        return new ProductC();
    }
}

/**
 * 客户类需要一个Product的实例
 */
class Client {

    public static void main(String[] args) {
        // 创建一个简单工厂对象
        SimpleFactory simpleFactory = new SimpleFactory();
        // 客户类不需要知道应当创建哪个实例
        // 客户类往往有多个，如果不使用简单工厂，那么所有客户类都要知道子类的细节
        Product product = simpleFactory.creatProduct(1);

    }
}



