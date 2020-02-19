package linkedList.e18;

import zhelper.ListUtils;
import zhelper.ListUtils.*;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-16 12:57
 */
public class deleteDuplicateNode {

    public static void main(String[] args) {
/*        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);*/

        int[] arr1 = {1, 2, 3, 3, 4, 4, 5};
        int[] arr2 = {1, 1, 1, 1, 1};
        int[] arr3 = {1, 1, 2, 3, 3, 4, 5};
        ListNode head = ListUtils.convertToLinkedList(arr3);
        ListUtils.printSingleList(head);

        ListNode res = deleteDuplication(head);
        ListUtils.printSingleList(res);
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        return mySolutionInsertHeadTraverse(pHead);
    }



    /**
     * 通过NK
     *
     * @param pHead
     * @return
     */
    private static ListNode mySolutionInsertHeadTraverse(ListNode pHead) {
        ListNode newHead = new ListNode(-1);
        newHead.next = pHead;
        ListNode cur = newHead;
        // 防御cur.next == null 的情况
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val != cur.next.next.val) {
                // 如果接下来两个不重复，则跳过
                cur = cur.next;
                continue;
            }
            // 如果接下来两个重复，则继续判断后面是否重复
            ListNode dup = cur.next.next;
            // 防御dup.next == null的情况
            while (dup.next != null && dup.val == dup.next.val) {
                dup = dup.next;
            }
            // 跨过重复区域相连
            cur.next = dup.next;
        }
        return newHead.next;
    }
}

