package sort;

import zhelper.ArrayUtils;

import java.util.Arrays;


/**
 * 对数器
 *
 * @author Shane Tang
 * @create 2019-09-16 20:31
 */
public class MyQuickSortV1 {

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 1, 6, 2, 7, 3, 8, 4};
//        int partition = simplePartition(arr1, 0, arr1.length - 1);
//        System.out.println("partition = " + partition);
//        System.out.println(Arrays.toString(arr1));
        MyQuickSortV1 obj = new MyQuickSortV1();
        int[] res = obj.MySort(arr1);
        System.out.println("res = " + Arrays.toString(res));

    }

    public int[] MySort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        return sortProcess(arr, 0, arr.length - 1);
    }

    private int[] sortProcess(int[] arr, int l, int r) {
        if (l >= r) { // 不能写 l == r，可以写 l > r
            return arr;
        }
        // 先partition
        // 快排1.0，利用两段划分，注意r取的都是最右边的数
        int lessEqualRight = partition(arr, l, r);
        // 左边排序
        sortProcess(arr, l, lessEqualRight - 1);
        // 右边排序
        sortProcess(arr, lessEqualRight + 1, r);
        return arr;
    }

    private int partition(int[] arr, int l, int r) {
        int pivotVal = arr[r];
        int lessEqualRight = l - 1;
        for (int i = l; i <= r; i++) { //注意arr[r]也要判断
            if (arr[i] <= pivotVal) {
                // 只靠lessEqual区域右扩
                swap(arr, i, ++lessEqualRight);
            }
        }
        return lessEqualRight;
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 通过
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int simplePartitionWZ(int[] arr, int l, int r) {
        int pivot = arr[r];
        int lessEqualIdx = l;
        for (int i = l; i < r; i++) { //注意arr[r]也要判断
            if (arr[i] <= pivot) {
                // 只靠小于等于区域右扩
                ArrayUtils.swap(arr, i, lessEqualIdx);
                lessEqualIdx++;
            } else {

            }
        }
        ArrayUtils.swap(arr, r, lessEqualIdx);
        return lessEqualIdx;
    }
}
