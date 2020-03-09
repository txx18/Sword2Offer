package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 要排好一个数组，移动的步长不超过k，选择一种方法排序
 *
 * @author Shane Tang
 * @create 2019-09-26 20:14
 */
public class SortArrayDistanceLessK {
    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 4, 8, 7, 2, 0};
        sortedArrDistanceLessK(arr, 6);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
    }

    private static void sortedArrDistanceLessK(int[] arr, int k) {
        // 从头准备一个小根堆（优先队列）
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        // 把前k个数装进去（如果arr没那么长就全装进去）
        int index = 0;
        while (index <= Math.min(arr.length, k)){
            heap.add(arr[index]);
            index++;
        }
        // 对于k后面多的数，从后面扔一个进去，从前面吐一个出来，并且排在最小的位置
        int i = 0;
        while (index < arr.length){
            heap.add(arr[index]);
            arr[i] = heap.poll();
            index++;
            i++;
        }
        // 最后队列的数依次吐出来
        while (!heap.isEmpty()){
            arr[i] = heap.poll();
            i++;
        }
    }


}
