package linkedList;

import zhelper.ListUtils;
import zhelper.ListUtils.*;

import java.util.Stack;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * <p>
 * 我感觉并不需要是排序的链表啊
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-16 11:45
 */
public class deleteNodeE1802 {

    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] arr4 = {1};
        int[] arr5 = {1, 2, 3, 4, 3, 5};
        int[] arr6 = {1, 1, 2, 3, 4, 5, 5};
        int[] arr7 = {5, 5, 4, 3, 2, 1, 1};
        ListNode head = ListUtils.convertToLinkedList(arr7);
        ListUtils.printSingleList(head);

        ListNode res = deleteNode(head, 1);
//        ListNode res = deleteNode(head, head);

        ListUtils.printSingleList(res);
    }

    /**
     * LC
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode deleteNode(ListNode head, int val) {
//        return mySolutionInsertHeadTraverse(head, val);
//        return solutionZS(head, val);
        return solutionStackZS(head, val);
    }

    /**
     * 执行用时 :
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 39.5 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param head
     * @param val
     * @return
     */
    private static ListNode solutionStackZS(ListNode head, int val) {
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        // 不是指定节点的放进栈中
        while (cur != null) {
            if (cur.val != val) {
                stack.push(cur);
            }
            cur = cur.next;
        }
        // 重新连接栈中元素，从尾到头地连
        while (!stack.isEmpty()) {
            stack.peek().next = cur;
            cur = stack.pop();
        }
        return cur;
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 39.1 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param head
     * @param val
     * @return
     */
    private static ListNode solutionZS(ListNode head, int val) {
        // 如果删的是头几个，就换头
        while (head != null) {
            if (head.val != val) {
                break;
            }
            head = head.next;
        }
        ListNode pre = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            }
            // 跳出待删区域
            else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    /**
     * 重载LC的题目
     *
     * @param head
     * @param toDelNode
     * @return
     */
    public static ListNode deleteNode(ListNode head, ListNode toDelNode) {
        return solutionCoverSTO(head, toDelNode);
    }

    /**
     * 入参必须是节点类型
     *
     * @param head
     * @param toDelNode
     * @return
     */
    private static ListNode solutionCoverSTO(ListNode head, ListNode toDelNode) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cur = newHead;
        // 如果删除的是最后一个节点
        if (toDelNode.next == null) {
            // toDelNode = null; // 【错误】这不是置空，而是指向空
            while (cur.next != toDelNode) {
                cur = cur.next;
            }
            // 遍历到最后一个节点
            cur.next = null;
            return newHead.next;
        }
        // 如果删除的不是最后一个节点
        toDelNode.val = toDelNode.next.val;
        toDelNode.next = toDelNode.next.next;
        return newHead.next;
    }

    /**
     * 通过LC
     * 而且我认为我的支持重复数字的删除
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 41.7 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param head
     * @param val
     * @return
     */
    private static ListNode solutionInsertHeadTraverseME(ListNode head, int val) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode cur = newHead;
        while (cur.next != null) {
            // 如果不是要删的，跳过
            if (cur.next.val != val) {
                cur = cur.next;
                continue;
            }
            // 如果是要删的，跨越
            cur.next = cur.next.next;
        }
        return newHead.next;
    }


}
