package linkedList.e22;

import zhelper.ListUtils;
import zhelper.ListUtils.*;

/**
 *
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-16 20:21
 */
public class MiddleNode {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int[] arr3 = {1, 2};
        int[] arr4 = {1};
        int[] arr5 = null;
        ListNode head = ListUtils.convertToLinkedList(arr5);
        ListUtils.printSingleList(head);

        ListNode res = middleNode(head);
        System.out.println("res = " + res);

    }

    public static ListNode middleNode(ListNode head) {
        return mySolution(head);

    }

    /**
     * 通过LC
     * @param head
     * @return
     */
    private static ListNode mySolution(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast.next == null) {
            return slow;
        }
        return slow.next;
    }
}
