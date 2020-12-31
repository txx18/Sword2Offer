package linkedList;

class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }

    private class ListNode {
        int key;
        int value;
        ListNode next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int cacheCapacity;
    ListNode fakeHead;
    int nodeCount;

    public LRUCache(int capacity) {
        this.cacheCapacity = capacity;
        this.fakeHead = new ListNode(-1, -1);
    }

    public int get(int key) {
        for (ListNode cur = fakeHead; cur.next != null; cur = cur.next) {
            // 如果找到了，删除原来的位置的结点，放到头结点
            if (cur.next.key == key) {
                ListNode deleteNode = cur.next;
                //
                cur.next = cur.next.next;
                //
                ListNode newNode = new ListNode(key, deleteNode.value);
                newNode.next = fakeHead.next;
                fakeHead.next = newNode;
                return newNode.value;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        // 新建要加入的结点
        ListNode newNode = new ListNode(key, value);
        // 如果链表为空，新建头结点
        if (nodeCount == 0) {
            fakeHead.next = newNode;
            nodeCount++;
            return;
        }
        // 如果原缓存存在，put重复的key，删除原结点，插入链表头，返回
        for(ListNode cur = fakeHead; cur.next != null; cur = cur.next) {
            if (cur.next.key == key) {
                cur.next = cur.next.next;
                newNode.next = fakeHead.next;
                fakeHead.next = newNode;
                return;
            }
        }
        // 如果原缓存不存在，检查缓存是否满了
        // 如果没满，插入链表头
        if (nodeCount < cacheCapacity) {
            newNode.next = fakeHead.next;
            fakeHead.next = newNode;
            nodeCount++;
        }
        // 如果满了，删除最后的结点，插入头结点
        else if (nodeCount == cacheCapacity) {
            ListNode cur = fakeHead;
            for(;cur.next.next != null; ) {
                cur = cur.next;
            }
            // 删除尾结点
            cur.next = null;
            nodeCount--;
            // 满或没满，都要插入头结点
            newNode.next = fakeHead.next;
            fakeHead.next = newNode;
            nodeCount++;
        }
        else{

        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
