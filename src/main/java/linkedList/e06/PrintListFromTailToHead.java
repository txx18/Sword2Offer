package linkedList.e06;

import zhelper.ListUtils.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表
 *
 * @author Shane Tang
 * @create 2019-10-06 11:34
 */
public class PrintListFromTailToHead {


    public static void main(String[] args) {
        ListNode head = new ListNode(95);
        head.next = new ListNode(61);
        head.next.next = new ListNode(81);
        head.next.next.next = new ListNode(5);
        ArrayList<Integer> reverseValues = printListFromTailToHead(head);
        System.out.println(reverseValues.toString());
    }

    /**
     * NK
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
//        return solutionStack(listNode);
//        return stoSolutionRecur(listNode);
//        return zsSolutionReversePointer(listNode);
        return cycSolutionInsertHeadNode(listNode);
    }


    /**
     *
     * @param head head
     * @return
     */
    private static ArrayList<Integer> cycSolutionInsertHeadNode(ListNode head) {
        ArrayList<Integer> res = new ArrayList<>();
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
        // 循环结束后，链表反转完毕，头结点就是newNode.next
        head = newHead.next;
        addToArrayListLoop(head, res);
        return res;
    }

    private static void addToArrayListLoop(ListNode head, ArrayList<Integer> res) {
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
    }

    /**
     * 链表过长可能会SOF
     * 方法一：递归
     *
     * @param head
     */
    public static ArrayList<Integer> stoSolutionRecur(ListNode head) {
        // 防御
        if (head == null) {
            return new ArrayList<>(0);
        }
        // 外置保存结果的ArrayList
        ArrayList<Integer> res = new ArrayList<>();
        addToArrayListRecur(head, res);
        return res;
    }

    private static void addToArrayListRecur(ListNode head, ArrayList<Integer> res) {
        // 倒数第二个及之前递归压栈
        if (head.next != null) {
            addToArrayListRecur(head.next, res);
        }
        // 加入，压栈到最后一个
        res.add(head.val);
    }

    /**
     * 鲁棒性更好
     * 方法二：使用栈
     *
     * @param head
     * @return
     */
    public static ArrayList<Integer> solutionStack(ListNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    /**
     * （会改变链表的结构）
     * 方法三：把指针反转过来
     *
     * @param head
     * @return
     */
    public static ArrayList<Integer> zsSolutionReversePointer(ListNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        // 如果head == null了，说明head移到边界之外了，只要返回pre记录的边界位置就行了
//        return pre;
        head = pre;
        while (head != null) {
            res.add(head.val);
            head = head.next;
        }
        return res;
    }


/*    static class ListNode {
        // 数据域
        public int val;
        // 指针域
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }*/
}
