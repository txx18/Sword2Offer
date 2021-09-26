package heap;

import java.util.PriorityQueue;

/**
 * @author ShaneTang
 * @create 2021-02-27 12:35
 */
public class FindKthLargest {

    public static void main(String[] args) {
        FindKthLargest obj = new FindKthLargest();
        int[] arr1 = new int[]{1, 3, 5, 2, 2};
        int res = obj.findKth(arr1, arr1.length, 3);
        System.out.println("res = " + res);
    }


    public int findKth(int[] a, int n, int K) {
        // write code here
        // 小根堆
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < a.length; i++) {
            pq.add(a[i]);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}

// 大根堆
//(o1, o2) -> o2.compareTo(o1)