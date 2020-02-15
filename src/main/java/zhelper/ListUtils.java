package zhelper;

/**
 * @author Shane Tang
 * @create 2019-10-04 21:27
 */
public class ListUtils {


    public static void printSingleList(ListNode head) {
        while (head != null) {
            if(head.next == null){
                System.out.print(head.val);
                return;
            }
            System.out.print(head.val + "-->");
            head = head.next;
        }
        System.out.println();
    }

    public static void printDoubleList(DoubleNode head) {
        while (head != null) {
            if(head.next == null){
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
