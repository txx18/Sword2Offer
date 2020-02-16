package linkedList.e24;


import zhelper.ListUtils;
import zhelper.ListUtils.*;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-15 15:18
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(95);
        head.next = new ListNode(61);
        head.next.next = new ListNode(81);
        head.next.next.next = new ListNode(5);
        ListNode reverseHead = ReverseList(head);
        ListUtils.printSingleList(reverseHead);
    }


    public static ListNode ReverseList(ListNode head) {
//        return cycSolutionInsertHeadNode(head);
        return zsSolutionReversePointer(head);
    }

    private static ListNode zsSolutionReversePointer(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        // 如果head == null了，说明head移到边界之外了，只要返回pre记录的边界位置就行了
        return pre;
    }

    private static ListNode cycSolutionInsertHeadNode(ListNode head) {
        // 创建新的结点
        ListNode newNode = new ListNode(-1);
        while (head != null) {
            // 记住head的nextNode
            ListNode next = head.next;
            // 断开原来的next指针，指向新增结点的next
            head.next = newNode.next;
            // 新结点的next指针指向head
            newNode.next = head;
            // head后移
            head = next;
        }
        return newNode.next;
    }
}
