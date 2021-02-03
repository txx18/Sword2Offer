package linkedList;

import zhelper.ListUtils.*;

import java.util.*;


public class reverseKGroup {


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
        cur = reverseKGroup(preHead.next, k);
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    private static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode p1, p2;
        p1 = p2 = head;
        for (int i = 0; i < k; i++) {
            if (p2 == null) {
                return head;
            }
            p2 = p2.next;
        }
        // 先序
        ListNode newHead = reverse(p1, p2);
        // p1.next接上递归
        p1.next = reverseKGroup(p2, k);
        return newHead;
    }

    private static ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, nxt, cur;
        pre = nxt = null;
        cur = a;
        while (cur != b) {
            nxt = cur.next;
            cur.next= pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}