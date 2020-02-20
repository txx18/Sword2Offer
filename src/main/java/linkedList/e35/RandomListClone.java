package linkedList.e35;

import zhelper.ListUtils;
import zhelper.ListUtils.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-16 10:15
 */
public class RandomListClone {

    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);
        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;
        printSingleList(head);
        Node res = copyRandomList(head);
        printSingleList(res);
    }

    public static Node copyRandomList(Node head) {
//        return solutionHashMap(head);
        return solutionBehind(head);
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 41.6 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param head
     * @return
     */
    private static Node solutionBehind(Node head) {
        // 防御
        if (head == null) {
            return null;
        }
        // 构造一条 把新结点放在原节点后面的链表
        Node cur = head;
        Node next = null;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }
        // 设置random指针
        cur = head;
        Node nextNext = null;
        Node curCopy = null;
        while (cur != null) {
            nextNext = cur.next.next;
            curCopy = cur.next;
            curCopy.random = (cur.random == null ? null : cur.random.next);
            cur = nextNext;

        }
        // 设置next指针，分离新链表，还原原链表
        cur = head;
        Node res = head.next;
        while (cur != null) {
            nextNext = cur.next.next;
            curCopy = cur.next;
            // 连接新链表
            curCopy.next = nextNext == null ? null : nextNext.next;
//            curCopy.next = cur.next.next == null ? null : cur.next.next.next;
            // 还原原链表
            cur.next = nextNext;
//            cur.next = cur.next.next;
            cur = nextNext;
//            cur= cur.next.next;
        }
        return res;
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 34.65%
     * 的用户
     * 内存消耗 :
     * 47.5 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param head
     * @return
     */
    private static Node solutionHashMap(Node head) {
        // 定义一个哈希表存储node到newNode的映射
        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            map.put(cur, newNode);
            cur = cur.next;
        }
        // 第二次遍历
        cur = head;
        while (cur != null) {
            // 设置next指针
            Node newNode = map.get(cur);
            newNode.next = map.get(cur.next);
            // 设置random指针
            newNode.random = map.get(cur.random);
            // 后移
            cur = cur.next;
        }
        return map.get(head);
    }

    public static Node printSingleList(Node head) {
        if (head == null) {
            System.out.println("linkedList = null");
            return null;
        }
        System.out.print("linkedList = ");
        Node cur = head;
        while (cur != null) {
            if (cur.next != null) {
                System.out.print(cur.val + " --> ");
                cur = cur.next;
                continue;
            }
            // cur.next == null
            System.out.print(cur.val + " --> null");
            System.out.println();
            break;
        }
        return head;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
