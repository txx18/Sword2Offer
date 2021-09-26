package linkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
public class CloneRandomList {

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(7);
        head.next = new RandomListNode(13);
        head.next.next = new RandomListNode(11);
        head.next.next.next = new RandomListNode(10);
        head.next.next.next.next = new RandomListNode(1);
        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;
        printSingleList(head);
        RandomListNode res = solutionCloneBehind(head);
        printSingleList(res);
    }


    private static RandomListNode solutionCloneBehind(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }
        // 插入新节点 把新结点放在原节点后面
        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        // 设置random指针
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null) {
                clone.random = cur.random.next;
            }
            cur = clone.next;

        }
        // 拆分
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while (cur.next != null) {
            RandomListNode nxt = cur.next;
            cur.next = nxt.next;
            cur = nxt;
        }
        return pCloneHead;
    }


    private static RandomListNode solutionHashMap(RandomListNode pHead) {
        // 定义一个哈希表存储node到newNode的映射
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode cur = pHead;
        // 第一次遍历是复制节点本身并加入映射哈希
        while (cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            map.put(cur, newNode);
            cur = cur.next;
        }
        cur = pHead;
        // 第二次遍历是根据映射连指针
        while (cur != null) {
            RandomListNode newNode = map.get(cur);
            newNode.next = map.get(cur.next);
            newNode.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(pHead);
    }

    public static RandomListNode printSingleList(RandomListNode head) {
        if (head == null) {
            System.out.println("linkedList = null");
            return null;
        }
        System.out.print("linkedList = ");
        RandomListNode cur = head;
        while (cur != null) {
            if (cur.next != null) {
                System.out.print(cur.label + " --> ");
                cur = cur.next;
                continue;
            }
            // cur.next == null
            System.out.print(cur.label + " --> null");
            System.out.println();
            break;
        }
        return head;
    }

    static class RandomListNode {
        int label;
        RandomListNode next;
        RandomListNode random;

        public RandomListNode(int label) {
            this.label = label;
            this.next = null;
            this.random = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            RandomListNode that = (RandomListNode) o;
            return label == that.label && Objects.equals(next, that.next) && Objects.equals(random, that.random);
        }

        @Override
        public int hashCode() {
            return Objects.hash(label, next, random);
        }
    }
}
