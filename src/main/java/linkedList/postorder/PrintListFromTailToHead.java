package linkedList.postorder;

import zhelper.ListUtils;
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
        ListNode test = ListUtils.convertToLinkedList(new int[]{67, 0, 24, 58});

        ListNode head2 = new ListNode(1);
        ListNode head3 = null;
//        ArrayList<Integer> reverseValues = printListFromTailToHead(head);
//        System.out.println(reverseValues.toString());
        PrintListFromTailToHead obj = new PrintListFromTailToHead();
        ArrayList<Integer> res = obj.printListFromTailToHead(test);
        System.out.println(res);
    }

    ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return res;
        }
        ListNode nxt = listNode.next;
        printListFromTailToHead(nxt);
        res.add(listNode.val);
        return res;
    }

    /**
     * NK
     * @param listNode
     * @return
     */
    public static ArrayList<Integer> solution(ListNode listNode) {
//        return stoSolutionRecur(listNode);
//        return zsSolutionReversePointer(listNode);
        return solutionInsertHeadNodeCYC(listNode);
    }

    /**
     * LC
     * @param head
     * @return
     */
    public static int[] reversePrint(ListNode head) {
//        return solutionReversePointer(head);
        return solutionStack(head);
    }


    private static int[] solutionStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }


    private static int[] solutionReversePointer(ListNode head) {
        if (head == null) {
            return new int[0];
        }
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        int listSize = 0;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            listSize++;
        }
        // 如果head == null了，说明head移到边界之外了，只要返回pre记录的边界位置就行了
//        return pre;
        cur = pre;
        // 装进数组
        int[] res = new int[listSize];
        for (int i = 0; i < listSize; i++) {
            res[i] = cur.val;
            cur = cur.next;
        }
        return res;
    }


    /**
     *
     * @param head head
     * @return
     */
    private static ArrayList<Integer> solutionInsertHeadNodeCYC(ListNode head) {
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
    public static ArrayList<Integer> solutionRecurSTO(ListNode head) {
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
    public static ArrayList<Integer> solutionStackArrayList(ListNode head) {
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
    public static ArrayList<Integer> solutionReversePointerZS(ListNode head) {
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
