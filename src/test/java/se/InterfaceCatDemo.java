package se;

/**
 * @author ShaneTang
 * @create 2021-04-09 22:52
 */
public class InterfaceCatDemo {
    public static void main(String[] args) {
//创建对象，调用方法
        Jumpping j = new Cat();
        j.jump();
        System.out.println("");

        Animal a = new Cat();
        a.setName("加菲");
        a.setAge(5);
        System.out.println(a.getName() + "," + a.getAge());
        a.eat();
// a.jump();
        a = new Cat("加菲", 5);
        System.out.println(a.getName() + "," + a.getAge());
        a.eat();
        System.out.println("");

        Cat c = new Cat();
        c.setName("加菲");
        c.setAge(5);
        System.out.println(c.getName() + "," + c.getAge());
        c.eat();
        c.jump();
    }

    public static abstract class Animal {
        private String name;
        private int age;

        public Animal() {
        }

        public Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public abstract void eat();
    }

    public interface Jumpping {
        public abstract void jump();
    }

    public static class Cat extends Animal implements Jumpping {
        public Cat() {
        }

        public Cat(String name, int age) {
            super(name, age);
        }

        @Override
        public void eat() {
            System.out.println("猫吃鱼");
        }

        @Override
        public void jump() {
            System.out.println("猫可以跳高了");
        }
    }

}
