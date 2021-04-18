package linkedList;

import zhelper.ListUtils;
import zhelper.ListUtils.*;

public class FirstCommonNode {


    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);

        // 0->9->8->6->7->null
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNodeZS(head1, head2).val);

        // 1->2->3->4->5->6->7->4...
        head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNodeZS(head1, head2).val);

        // 0->9->8->6->4->5->6..
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNodeZS(head1, head2).val);

    }

    /**
     * 通过LC
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode solutionTwoPointer(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = (p1 != null) ? p1.next : headB;
            p2 = (p2 != null) ? p2.next : headA;
        }
        // p1 == p2
        return p1;
    }

    /**
     * 适应多种情况
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode getIntersectNodeZS(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode loop1 = getLoopNode(head1);
        ListNode loop2 = getLoopNode(head2);
        // 都无环：Y字形 or 不想交
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        // 都有环：Y6形 or 电视机形 or 不相交
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    /**
     * 环的入口节点
     *
     * @param head
     * @return
     */
    public static ListNode getLoopNode(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode n1 = head.next; // n1 -> slow
        ListNode n2 = head.next.next; // n2 -> fast
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head; // n2 -> walk again from head
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    /**
     * 都无环的情况
     * <p>
     * 计算两个链表的长度差
     * 回到起点，长的那个 先走 diff 步
     * 同时出发，直到相遇
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode noLoop(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int n = 0;
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 都有环的情况
     *
     * @param head1
     * @param loop1
     * @param head2
     * @param loop2
     * @return
     */
    public static ListNode bothLoop(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2) {
        ListNode cur1 = null;
        ListNode cur2 = null;
        // Y6形， 在到达入环节点之前，就是Y字形
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            // 到达入环节点之前
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }
        // loop1 != loop2 电视机形
        else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                // 绕圈的过程中如果遇到了loop2，就说明是电视机形
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            // 否则不相交
            return null;
        }
    }

    /**
     * 执行用时 :
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 42.17%
     * 的用户
     * 内存消耗 :
     * 43 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param head1
     * @param head2
     * @return
     */
    private static ListNode solutionFSPointerME(ListNode head1, ListNode head2) {
        // 计算两个链表的长度差
        int listSize1 = ListUtils.size(head1);
        int listSize2 = ListUtils.size(head2);
        int diff = Math.abs(listSize1 - listSize2);
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        if (listSize2 > listSize1) {
            // list2 先走 diff 步
            for (int i = 0; i < diff; i++) {
                cur2 = cur2.next;
            }
        } else if (listSize1 > listSize2) {
            // list1 先走 diff 步
            for (int i = 0; i < diff; i++) {
                cur1 = cur1.next;
            }
        }
        // 包括listSize1 == listSize2的情况
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }


}
