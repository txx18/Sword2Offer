package zhelper;


import java.util.Arrays;
import java.util.List;

/**
 * @author Shane Tang
 * @create 2019-10-04 21:27
 */
public class ListUtils {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5, 6};
        int[] arr3 = {1, 2};
        int[] arr4 = {1};
        int[] arr5 = null;
        int[] arr6 = {1, 3, 5, 7};
        int[] arr7 = {2, 4, 6, 8};
        ListNode list1 = convertToLinkedList(arr2);
        printSingleList(list1);

        ListNode[] res = convertToNodeArray(list1);
        System.out.println(Arrays.toString(res));
    }

    public static int[] convertToArray(List<Integer> arrayList) {
        int[] res = new int[arrayList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = arrayList.get(i);
        }
        return res;
    }

    public static int size(ListNode head) {
        ListNode cur = head;
        int listSize = 0;
        while (cur != null) {
            listSize++;
            cur = cur.next;
        }
        return listSize;
    }

    public static ListNode convertToLinkedList(int[] arr) {
        ListNode newHead = new ListNode(-1);
        if (arr == null || arr.length < 1) {
            return null;
        }
        ListNode cur = newHead;
        for (int i = 0; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return newHead.next;
/*        if (arr == null || arr.length < 1) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;*/
    }

    /**
     * 不修改原链表原则！不然你再定位head的时候都不知道错哪儿
     * @param head
     */
    public static ListNode printSingleList(ListNode head) {
        if (head == null) {
            System.out.println("linkedList = null" );
            return null;
        }
        System.out.print("linkedList = ");
        ListNode cur = head;
//        ListNode next = null;
        while (cur != null) {
            if (cur.next != null) {
                System.out.print(cur.val + " --> ");
            }
            else {
                System.out.print(cur.val + " --> null");
            }
            cur = cur.next;
            /*            if (cur.next != null) {
                System.out.print(cur.val + " --> ");
                cur = cur.next;
                continue;
            }
            // cur.next == null
            System.out.print(cur.val + " --> null");
            System.out.println();
            break;*/
        }
        System.out.println();
        return head;
    }

    public static void printDoubleList(DoubleNode head) {
        while (head != null) {
            if (head.next == null) {
                System.out.print(head.data);
                return;
            }
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static int[] convertToArray(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        int listSize = size(cur);
        int[] arr = new int[listSize];
        cur = head;
        for (int i = 0; i < listSize; i++) {
            arr[i] = cur.val;
            cur = cur.next;
        }
        return arr;
    }

    public static ListNode[] convertToNodeArray(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        int listSize = size(cur);
        ListNode[] arr = new ListNode[listSize];
        cur = head;
        for (int i = 0; i < listSize; i++) {
            arr[i] = cur;
            cur = cur.next;
        }
        return arr;
    }

    public static class ListNode {
        // 数据域
        public int val;
        // 指针域
        public ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public static class DoubleNode {

        // 数据域
        public int data;
        // 指针域
        public DoubleNode next;
        public DoubleNode pre;

        DoubleNode() {
        }

        public DoubleNode(int data) {
            this.data = data;
        }

        public DoubleNode(int data, DoubleNode next, DoubleNode pre) {
            this.data = data;
            this.next = next;
            this.pre = pre;
        }
    }
}
