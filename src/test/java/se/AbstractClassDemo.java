package se;

/**
 * 成员区别
 * 抽象类
 * 变量,常量；有构造方法；有抽象方法,也有非抽象方法
 * 接口
 * 常量；抽象方法
 *
 * 关系区别
 * 类与类
 * 继承，单继承
 * 类与接口
 * 实现，可以单实现，也可以多实现
 * 接口与接口
 * 继承，单继承，多继承
 *
 * 设计理念区别
 * 抽象类
 * 对类抽象，包括属性、行为
 * 接口
 * 对行为抽象，主要是行为
 *
 * @author ShaneTang
 * @create 2021-04-09 22:56
 */
public class AbstractClassDemo {

    public static void main(String[] args) {
        Animal a = new Cat();
        a.setAge(8);
        a.eat();
        a.show();
    }

    public static abstract class Animal {
        private int age = 20;
        private final String city = "北京";

        public Animal() {
        }

        public Animal(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getCity() {
            return city;
        }

        public void show() {
//            age = 40;
            System.out.println(age);
// city = "上海";
            System.out.println(city);
        }

        public abstract void eat();
    }

    public static class Cat extends Animal {
        @Override
        public void eat() {
            System.out.println("猫吃鱼");
        }
    }
}
