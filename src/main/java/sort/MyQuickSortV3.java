package sort;

import zhelper.ArrayUtils;

import java.util.Arrays;


/**
 * TO DO
 *
 * @author Shane Tang
 * @create 2019-09-16 20:31
 */
public class MyQuickSortV3 {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(Arrays.toString(arr1));
        int[] lastPartitionIdxes = solution(arr1);
        System.out.println(Arrays.toString(lastPartitionIdxes));
        System.out.println(Arrays.toString(arr1));
    }

    public static int[] solution(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        return recurProcess(arr, 0, arr.length - 1);
    }

    /**
     * @param arr
     * @param l
     * @param r
     * @return 等于区左右边界
     */
    private static int[] recurProcess(int[] arr, int l, int r) {
/*        if (l == r) {
            return null;
        }*/
        int[] partitionIdxes = null;
        if (l < r) {
            // 先partition
            // 快排3.0，利用3段划分，而且从l~r-1随机选一个数
            int pivotIdx = l + (int) (Math.random() * (r - l + 1));
//            System.out.println("pivot = " + pivot);
            // 把pivot交换到r
            ArrayUtils.swap(arr, pivotIdx, r);
            // 返回 等于区左右边界
            partitionIdxes = partition(arr, l, r);
//            System.out.println(Arrays.toString(partitionIdxes));
            // 递归调用  左边排序，代入小于区域右边界
            recurProcess(arr, l, partitionIdxes[0] - 1);
            // 递归调用 右边排序，代入大于区域左边界
            recurProcess(arr, partitionIdxes[1] + 1, r);
//        System.out.println(Arrays.toString(partitionIdxes));

        }
        return partitionIdxes;
    }

    /**
     *
     * @param arr
     * @param l
     * @param r
     * @return 等于区左右边界
     */
    public static int[] partition(int[] arr, int l, int r) {
        // 小于区右边界
        int lt = l - 1;
        // 大于区左边界
        int gt = r;
        // 指针
        int i = l;
        while (i < gt) {
            if (arr[i] < arr[r]) {
                ArrayUtils.swap(arr, i++, ++lt);
            } else if (arr[i] > arr[r]) {
                // i不++因为换过来的arr[moreIndex-1]还没判断
                ArrayUtils.swap(arr, i, --gt);
            } else { // == num
                i++;
            }
        }
        // 交换 大于区域左边界 和 r位置，大于区域左边界变成了等于区域右边界
        ArrayUtils.swap(arr, gt, r);
        return new int[]{lt + 1, gt};
    }

}
