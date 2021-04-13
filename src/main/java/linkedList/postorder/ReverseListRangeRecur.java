package linkedList.postorder;

import zhelper.ListUtils;
import zhelper.ListUtils.ListNode;

/**
 * @author ShaneTang
 * @create 2021-02-07 8:57
 */
public class ReverseListRangeRecur {

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2, 3, 4};
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int[] arr3 = {1, 2};
        int[] arr4 = {1};
        int[] arr5 = null;
        int[] arr6 = {1, 3, 5, 7};
        int[] arr7 = {2, 4, 6, 8};
        ListNode head4 = ListUtils.convertToLinkedList(arr4);
        ListNode head5 = ListUtils.convertToLinkedList(arr5);
        ListUtils.printSingleList(head5);
        ReverseListRangeRecur obj = new ReverseListRangeRecur();
        ListNode res = obj.reverseRecur(head5, head5);
        ListUtils.printSingleList(head5);

    }

    ListNode nxt = null;

    /**
     * （我）
     * @param a
     * @param b
     * @return
     */
    private ListNode reverseRecur(ListNode a, ListNode b) {
        if (a == null) {
            return null;
        }
        if (a == b || a.next == b) {
            nxt = a.next;
            return a;
        }
        ListNode newHead = reverseRecur(a.next, b);
        // 后序
        a.next.next = a;
        a.next = nxt;
        return newHead;
    }

}
