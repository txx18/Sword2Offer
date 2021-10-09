package se.collection;

import org.junit.Test;

import java.util.*;

/**
 * @author ShaneTang
 * @create 2021-05-21 21:23
 */
public class HashMapTest {

    class Student {

        String name;

        public Student(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name);
        }

        // 不覆写hashCode的话，两个名曰equals的对象在hashSet中就不会当成一个
/*        @Override
        public int hashCode() {
            return Objects.hash(name);
        }*/

/*        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }*/
    }

    @Test
    public void testHashCode() {
        Set<Student> hashSet = new HashSet<>();
        Student s1 = new Student("tx");
        Student s2 = new Student("tx");
        Student s3 = s1;
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        hashSet.add(s1);
        hashSet.add(s2);
        hashSet.add(s3);
        System.out.println("hashSet = " + hashSet);
    }
}
