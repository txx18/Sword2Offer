package design;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

/**
 * @author ShaneTang
 * @create 2021-03-31 11:06
 */
public class LRULinkedHashMap {

    public static void main(String[] args) {
        LRULinkedHashMap lruCache = new LRULinkedHashMap(2);
/*        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);*/
/*        lruCache.put(1, 1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);*/
        lruCache.get(2);
        lruCache.put(2, 6);
        lruCache.get(1);
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        lruCache.get(1);
        lruCache.get(2);
    }

    LinkedList<Integer> list;
    HashMap<Integer, Integer> hashMap;
    LinkedHashMap<Integer, Integer> linkedHashMap;
    int capacity;

    public LRULinkedHashMap(int capacity) {
        list = new LinkedList<>();
        hashMap = new HashMap<>(capacity);
        linkedHashMap = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    /**
     * 通过LC
     *
     * @param key
     * @return
     */
    public int get(int key) {
        // key不存在，返回-1
        if (!linkedHashMap.containsKey(key)) {
            return -1;
        }
        // 每次get都要【重新插入】：删除同时获取值，再插入
        Integer remove = linkedHashMap.remove(key);
        linkedHashMap.put(key, remove);
        return remove;
    }

    /**
     * 通过LC
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        // 如果key已经存在，【更新插入】
        if (linkedHashMap.containsKey(key)) {
            linkedHashMap.remove(key); // 强就强在remove(key)的操作比普通链表快
            linkedHashMap.put(key, value);
            return;
        }
        // key不存在，而且达到容量了，移除头结点，再【新增插入】
        if (linkedHashMap.size() == capacity) {
            linkedHashMap.remove(linkedHashMap.keySet().iterator().next()); // 头结点 是最近最久未使用的
            linkedHashMap.put(key, value);
            return;
        }
        // key不存在，没达到容量，直接【新增插入】
        linkedHashMap.put(key, value);
/*        if (linkedHashMap.containsKey(key)) { // 可以省略
            linkedHashMap.remove(key);
        }
        if (linkedHashMap.size() == capacity) {
            Integer removeKey = linkedHashMap.keySet().iterator().next(); // 头结点是最近最久未使用的
            linkedHashMap.remove(removeKey);
        }
        linkedHashMap.put(key, value);*/
    }


    // 低效，真正的用hashMap是自己定义一个内部带hashMap的双向链表---------------------------------------------------

    @Deprecated
    public int get1(int key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        }
        list.remove((Integer) key); // 等价于 list.remove(list.indexOf(key)) 效率低在这一步，不能像linkedHashMap一样先快速找到再删除
        list.addFirst(key);
        return hashMap.get(key);
    }

    @Deprecated
    public void put1(int key, int value) {
        if (hashMap.containsKey(key)) {
            hashMap.put(key, value);
            list.remove((Integer) key); // 效率低
            list.addFirst(key);
            return;
        }
        if (list.size() == capacity) {
            hashMap.put(key, value);
            Integer removeKey = list.remove(list.size() - 1);
            hashMap.remove(removeKey);
            list.addFirst(key);
            return;
        }
        // 无论如何都要
        hashMap.put(key, value);
        list.addFirst(key);
/*        hashMap.put(key, value);
        if (hashMap.containsKey(key)) {
            list.remove((Integer) key);
        }
        if (list.size() == capacity) {
            Integer removeKey = list.remove(list.size() - 1);
            hashMap.remove(removeKey);
        }
        // 无论如何都要
        list.addFirst(key);*/
    }
}
