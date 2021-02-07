package linkedList;

import zhelper.ListUtils;
import zhelper.ListUtils.*;
import zhelper.TestHelper;

/**
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 1:
 * <p>
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 * <p>
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-16 12:57
 */
public class DeleteDuplicateNodeE1801 {

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
        DeleteDuplicateNodeE1801 obj = new DeleteDuplicateNodeE1801();
        ListNode res = obj.deleteDuplicatesLeaveOneRecur(head);
        ListUtils.printSingleList(res);
    }

    int recurDepth;


    private ListNode deleteDuplicatesLeaveOneRecur(ListNode head) {
//        TestHelper.printIndent(recurDepth++);
//        System.out.println(head == null ? "null" : head.val);
        if (head == null || head.next == null) {
//            TestHelper.printIndent(recurDepth--);
//            System.out.println(head == null ? "null" : head.val);
            return head;
        }
        ListNode nxt = head.next;
        if (head.val == nxt.val) {
//            TestHelper.printIndent(recurDepth--);
//            System.out.println(head.val);
            return deleteDuplicatesLeaveOneRecur(nxt);
        } else {
            head.next = deleteDuplicatesLeaveOneRecur(nxt);
//            TestHelper.printIndent(recurDepth--);
//            System.out.println(head.val);
            return head;
        }
    }

    private ListNode deleteDuplicatesNoLeaveRecur(ListNode pHead) {
        // write code here
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode nxt = pHead.next;
        if (pHead.val == nxt.val) {
            while (nxt != null && nxt.val == pHead.val) {
                nxt = nxt.next;
            }
            return deleteDuplicatesNoLeaveRecur(nxt);
        }
        pHead.next = deleteDuplicatesNoLeaveRecur(nxt);
        return pHead;
    }

    public ListNode deleteDuplicatesLeaveOneLoop(ListNode head) {
        // write code here
        if (head == null) {
            return null;
        }
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null) {
            if (fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;
    }


    private ListNode deleteDuplicatesNoLeaveLoop(ListNode head) {
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
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

