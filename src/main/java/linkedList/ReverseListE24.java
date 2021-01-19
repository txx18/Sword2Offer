package linkedList;


import zhelper.ListUtils;
import zhelper.ListUtils.*;

/**
 * 反转链表
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-15 15:18
 */
public class ReverseListE24 {

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 2, 3, 4};
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int[] arr3 = {1, 2};
        int[] arr4 = {1};
        int[] arr5 = null;
        int[] arr6 = {1, 3, 5, 7};
        int[] arr7 = {2, 4, 6, 8};
        ListNode head1 = ListUtils.convertToLinkedList(arr1);
        ListUtils.printSingleList(head1);

//        ListNode res = reverseList(head1);

        ListNode res = solutionReversePointerZS(head1);
//        ListNode res = reverse(head1.next, head1.next.next.next.next);
//        ListNode res = reverseBetween(head1, 2, 4);

        ListUtils.printSingleList(res);

    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, nxt, cur;
        cur = head;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    /**
     * LC
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        return solutionReversePointerZS(head);
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 38.4 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param head
     * @return
     */
    private static ListNode solutionReversePointerZS(ListNode head) {
        ListNode next = null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        // 如果head == null了，说明head移到边界之外了，只要返回pre记录的边界位置就行了
        return pre;
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 42.2 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param head
     * @return
     */
    private static ListNode solutionNewHeadCYC(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode cur = head;
        while (cur != null) {
            // 记住head的nextNode
            ListNode next = cur.next;
            // 断开原来的next指针，指向新增结点的next
            cur.next = newHead.next;
            // 新结点的next指针指向head
            newHead.next = cur;
            // head后移
            cur = next;
        }
        // 循环结束后，链表反转完毕，头结点就是newNode.next
        return newHead.next;
    }

    private static ListNode solutionInsertHeadNodeCYC(ListNode head) {
        // 创建新的结点
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            // 记住head的nextNode
            ListNode next = head.next;
            // 断开原来的next指针，指向新增结点的next
            head.next = newHead.next;
            // 新结点的next指针指向head
            newHead.next = head;
            // head后移
            head = next;
        }
        return newHead.next;
    }
}
