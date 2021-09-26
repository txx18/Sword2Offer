package sort;

import zhelper.ArrayUtils;

/**
 * @author GFS
 */
public class MyInsertionSort {

    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // 相等时不交换，实现稳定性
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
        return nums;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


}
