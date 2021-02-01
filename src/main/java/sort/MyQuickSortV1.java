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

    // for test
    public static void main(String[] args) {
        int[] arr1 = {4, 5, 1, 6, 2, 7, 3, 8, 4};
        int partition = simplePartition(arr1, 0, arr1.length - 1);
        System.out.println("partition = " + partition);
        System.out.println(Arrays.toString(arr1));

    }

    public static int solution(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }
        return sortProcess(arr, 0, arr.length - 1); // 初始的l和r是arr的左右
    }

    /**
     * 把最右边那个数当作num
     *
     * @param arr
     * @param l
     * @param r
     * @return num该放的位置
     */
    private static int sortProcess(int[] arr, int l, int r) {
        int lessEqualIndex = -1;
        if (l < r) { // 【不是while】
            // 先partition
            // 快排1.0，利用两段划分，注意r取的都是最右边的数
            lessEqualIndex = simplePartition(arr, l, r);
            // 左边排序
            sortProcess(arr, l, lessEqualIndex - 1);
            // 右边排序
            sortProcess(arr, lessEqualIndex + 1, r);

        }
        return lessEqualIndex;
    }

    /**
     * 利用simplePartition
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int simplePartition(int[] arr, int l, int r) {
        int pivotVal = arr[r];
        int lessEqualIdx = l - 1;
        for (int i = l; i <= r; i++) { //注意arr[r]也要判断
            if (arr[i] <= pivotVal) {
                // 只靠小于等于区域右扩
                ArrayUtils.swap(arr, i, ++lessEqualIdx);
            }

        }
        return lessEqualIdx;
    }

    /**
     * 通过
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

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
