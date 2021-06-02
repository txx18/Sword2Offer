package designpattern.abstractfactory;


class AbstractProductA {

}

class AbstractProductB {

}

class ProductA1 extends AbstractProductA {

}

class ProductA2 extends AbstractProductA {

}

class ProductB1 extends AbstractProductB {

}

class ProductB2 extends AbstractProductB {

}


/**
 * @author ShaneTang
 * @create 2021-03-04 21:26
 */
public abstract class AbstractFactory {

    abstract AbstractProductA createProductA();

    abstract AbstractProductB createProductB();
}

class ConcreteFactory1 extends AbstractFactory {

    @Override
    AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    AbstractProductB createProductB() {
        return new ProductB1();
    }
}

class ConcreteFactory2 extends AbstractFactory {

    @Override
    AbstractProductA createProductA() {
        return new ProductA2();
    }

    @Override
    AbstractProductB createProductB() {
        return new ProductB2();
    }
}

class client {
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new ConcreteFactory1();
        AbstractProductA productA = abstractFactory.createProductA();
        AbstractProductB productB = abstractFactory.createProductB();
    }
}
