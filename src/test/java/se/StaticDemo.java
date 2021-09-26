package se;

class Student {
    public String name; //姓名
    public int age; //年龄
    public static String university = "NUDT"; //学校 共享数据！所以设计为静态！

    public void show() {
        System.out.println(name + "," + age + "," + university);
    }
}

public class StaticDemo {
    public static void main(String[] args) {
// 为对象的共享数据赋值
        Student.university = "传智大学";
        Student s1 = new Student();
        s1.name = "林青霞";
        s1.age = 30;
        s1.show();
        Student s2 = new Student();
        s2.name = "风清扬";
        s2.age = 33;
        s2.show();
    }
}
