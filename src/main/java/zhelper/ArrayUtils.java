package zhelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import zhelper.ListUtils.*;

import zhelper.TreeUtils.*;

/**
 * @author Shane Tang
 * @create 2019-09-28 11:03
 */
public class ArrayUtils {

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 1, 6, 2, 7, 3, 8};
        Integer[] arr2 = {1,3,2,5,3, null, 9};
        Integer[] arr3 = {5, 4, 7, 3, null, 2, null, -1, null, 9};
        Integer[] arr4 = {1, 2, 3, 4, 5};

        TreeNode res = convertToCBT(arr4);
        TreeUtils.printTree(res);
    }

    /**
     * 【注意】不是完全二叉树不能用索引
     * @param arr 不能含null
     * @return
     */
    public static TreeNode convertToCBT(Integer[] arr) {
        if (arr == null) {
            return null;
        }
        // 建节点，放入map<编号,节点>
        HashMap<Integer, TreeNode> map = new HashMap<>(arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                TreeNode cur = new TreeNode(arr[i]);
                map.put(i, cur);
            }
            else {
                map.put(i, null);
            }
        }
        // 按照完全二叉树连接指针
        for (Integer i : map.keySet()) {
            TreeNode cur = map.get(i);
            int leftIdx = 2 * i + 1;
            int rightIdx = 2 * i + 2;
            if (leftIdx <= map.size()) {
                cur.left = map.get(leftIdx);
            }
            if (rightIdx <= map.size()) {
                cur.right = map.get(rightIdx);
            }
        }
        return map.get(0);
    }

    public static ArrayList<Integer> convertToArrayList(int[] arr) {
        if (arr == null || arr.length < 1) {
            return null;
        }
        ArrayList<Integer> res = new ArrayList<>(arr.length);
        for (int value : arr) {
            res.add(value);
        }
        return res;
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

    public static ListNode convertToLinkedList(ListNode[] arr) {
        if (arr == null || arr.length < 1) {
            return null;
        }
        ListNode cur = arr[0];
        for (int i = 1; i < arr.length; i++) {
            cur.next = arr[i];
            cur = cur.next;
        }
        return arr[0];
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        // 异或方法i不能等于j
/*        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];*/
    }

    /**
     * 把节点交换
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(ListNode[] arr, int i, int j) {
        ListNode tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void myPrintArrayList(List list) {
        StringBuilder sb = new StringBuilder("[");
        if (list == null || list.size() < 1) {
            sb.append("]");
            System.out.println(sb.toString());
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                sb.append(list.get(i)).append("]");
                break;
            }
            sb.append(list.get(i)).append(", ");
        }
        System.out.println(sb.toString());
    }


    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
                System.out.println();
                return;
            }
            System.out.print(arr[i] + ", ");
        }
    }
}
