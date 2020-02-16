package linkedList.e25;

import zhelper.ListUtils;
import zhelper.ListUtils.*;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-16 10:14
 */
public class MergeTwoList {

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

    public static ListNode Merge(ListNode list1, ListNode list2) {
//        return mySolutionLoop(list1, list2);
        return cycSolutionRecur(list1, list2);
    }

    /**
     * 通过NK
     * @param list1
     * @param list2
     * @return
     */
    private static ListNode mySolutionLoop(ListNode list1, ListNode list2) {
        ListNode insertNode = new ListNode(-1);
        ListNode cur = insertNode;
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
        return insertNode.next;
    }

    public static ListNode cycSolutionRecur(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        if (list1.val <= list2.val) {
            list1.next = cycSolutionRecur(list1.next, list2);
            return list1;
        } else {
            list2.next = cycSolutionRecur(list1, list2.next);
            return list2;
        }
    }
}
