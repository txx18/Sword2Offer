package hash;

import java.util.HashMap;
import java.util.Random;

/**
 * 设计RandomPool结构
 * 【题目】
 * 设计一种结构，在该结构中有如下三个功能:
 * insert(key):将某个key加入到该结构，做到不重复加入
 * delete(key):将原本在结构中的某个key移除
 * getRandom(): 等概率随机返回结构中的任何一个key。
 * 【要求】
 * Insert、delete和getRandom方法的时间复杂度都是O(1)
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-23 18:07
 */
public class RamdomPool<K> {

    public static void main(String[] args) {
        RamdomPool randomPool = new RamdomPool();
        randomPool.insert("n");
        randomPool.insert("u");
        randomPool.insert("d");
        randomPool.insert("t");

        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());
        System.out.println("-----------------------------------");
        randomPool.delete("d");
        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());
        System.out.println(randomPool.getRandom());
    }


    private HashMap<K, Integer> keyIndexMap = new HashMap<>();
    private HashMap<Integer, K> indexKeyMap = new HashMap<>();
    private int size;

    private void insert(K key) {
        if (keyIndexMap.containsKey(key)) {
            return;
        }
        keyIndexMap.put(key, size);
        indexKeyMap.put(size, key);
        size++;

    }

    private void delete(K key) {
        // indexKeyMap末尾填坑
        Integer deleteIndex = keyIndexMap.get(key);
        K lastKey = indexKeyMap.get(--size);
        indexKeyMap.put(deleteIndex, lastKey);
        indexKeyMap.remove(size);
        // keyIndexMap末尾
        keyIndexMap.remove(key);
        keyIndexMap.put(lastKey, deleteIndex);
    }

    private K getRandom() {
        if (this.size == 0) {
            return null;
        }
        int randomIndex = ((int) (Math.random() * size));
        return indexKeyMap.get(randomIndex);
    }


}
