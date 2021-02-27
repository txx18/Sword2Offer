package array.partition;

/**
 * 根据快速排序的思路
 * @author ShaneTang
 * @create 2021-02-27 11:57
 */
public class FindKthLargest {

    /**
     * 通过LC NK
     *
     * @param a
     * @param n
     * @param K
     * @return
     */
    public int findKth(int[] a, int n, int K) {
        // write code here
        // 转换一下，找第n-K小的数
        return findK(a, 0, n - 1, n - K);
    }

    private int findK(int[] a, int l, int r, int K) {
        int lessEqualRight = partition(a, l, r);
        if (K < lessEqualRight) {
            findK(a, l, lessEqualRight - 1, K);
        } else if (K > lessEqualRight) {
            findK(a, lessEqualRight + 1, r, K);
        }
        return a[K];
    }

    private int partition(int[] arr, int l, int r) {
        int pivotVal = arr[r];
        int lessEqualRight = l - 1;
        for (int i = l; i <= r; i++) {
            if (arr[i] <= pivotVal) {
                swap(arr, i, ++lessEqualRight);
            }
        }
        return lessEqualRight;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
