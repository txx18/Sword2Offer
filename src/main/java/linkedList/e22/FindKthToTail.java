package linkedList.e22;

import zhelper.ListUtils;
import zhelper.ListUtils.*;

import java.util.List;
import java.util.Stack;

/**
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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

    /**
     * NK
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
//        return mySolutionStack(head, k);
        return stoSolutionTwoPointer(head, k);
    }

    /**
     * LC
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        return stoSolutionTwoPointer(head, k);
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 40.7 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param head
     * @param k
     * @return
     */
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
