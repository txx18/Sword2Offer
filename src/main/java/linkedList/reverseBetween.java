package linkedList;

import zhelper.ListUtils;
import zhelper.ListUtils.*;

/**
 * @author ShaneTang
 * @create 2020-12-27 20:22
 */
public class reverseBetween {

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
        reverseBetween obj = new reverseBetween();
        ListNode res = obj.reverseBetween(head1, 2, 4);
        ListUtils.printSingleList(res);

    }

    ListNode nxt = null;

    public ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    private ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            nxt = head.next;
            return head;
        }
        ListNode newHead = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = nxt;
        return newHead;
    }

/*    public static ListNode reverseBetween (ListNode head, int m, int n) {
        // write code here
        // FIXME 防御有问题
        if (head == null || head.next == null || m == n) {
            return head;
        }
        ListNode start = head;
        ListNode pre = null;
        for (int i = 1; i < m; i++){
            if (i == m - 1) {
                pre = start;
            }
            start = start.next;
        }
        ListNode end = start;
        for (int i = m; i < n; i++) {
            end = end.next;
        }
        ListNode nxt = end.next;
        reverse(start, nxt);
        pre.next = end;
        start.next = nxt;
        return head;
    }*/

    /**
     * 左闭右开
     * @param a
     * @param b
     * @return
     */
    private static ListNode reverse(ListNode a, ListNode b) {
        ListNode nxt = a;
        ListNode pre = null;
        for (ListNode cur = a; cur != b;) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
