package linkedList;

import zhelper.ListUtils;
import zhelper.ListUtils.*;

import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-25 20:57
 */
public class PalindromeList {


    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 1};
        int[] arr2 = {1, 2, 3, 2, 1};
        ListNode list1 = ListUtils.convertToLinkedList(arr2);
        ListUtils.printSingleList(list1);

        PalindromeList obj = new PalindromeList();
//        boolean res = obj.isPalindrome(list1);

//        boolean res = obj.chkPalindrome(list1);
        boolean res = obj.isPalindrome(list1);
        System.out.println("res = " + res);
        ListUtils.printSingleList(list1);
    }

    public boolean chkPalindrome(ListNode A) {
        // write code here
        // copy the list
        if (A == null) {
            return false;
        }
        ListNode copyHead = new ListNode(-1);
        ListNode cur1 = A;
        ListNode cur2 = copyHead;
        while (cur1 != null) {
            ListNode newNode = new ListNode(cur1.val);
            cur2.next = newNode;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        ListNode copyTail = reverse(copyHead.next);
        cur1 = A;
        cur2 = copyTail;
        while (cur1 != null) {
            if (cur1.val != cur2.val) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }

    private ListNode reverse(ListNode a) {
        ListNode cur = a;
        ListNode pre = null;
        ListNode nxt = null;
        while (cur != null) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public boolean isPalindrome(ListNode head) {
//        return solutionStack(head);
//        return solutionFastSlowPointer(head);
        return solutionSlowFastPointer(head);
    }

    private boolean solutionSlowFastPointer(ListNode A) {
        ListNode slow, fast;
        slow = fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        ListNode l = A;
        ListNode r = reverse(slow);
        while (r != null) {
            if (l.val != r.val) {
                return false;
            }
            l = l.next;
            r = r.next;
        }
        return true;
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 99.72%
     * 的用户
     * 内存消耗 :
     * 41.9 MB
     * , 在所有 Java 提交中击败了
     * 22.60%
     * 的用户
     *
     * @param head
     * @return
     */
    private boolean solutionFastSlowPointer(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 找到中点,slow走完
        // TODO 如果是奇数个节点，slow停正中间节点，如果是偶数个节点，slow停靠左的一个
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 重连指针，使right区域逆序
        // 中间断开
        fast = slow.next;
        slow.next = null;
        ListNode next = null;
        // 反转链表right区域，slow停在尾节点
        while (fast != null) {
            next = fast.next;
            fast.next = slow;
            slow = fast;
            fast = next;
        }
        ListNode last = slow;
        ListNode toLeft = slow;
        ListNode toRight = head;
        // 同时遍历，遇到不同返回false
        while (toLeft != null && toRight != null) {
            if (toLeft.val != toRight.val) {
                return false;
            }
            toLeft = toLeft.next;
            toRight = toRight.next;
        }
        // 恢复原链表，再次反转链表right区
        ListNode cur = last;
        ListNode pre = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return true;
    }

    /**
     * 执行用时 :
     * 4 ms
     * , 在所有 Java 提交中击败了
     * 28.17%
     * 的用户
     * 内存消耗 :
     * 44.7 MB
     * , 在所有 Java 提交中击败了
     * 5.00%
     * 的用户
     *
     * @param head
     * @return
     */
    private boolean solutionStack(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.val != stack.pop()) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }
}
