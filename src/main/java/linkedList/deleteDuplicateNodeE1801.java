package linkedList;

import zhelper.ListUtils;
import zhelper.ListUtils.*;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-16 12:57
 */
public class deleteDuplicateNodeE1801 {

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
        int[] arr4 = {1, 1, 2, 3, 3, 4, 5, 5};
        ListNode head = ListUtils.convertToLinkedList(arr4);
        ListUtils.printSingleList(head);

        ListNode res = deleteDuplicates(head);
        ListUtils.printSingleList(res);
    }

    /**
     * NK
     * @param pHead
     * @return
     */
    public static ListNode deleteDuplication(ListNode pHead) {
        return solutionInsertHeadTraverseME(pHead);
    }

    /**
     * LC
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        return solutionInsertHeadTraverseME(head);
    }


    /**
     * 通过NK LC
     *执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 98.44%
     * 的用户
     * 内存消耗 :
     * 39.1 MB
     * , 在所有 Java 提交中击败了
     * 5.06%
     * 的用户
     * @param pHead
     * @return
     */
    private static ListNode solutionInsertHeadTraverseME(ListNode pHead) {
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

