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
        if (head == null) {
            return head;
        }
        ListNode l, r;
        l = r = head;
        for (int i = 0; i < k; i++) {
            if (r == null) {
                return head;
            }
            r = r.next;
        }
        ListNode newHead = reverse(l, r);
        // 先序
        l.next = solution(r, k);
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