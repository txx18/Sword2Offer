package linkedList;

import zhelper.ArrayUtils;
import zhelper.ListUtils;
import zhelper.ListUtils.*;


/**
 * 86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-26 16:08
 */
public class Partition {

    public static void main(String[] args) {
        int[] arr1 = {1, 4, 3, 2, 5, 2};
        int[] arr2 = {2, 1};
        ListNode list1 = ListUtils.convertToLinkedList(arr1);
        ListUtils.printSingleList(list1);

        Partition obj = new Partition();
        ListNode res = obj.partition(list1, 0);
        ListUtils.printSingleList(res);
    }

    public ListNode partition(ListNode head, int x) {
//        return solutionArraySimplePartition(head, x);
        return solution4Pointer(head, x);
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 74.57%
     * 的用户
     * 内存消耗 :
     * 37.6 MB
     * , 在所有 Java 提交中击败了
     * 5.34%
     * 的用户
     * @param head
     * @param x
     * @return
     */
    private ListNode solution4Pointer(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode sl = null;
        ListNode sr = null;
        ListNode gl = null;
        ListNode gr = null;
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            if (cur.val < x) {
                // 如果还没有小于区，先建立一个节点
                if (sl == null) {
                    sl = cur;
                    sr = cur;
                }
                else {
                    sr.next = cur;
                    sr = sr.next;
                }
            }
            else { // cur.val >= x
                if (gl == null) {
                    gl = cur;
                    gr = cur;
                }
                else {
                    gr.next = cur;
                    gr = gr.next;
                }
            }
            // 每处理一个数都要断开指针
            cur.next = null;
            cur = next;
        }
        // 最后把sr和gl相连
        if (sr != null) {
            sr.next = gl;
        }
        return sl != null ? sl : gl;
    }

    public static ListNode list3PartitionZS(ListNode head, int pivot) {
        ListNode sH = null; // small head
        ListNode sT = null; // small tail
        ListNode eH = null; // equal head
        ListNode eT = null; // equal tail
        ListNode bH = null; // big head
        ListNode bT = null; // big tail
        ListNode next = null; // save next node
        // every node distributed to three lists
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.next = head;
                    sT = head;
                }
            } else if (head.val == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        // small and equal reconnect
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        // all reconnect
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }

    /**
     * 超时
     *
     * @param head
     * @param x
     * @return
     */
    private ListNode solutionArraySimplePartition(ListNode head, int x) {
        // 申请一个数组，把节点都放进去
        // 注意一定得装节点，不然没法重连了
        ListNode[] nodeArray = ListUtils.convertToNodeArray(head);
        // 在数组上Partition
        simplePartition(nodeArray, x);
        // 重连节点
        return ArrayUtils.convertToLinkedList(nodeArray);
    }

    private int simplePartition(ListNode[] nodeArray, int x) {
        int lessRightIdx = -1;
        for (int i = 0; i < nodeArray.length; i++) {
            if (nodeArray[i].val < x) {
                ArrayUtils.swap(nodeArray, i, ++lessRightIdx);
            }
        }
        return lessRightIdx;
    }
}
