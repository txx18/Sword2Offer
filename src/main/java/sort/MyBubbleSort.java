package sort;

import zhelper.ArrayUtils;

/**
 * 跟数据状况无关
 */
public class MyBubbleSort {


    public static int[] sortArray(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        // 升序往左冒泡
        // 每趟遍历的起始下标
/*		for (int i = 0; i < nums.length; i++) {
			// 从最右边开始比较；直到i前面；j--不管交不交换都要前移比较前面两个邻居了
			for (int j = nums.length - 1; j > i; j--) {
				// 如果左边>右边，就交换
				if (nums[j - 1] > nums[j]) {
					swap(nums, j - 1, j);
				}
			}
		}*/
        // 升序往右冒泡
        // 规定每趟遍历的终止下标
        for (int i = nums.length - 1; i > 0; i--) {
            // j:参与冒泡元素的下标
            for (int j = 0; j < i; j++) {
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
