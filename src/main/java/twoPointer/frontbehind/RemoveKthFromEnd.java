package twoPointer.frontbehind;

import zhelper.ListUtils;
import zhelper.ListUtils.*;

/**
 * @author ShaneTang
 * @create 2021-02-01 20:59
 */
public class RemoveKthFromEnd {

    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        ListNode head1 = ListUtils.convertToLinkedList(arr1);
        RemoveKthFromEnd obj = new RemoveKthFromEnd();
        ListNode res = obj.removeNthFromEnd(head1, 3);
        ListUtils.printSingleList(res);
    }

    /**
     * 通过LC
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write code here
        if (head == null) {
            return null;
        }
        ListNode fast, slow;
        fast = slow = head;
        for (int i = 0; i < n; i++) {
            // 如果n超过数组长度
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        // 如果链表长度为n, fast正好为null
        if (fast == null) {
            return head.next;
        }
        // 为了记录倒数第n个的前一个节点，所以不是fast!=null
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
