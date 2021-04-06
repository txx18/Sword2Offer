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
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode front, behind;
        front = behind = head;
        for (int i = 0; i < n; i++) {
            // 如果n超过数组长度
            if (front == null) {
                return null;
            }
            front = front.next;
        }
        // 如果链表长度为n, fast正好为null
        if (front == null) {
            return head.next;
        }
        // 为了记录倒数第n个的前一个节点，所以是 front.next != null
        while (front.next != null) {
            front = front.next;
            behind = behind.next;
        }
        behind.next = behind.next.next;
        return head;
    }
}
