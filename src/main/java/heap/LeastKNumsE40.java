package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * TODO BFPRT算法
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-10 10:24
 */
public class LeastKNumsE40 {

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 1, 6, 2, 7, 3, 8, 0};
        int[] arr2 = {4, 5, 1, 6, 2, 7, 3, 8};
        int[] arr3 = {};
        int[] arr4 = {0,0,0,2,0,5};
//        int partition = partition(arr1, 0, arr1.length - 1);
//        System.out.println("partition = " + partition);
//        ArrayList<Integer> list = GetLeastNumbers_Solution(arr1, 4);
        int[] res = getLeastNumbers(arr1, 4);
        System.out.println(Arrays.toString(res));

    }


    public static int[] getLeastNumbers(int[] arr, int k) {
//        return solutionPriorityQueue(arr, k);
        return solutionBigHeap(arr, k);
    }

    /**
     * 执行用时 :
     * 22 ms
     * , 在所有 Java 提交中击败了
     * 27.48%
     * 的用户
     * 内存消耗 :
     * 49.6 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param arr
     * @param k
     * @return
     */
    private static int[] solutionPQ(int[] arr, int k) {
        // 防御
        if (arr == null || arr.length < 1 || k > arr.length || k == 0) {
            return new int[0];
        }
        // 准备一个容量为k大根堆，优先队列默认是小根堆，需要配置比较器
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new BigHeapComparator());
        // 先进k个数
        for (int i = 0; i < k; i++) {
            priorityQueue.add(arr[i]);
        }
        // 剩下的数一个一个进，跟堆中最大数比较，如果大，那不可能是候选数，跳过；如果小，则替换原来的最大数
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            }
        }
        // 返回queue中的元素
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll();
        }
        return res;
    }

    /**
     * 执行用时 :
     * 5 ms
     * , 在所有 Java 提交中击败了
     * 89.66%
     * 的用户
     * 内存消耗 :
     * 42.9 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param input
     * @param k
     * @return
     */
    private static int[] solutionBigHeap(int[] input, int k) {
        // 防御
        if (input == null || input.length < 1 || k > input.length || k == 0) {
            return new int[0];
        }
        // 准备一个大小为k的大根堆
        int heapSize = k;
        int[] heap = new int[heapSize];
        // 先进k个数
        for (int i = 0; i < heapSize; i++) {
            heap[i] = input[i];
        }
        // heapify
        for (int i = heapSize - 1; i >= 0; i--) {
            heapify(heap, i, heapSize);
        }
        // 剩下的数一个一个进，跟堆中最大数比较，如果大，那不可能是候选数；如果小，则替换原来的最大数
        for (int i = heapSize; i < input.length; i++) {
            if (input[i] < heap[0]) {
                heap[0] = input[i];
                heapify(heap, 0, heapSize);
            }
        }
        // 返回heap中的元素
        return heap;
    }

    /**
     * 快速选择算法
     *
     * 执行用时 :
     * 679 ms
     * , 在所有 Java 提交中击败了
     * 5.30%
     * 的用户
     * 内存消耗 :
     * 48.9 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param arr
     * @param k
     * @return
     */
    private static int[] solutionSimplePartition(int[] arr, int k) {
        if (arr == null || arr.length < 1 || k > arr.length) {
            return null;
        }
        int l = 0, r = arr.length - 1;
        int pivotIdx = l + (int) (Math.random() * (r - l + 1));
        swap(arr, pivotIdx, r);
        int lessEqualIdx = simplePartition(arr, l, r);
        while (lessEqualIdx != k - 1) {
            if (lessEqualIdx < k - 1) {
                lessEqualIdx = simplePartition(arr, lessEqualIdx + 1, r);
            } else if (lessEqualIdx > k - 1) {
                lessEqualIdx = simplePartition(arr, l, lessEqualIdx - 1);
            }
        }
        // lessEqualIdx = k - 1 返回lessEqual区域的数
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }


    private static class BigHeapComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    private static void heapify(int[] input, int idx, int heapSize) {
        int left = 2 * idx + 1;
        for (; left < heapSize; ) {
            int largest = (left + 1 < heapSize) && (input[left + 1] > input[left]) ? left + 1 : left;
            largest = (input[idx] > input[largest]) ? idx : largest;
            if (largest == idx) {
                break;
            }
            swap(input, largest, idx);
            idx = largest;
            left = 2 * idx + 1;
        }
    }



    private static int simplePartition(int[] input, int l, int r) {
        int lessEqualIdx = l - 1;
        for (; l <= r; l++) {
            if (input[l] <= input[r]) {
                swap(input, l, ++lessEqualIdx);
            }
        }
        return lessEqualIdx;
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


}
