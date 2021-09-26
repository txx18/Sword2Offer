package se.collection;

import java.util.LinkedHashSet;

/**
 * @author ShaneTang
 * @create 2021-04-10 21:13
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {
//创建集合对象
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>();
//添加元素
        linkedHashSet.add("hello");
        linkedHashSet.add("world");
        linkedHashSet.add("java");
        linkedHashSet.add("world");
//遍历集合
        for (String s : linkedHashSet) {
            System.out.println(s);
        }
    }

}
