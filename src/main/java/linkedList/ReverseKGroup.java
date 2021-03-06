package linkedList;

import zhelper.ListUtils.*;

import java.util.*;


public class ReverseKGroup {


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
        ReverseKGroup obj = new ReverseKGroup();
        cur = obj.reverseKGroup(preHead.next, k);
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    private ListNode reverseKGroup(ListNode head, int k) {
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
        // 先序，返回newHead
        ListNode newHead = reverse(p1, p2);
        // p1.next接上递归
        p1.next = reverseKGroup(p2, k);
        return newHead;
    }

    private ListNode reverse(ListNode p1, ListNode p2) {
        ListNode pre, nxt;
        pre = nxt = null;
        while (p1 != p2) {
            nxt = p1.next;
            p1.next = pre;
            pre = p1;
            p1 = nxt;
        }
        return pre;
    }
}