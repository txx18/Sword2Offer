package designpattern.factory.factorymethod;


interface Product {
}

class ProductA implements Product {
}

class ProductB implements Product {
}

abstract class AbstractFactory {

    abstract public Product createProduct();

    public void doSth() {
        Product product = createProduct();
        System.out.println(product.getClass());
    }
}

class FactoryA extends AbstractFactory {

    @Override
    public Product createProduct() {
        return new ProductA();
    }
}

class FactoryB extends AbstractFactory {

    @Override
    public Product createProduct() {
        return new ProductB();
    }
}


// 客户端需要一个特定实例
// 通过创建工厂类的子类，工厂是一个抽象类，其子类来创建不同的实例对象，这样就把实例化推迟到了子类
class Client {

    public static void main(String[] args) {
        FactoryA factoryA = new FactoryA();
        factoryA.createProduct();
        factoryA.doSth();
        FactoryB factoryB = new FactoryB();
        factoryB.createProduct();
        factoryB.doSth();
    }
}



