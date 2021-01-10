package linkedList;

import java.util.*;


public class reverseKGroup {

    private static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        ListNode preHead = new ListNode(-1);
        ListNode cur = preHead;
        for (String str : strs) {
            cur.next = new ListNode(Integer.parseInt(str));
            cur = cur.next;
        }
        int k = sc.nextInt();
        cur = solution(preHead.next, k);
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    private static ListNode solution(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverse(head, b);
        // 先序
        head.next = solution(b, k);
        return newHead;
    }

    private static ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, nxt;
        pre = nxt = null;
        ListNode cur = a;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}