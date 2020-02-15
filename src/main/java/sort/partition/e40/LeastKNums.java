package sort.partition.e40;

import zhelper.ArrayUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-10 10:24
 */
public class LeastKNums {

    public static void main(String[] args) {
        int[] arr1 = {4,5,1,6,2,7,3,8, 0};
        int[] arr2 = {4,5,1,6,2,7,3,8};
        int[] arr3 = {};
//        int partition = partition(arr1, 0, arr1.length - 1);
//        System.out.println("partition = " + partition);
        ArrayList<Integer> list = GetLeastNumbers_Solution(arr1, 4);
        ArrayUtils.myPrintArrayList(list);

    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
//        return solutionPartition(input, k);
//        return solutionBigHeap(input, k);
        return solutionPriorityQueue(input, k);
    }

    private static ArrayList<Integer> solutionPriorityQueue(int[] input, int k) {
        // 防御
        if (input == null || input.length < 1 || k > input.length || k == 0) {
            return new ArrayList<>(0);
        }
        // 准备一个容量为k大根堆，优先队列默认是小根堆，需要配置比较器
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, new comparatorDESC());
        // 先进k个数
        for (int i = 0; i < k; i++) {
            queue.add(input[i]);
        }
        // 剩下的数一个一个进，跟堆中最大数比较，如果大，那不可能是候选数，跳过；如果小，则替换原来的最大数
        for (int i = k; i < input.length; i++) {
            if (input[i] < queue.peek()) {
                queue.poll();
                queue.add(input[i]);
            }
        }
        return queueToArrayList(queue, k);
    }

    private static class comparatorDESC implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }

    private static ArrayList<Integer> queueToArrayList(PriorityQueue<Integer> queue, int k) {
        ArrayList<Integer> list = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            list.add(queue.poll());
        }
        return list;
    }

    /**
     * 不修改原数组
     * @param input
     * @param k
     * @return
     */
    private static ArrayList<Integer> solutionBigHeap(int[] input, int k) {
        // 防御
        if (input == null || input.length < 1 || k > input.length || k == 0) {
            return new ArrayList<>(0);
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
        // 最后返回堆
        return getNumsLessEqual(heap, heapSize - 1);
    }

    private static void heapify(int[] input, int idx, int heapSize) {
        int left = 2 * idx + 1;
        for (; left < heapSize; ) {
            int largest = (left + 1 < heapSize) && (input[left + 1] > input[left]) ? left + 1: left;
            largest = (input[idx] > input[largest]) ? idx: largest;
            if (largest == idx) {
                break;
            }
            swap(input, largest, idx);
            idx = largest;
            left = 2 * idx + 1;
        }
    }

    /**
     * 转化为：找partition中下标为k-1的下标
     *
     * @param input
     * @param k
     * @return
     */
    private static ArrayList<Integer> solutionPartition(int[] input, int k) {
        if (input == null || input.length < 1 || k > input.length) {
            return new ArrayList<>(0);
        }
        int l = 0, r = input.length - 1;
        int pivot = l + ((int) (Math.random() * (r - l + 1)));
        swap(input, pivot, r);
        int lessEqualIdx = partition(input, l, r);
        for (; l <= r; ) {
            if (lessEqualIdx < k - 1) {
                lessEqualIdx = partition(input, lessEqualIdx + 1, r);
            }
            else if (lessEqualIdx > k - 1) {
                lessEqualIdx = partition(input, l, lessEqualIdx - 1);
            }
            else {
                return getNumsLessEqual(input, lessEqualIdx);
            }
        }
        return new ArrayList<>(0);
    }

    private static ArrayList<Integer> getNumsLessEqual(int[] input, int lessEqualIdx) {
        ArrayList<Integer> list = new ArrayList<>(input.length);
        for (int i = 0; i <= lessEqualIdx; i++) {
            list.add(input[i]);
        }
        return list;
    }

    private static int partition(int[] input, int l, int r) {
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
