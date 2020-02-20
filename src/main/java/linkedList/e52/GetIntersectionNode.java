package linkedList.e52;

import zhelper.ListUtils;
import zhelper.ListUtils.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 *  TODO 进阶：链表有环的情况
 * 注意：
 * <p>
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * 本题与主站 160 题相同：https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-20 16:30
 */
public class GetIntersectionNode {

/*    public static void main(String[] args) {
        int[] arr1 = {4, 1, 8, 4, 5};
        int[] arr2 = {5, 0, 1, 8, 4, 5};
        ListNode list1 = ListUtils.convertToLinkedList(arr1);
        ListNode list2 = ListUtils.convertToLinkedList(arr2);
        ListUtils.printSingleList(list1);
        ListUtils.printSingleList(list2);

        ListNode res = getIntersectionNode(list1, list2);
        ListUtils.printSingleList(res);
    }*/

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return solutionFSPointerME(headA, headB);
    }

    /**
     * 执行用时 :
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 42.17%
     * 的用户
     * 内存消耗 :
     * 43 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param head1
     * @param head2
     * @return
     */
    private static ListNode solutionFSPointerME(ListNode head1, ListNode head2) {
        // 计算两个链表的长度差
        int listSize1 = ListUtils.getListSize(head1);
        int listSize2 = ListUtils.getListSize(head2);
        int diff = Math.abs(listSize1 - listSize2);
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        if (listSize2 > listSize1) {
            // list2 先走 diff 步
            for (int i = 0; i < diff; i++) {
                cur2 = cur2.next;
            }
        }
        else if (listSize1 > listSize2) {
            // list1 先走 diff 步
            for (int i = 0; i < diff; i++) {
                cur1 = cur1.next;
            }
        }
        // 包括listSize1 == listSize2的情况
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
}
