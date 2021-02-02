package linkedList;

import zhelper.ListUtils;
import zhelper.ListUtils.*;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-16 10:14
 */
public class MergeTwoListE25 {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int[] arr3 = {1, 2};
        int[] arr4 = {1};
        int[] arr5 = null;
        int[] arr6 = {1, 3, 5, 7};
        int[] arr7 = {2, 4, 6, 8};
        ListNode head1 = ListUtils.convertToLinkedList(arr1);
        ListNode head2 = ListUtils.convertToLinkedList(arr2);

        ListNode res = mergeTwoLists(head1, head2);
        ListUtils.printSingleList(res);

    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write code here
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    private static ListNode solutionLoop(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }


}
