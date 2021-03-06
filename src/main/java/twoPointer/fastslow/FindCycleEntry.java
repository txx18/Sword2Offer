package twoPointer.fastslow;

import zhelper.ListUtils;
import zhelper.ListUtils.*;

import java.util.List;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 说明：不允许修改给定的链表。
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-20 20:40
 */
public class FindCycleEntry {

    public static void main(String[] args) {
        int[] arr1 = {3, 2, 0, -4};
        ListNode head1 = ListUtils.convertToLinkedList(arr1);
        head1.next.next.next.next = head1.next;
        ListNode res = detectCycle(head1);
        System.out.println("res = " + res);
    }

    public static ListNode detectCycle(ListNode head) {
        return solutionFastSlowPointerZS(head);
//        return solutionFastSlowPointerFloyd(head);
//        return solutionFastSlowPointerSTO(head);
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow, fast;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycleNK(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 相遇点meet == fast == slow
            if (fast == slow) {
                ListNode p1 = head;
                ListNode p2 = slow;
                while (p1 != p2) {
                    p1 = p1.next;
                    p2 = p2.next;
                }
                return p1;
            }
        }
        return null;
    }

    public ListNode detectCycle1(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        // labuladong的写法在NK通不过
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }


    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 55.21%
     * 的用户
     * 内存消耗 :
     * 41.1 MB
     * , 在所有 Java 提交中击败了
     * 5.03%
     * 的用户
     * @param head
     * @return
     */
    private static ListNode solutionFastSlowPointerZS(ListNode head) {
        if (head == null ||head.next == null || head.next.next == null) {
            return null;
        }
        // 得到环内节点数目k
        // 使用快慢指针
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        // 制造第一次相遇
        while (fast != slow) {
            // fast走到头都没相遇
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        // 第一次相遇后，fast归零重新走
        ListNode res = head;
        // 同时出发，直到相遇
        while (res != slow) {
            res = res.next;
            slow = slow.next;
        }
        return res;
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 41.3 MB
     * , 在所有 Java 提交中击败了
     * 5.03%
     * 的用户
     * @param head
     * @return
     */
    private static ListNode solutionFastSlowPointerFloyd(ListNode head) {
        if (head == null ||head.next == null || head.next.next == null) {
            return null;
        }
        // 得到环内节点数目k
        // 使用快慢指针
        ListNode fast = head;
        ListNode slow = head;
        // 制造第一次相遇
        while (true) {
            if (fast.next == null || fast.next.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        // 第一次相遇后，归零重新走
        ListNode res = head;
        // 同时出发，直到相遇
        while (res != slow) {
            res = res.next;
            slow = slow.next;
        }
        return res;
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 55.21%
     * 的用户
     * 内存消耗 :
     * 41 MB
     * , 在所有 Java 提交中击败了
     * 5.03%
     * 的用户
     * @param head
     * @return
     */
    private static ListNode solutionFastSlowPointerSTO(ListNode head) {
        if (head == null ||head.next == null || head.next.next == null) {
            return null;
        }
        // 得到环内节点数目k
        // 使用快慢指针
        ListNode fast = head.next;
        ListNode slow = head;
        // 制造第一次相遇
        while (fast != slow) {
            // fast走到头都没相遇
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        // 第一次相遇后，开始计数
        int cycleSize = 1;
        ListNode mark = slow;
        while (slow.next != mark) {
            cycleSize++;
            slow = slow.next;
        }
        // front先走cycleSize步
        ListNode front = head;
        ListNode rear = head;
        for (int i = 0; i < cycleSize; i++) {
            front = front.next;
        }
        // 同时出发，直到相遇
        while (front != rear) {
            front = front.next;
            rear = rear.next;
        }
        return rear;

    }


}
