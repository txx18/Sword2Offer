package linkedList.e22;

import zhelper.ListUtils;
import zhelper.ListUtils.*;

import java.util.List;
import java.util.Stack;

/**
 *
 * 输入一个链表，输出该链表中倒数第k个结点。
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-16 10:13
 */
public class FindKthToTail {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1};
        int[] arr3 = null;
        ListNode head = ListUtils.convertToLinkedList(arr1);
        ListUtils.printSingleList(head);

        ListNode res = FindKthToTail(head, 0);
        System.out.println("res = " + res);

    }

    public static ListNode FindKthToTail(ListNode head, int k) {
//        return mySolutionStack(head, k);
        return stoSolutionTwoPointer(head, k);
    }

    private static ListNode stoSolutionTwoPointer(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        int listSize = 0;
        // 防御fast==null
        for (int i = 0; i < k && fast != null; i++) {
            fast = fast.next;
            listSize++;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
            listSize++;
        }
        if (k > listSize) {
            return null;
        }
        return slow;
    }

    /**
     * 通过NK
     * @param head
     * @param k
     * @return
     */
    private static ListNode mySolutionStack(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int listSize = 0;
        // 装进栈
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
            listSize++;
        }
        if (k > listSize) {
            return null;
        }
        // 出栈，第k个
        ListNode res = null;
        for (int i = 0; i < k; i++) {
            res = stack.pop();
        }
        return res;
    }
}
