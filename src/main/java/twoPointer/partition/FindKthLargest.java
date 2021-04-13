package twoPointer.partition;

/**
 * 根据快速排序的思路
 *
 * @author ShaneTang
 * @create 2021-02-27 11:57
 */
public class FindKthLargest {

    public static void main(String[] args) {
        FindKthLargest obj = new FindKthLargest();
        int[] arr1 = new int[]{1, 3, 5, 2, 2};
        int res = obj.findKth(arr1, arr1.length, 3);
        System.out.println("res = " + res);
    }

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
/*
        // threePartition
        int pivotIdx = l + (int) (Math.random() * (r - l + 1));
        swap(a, pivotIdx, r);
        int[] indexes = threePartition(a, l, r);
        if (K > indexes[1]) {
            findK(a, indexes[1] + 1, r, K);
        } else if (K < indexes[0]) {
            findK(a, l, indexes[0] - 1, K);
        }
        return a[K];*/
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

    public int[] threePartition(int[] arr, int l, int r) {
        int pivotVal = arr[r];
        // 小于区右边界
        int lessRight = l - 1;
        // 大于区左边界
        int greatLeft = r;
        // 指针
        for (int i = l; i < greatLeft; ) { // < 大于区左边界
            if (arr[i] < pivotVal) {
                swap(arr, i++, ++lessRight);
            } else if (arr[i] > pivotVal) {
                // i不++因为换过来的arr[greatLeft-1]还没判断
                swap(arr, i, --greatLeft);
            } else { // == num
                i++;
            }
        }
        // 交换 大于区域左边界 和 r位置，大于区域左边界变成了等于区域右边界
        swap(arr, greatLeft, r);
        return new int[]{lessRight + 1, greatLeft};
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
