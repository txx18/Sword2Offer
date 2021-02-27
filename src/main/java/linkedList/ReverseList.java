package linkedList;


import zhelper.ListUtils;
import zhelper.ListUtils.*;

/**
 * 反转链表
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-15 15:18
 */
public class ReverseList {

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2, 3, 4};
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int[] arr3 = {1, 2};
        int[] arr4 = {1};
        int[] arr5 = null;
        int[] arr6 = {1, 3, 5, 7};
        int[] arr7 = {2, 4, 6, 8};
        ListNode head1 = ListUtils.convertToLinkedList(arr1);
        ListUtils.printSingleList(head1);
        ReverseList obj = new ReverseList();
//        ListNode res = reverseList(head1);

        ListNode res = obj.reverseRecur(head1);
//        ListNode res = reverse(head1.next, head1.next.next.next.next);
//        ListNode res = reverseBetween(head1, 2, 4);

        ListUtils.printSingleList(res);

    }

    /**
     * 通过LC
     * @param head
     * @return
     */
    public ListNode reverseRecur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseRecur(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
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
