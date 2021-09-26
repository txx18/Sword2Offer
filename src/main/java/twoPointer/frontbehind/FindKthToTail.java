package twoPointer.frontbehind;

import zhelper.ListUtils.*;

import java.util.Scanner;
import java.util.Stack;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-16 10:13
 */
public class FindKthToTail {

    public static void main(String[] args) {
/*        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1};
        int[] arr3 = null;
        ListNode head = ListUtils.convertToLinkedList(arr1);
        ListUtils.printSingleList(head);

        ListNode res = FindKthToTail(head, 0);
        System.out.println("res = " + res);*/
        FindKthToTail obj = new FindKthToTail();
        ListNode head = obj.input("1,2,3,4,5,6,7");
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        int res = obj.findLastK(head, k);
        System.out.println(res);
    }

    /**
     * 通过LC
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode behind = head;
        ListNode front = head;
        for (int i = 0; i < k; i++) {
            if (front == null) {
                return null;
            }
            front = front.next;
        }
        while (front != null) {
            behind = behind.next;
            front = front.next;
        }
        return behind;
    }

    private ListNode input(String str) {
        String[] splits = str.split(",");
        ListNode preHead = new ListNode(-1);
        ListNode cur = preHead;
        for (String split : splits) {
            cur.next = new ListNode(Integer.parseInt(split));
            cur = cur.next;
        }
        return preHead.next;
    }

    public int findLastK(ListNode head, int k) {
        if (head == null) {
            return -1;
        }
        ListNode behind = head;
        ListNode front = head;
        for (int i = 0; i < k; i++) {
            if (front == null) {
                return -1;
            }
            front = front.next;
        }
        while (front != null) {
            behind = behind.next;
            front = front.next;
        }
        return behind.val;
    }


    /**
     * NK
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode FindKthToTail(ListNode head, int k) {
//        return mySolutionStack(head, k);
        return solutionTwoPointerSTO(head, k);
    }


    private static ListNode solutionTwoPointerSTO(ListNode head, int k) {
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
     *
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
