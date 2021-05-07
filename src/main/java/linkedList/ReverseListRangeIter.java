package linkedList;

import zhelper.ListUtils;
import zhelper.ListUtils.*;

/**
 * @author ShaneTang
 * @create 2021-02-07 8:57
 */
public class ReverseListRangeIter {

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2, 3, 4};
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int[] arr3 = {1, 2};
        int[] arr4 = {1};
        int[] arr5 = null;
        int[] arr6 = {1, 3, 5, 7};
        int[] arr7 = {2, 4, 6, 8};
        ListNode head4 = ListUtils.convertToLinkedList(arr4);
        ListNode head5 = ListUtils.convertToLinkedList(arr5);
        ListUtils.printSingleList(head5);
        ReverseListRangeIter obj = new ReverseListRangeIter();
        ListNode res = obj.reverse(head5, head5);
        ListUtils.printSingleList(head5);

    }

    ListNode nxt = null;

    private ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, nxt;
        pre = nxt = null;
        while (a != b) {
            nxt = a.next;
            a.next = pre;
            pre = a;
            a = nxt;
        }
        return pre;
    }

    private ListNode reverseLoop(ListNode head) {
        ListNode pre, nxt, cur;
        pre = nxt = null;
        cur = head;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    private static ListNode solutionInsertHeadNodeCYC(ListNode head) {
        // 创建新的结点
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            // 记住head的nextNode
            ListNode next = head.next;
            // 断开原来的next指针，指向新增结点的next
            head.next = newHead.next;
            // 新结点的next指针指向head
            newHead.next = head;
            // head后移
            head = next;
        }
        // 循环结束后，链表反转完毕，头结点就是newNode.next
        return newHead.next;
    }
}
