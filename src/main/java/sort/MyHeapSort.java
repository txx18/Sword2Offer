package sort;

import java.util.Arrays;

public class MyHeapSort {

    public static void main(String[] args) {
        MyHeapSort obj = new MyHeapSort();
        int[] arr = new int[]{5, 2, 3, 1, 4};
        int[] res = obj.MySort(arr);
        System.out.println("res = " + Arrays.toString(res));
    }

    /**
     * 通过LC NK
     *
     * @param arr
     * @return
     */
    public int[] MySort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int heapSize = arr.length - 1;
         // 堆化成大根堆 下沉方法
       for (int i = heapSize / 2; i >= 0; i--) {
            sink(arr, i, heapSize);
        }
/*        // 上浮方法
        for (int i = 0; i < nums.length; i++) {
            swim(nums, i);
        }*/
        // 堆排序
        while (heapSize > 0) {
            swap(arr, 0, heapSize--);
            sink(arr, 0, heapSize);
        }
        return arr;
    }

    private void sink(int[] arr, int i, int heapSize) {
        while (2 * i + 1 <= heapSize) {
            // 子节点j
            int j = 2 * i + 1;
            if (j < heapSize && arr[j] < arr[j + 1]) { // j < heapSize
                j++;
            }
            // 停止：父节点 >= 子节点
            if (arr[i] >= arr[j]) {
                break;
            }
            swap(arr, i, j);
            i = j;
        }
    }

    private void swim(int[] arr, int i) {
        // 循环： 父节点 < 子节点
        while (i > 0 && arr[(i - 1) / 2] < arr[i]) {
            swap(arr, (i - 1) / 2, i);
            i = (i - 1) / 2;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
