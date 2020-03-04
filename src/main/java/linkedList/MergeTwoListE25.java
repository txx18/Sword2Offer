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

        ListNode res = Merge(head1, head2);
        ListUtils.printSingleList(res);

    }

    /**
     * NK
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode Merge(ListNode list1, ListNode list2) {
//        return mySolutionLoop(list1, list2);
        return solutionRecurCYC(list1, list2);
    }

    /**
     * LC
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        return mySolutionLoop(l1, l2);
        return solutionRecurCYC(l1, l2);
    }


    /**
     * 通过NK
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 45.5 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param list1
     * @param list2
     * @return
     */
    private static ListNode solutionLoopME(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            }
            else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        // 直接连上
        if (list1 != null) {
            cur.next = list1;
        }
        // 我干嘛要一个个连
        while (list2 != null) {
            cur.next = list2;
            list2 = list2.next;
            cur = cur.next;
        }
        return newHead.next;
    }

    /**
     * 执行用时 :
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 9.42%
     * 的用户
     * 内存消耗 :
     * 44.4 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode solutionRecurCYC(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = solutionRecurCYC(list1.next, list2);
            return list1;
        } else {
            list2.next = solutionRecurCYC(list1, list2.next);
            return list2;
        }
    }
}
