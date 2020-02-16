package linkedList.e18;

import zhelper.ListUtils;
import zhelper.ListUtils.*;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 *
 * 我感觉并不需要是排序的链表啊
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-16 11:45
 */
public class deleteNode {

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

    public static ListNode deleteNode(ListNode head, int val) {
//        return solutionTrav(head, val);
        return mySolutionInsertHeadTraverse(head, val);
    }

    /**
     * 重载LC的题目
     *
     * @param head
     * @param toDelNode
     * @return
     */
    public static ListNode deleteNode(ListNode head, ListNode toDelNode) {
        return stoSolutionCover(head, toDelNode);
    }

    /**
     * 入参必须是节点类型
     *
     * @param head
     * @param toDelNode
     * @return
     */
    private static ListNode stoSolutionCover(ListNode head, ListNode toDelNode) {
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
     * @param head
     * @param val
     * @return
     */
    private static ListNode mySolutionInsertHeadTraverse(ListNode head, int val) {
        ListNode newNode = new ListNode(-1);
        newNode.next = head;
        ListNode cur = newNode;
        while (cur.next != null) {
            // 如果不是要删的，跳过
            if (cur.next.val != val) {
                cur = cur.next;
                continue;
            }
            // 如果是要删的，跨越
            cur.next = cur.next.next;
        }
        return newNode.next;
    }

    /**
     * 遍历法
     *
     * @param head
     * @param val
     * @return
     */
    private static ListNode solutionTrav(ListNode head, int val) {
        // 防御
        if (head == null) {
            return null;
        }
        // 如果只有一个节点且删除的就是第一个
        if (head.next == null && head.val == val) {
            return null;
        }
        // 如果多个节点，要删除第一个节点
        if (head.val == val) {
            return head.next;
        }
        ListNode cur = head;
        // 多个节点，删除不是第一个节点，如果nextNode是待删除节点就越过它
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                break;
            }
            // 如果不是则下一个
            cur = cur.next;
        }
/*        while (cur.next.val != val) {
            cur = cur.next;
        }
        cur.next = cur.next.next;*/
        return head;
    }

}
