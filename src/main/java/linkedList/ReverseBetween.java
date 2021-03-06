package linkedList;

import zhelper.ListUtils;
import zhelper.ListUtils.*;

/**
 * @author ShaneTang
 * @create 2020-12-27 20:22
 */
public class ReverseBetween {

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
        ReverseBetween obj = new ReverseBetween();
        ListNode res = obj.reverseBetween(head1, 2, 4);
//        ListNode res = obj.reverseMToLength(head1, 3);
        ListUtils.printSingleList(res);

    }

    ListNode nxt = null;

    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        if (m == 1) {
            return reverse1ToN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    private ListNode reverse1ToN(ListNode head, int n) {
        if (n == 1) {
            nxt = head.next;
            return head;
        }
        // 后序
        ListNode newHead = reverse1ToN(head.next, n - 1);
        head.next.next = head;
        head.next = nxt;
        return newHead;
    }

    private  ListNode reverseMToLength(ListNode head, int m) {
        if (m == 1) {
            return reverse(head);
        }
        head.next = reverseMToLength(head.next, m - 1);
        return head;
    }

    private ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode nxt = null;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
