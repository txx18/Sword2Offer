package zhelper;


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
        ListNode head = convertToLinkedList(arr1);
        printSingleList(head);
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


    public static void printSingleList(ListNode head) {
        if (head == null) {
            System.out.println("linkedList = null" );
            return;
        }
        System.out.print("linkedList = ");
        while (head != null) {
            if (head.next != null) {
                System.out.print(head.val + " --> ");
                head = head.next;
                continue;
            }
            System.out.print(head.val);
            System.out.println();
            return;
        }
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
