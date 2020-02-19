package array.partition.e39;

import zhelper.ArrayUtils;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * <p>
 * <p>
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-09 15:08
 */
public class AppearMoreThanHalfNum {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] arr2 = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        int[] arr3 = {1};
        int[] arr4 = {2, 2, 2, 2, 2, 1, 3, 4, 5};
        int[] arr5 = {2, 2, 1, 1, 1, 2, 2};
        int res = majorityElement(arr1);

        System.out.println("res = " + res);
    }

    /**
     * NK
     *
     * @param array
     * @return
     */
    public static int MoreThanHalfNum_Solution(int[] array) {
        // 元素个数为1的时候可不是返回0
        if (array == null || array.length < 1) {
            return 0;
        }
//        return sortProcessRecur(array, 0, array.length - 1);
        return solutionSimplePartitionLoop(array, 0, array.length - 1);
    }

    /**
     * LC
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        return solutionSimplePartitionRecur(nums, 0, nums.length - 1);
//        return solutionSimplePartitionLoop(nums, 0, nums.length - 1);
    }

    /**
     * 转化为：找排序后的中位数，而且中位数出现的次数确实得超过一半
     *
     * 执行用时 :
     * 2095 ms
     * , 在所有 Java 提交中击败了
     * 5.29%
     * 的用户
     * 内存消耗 :
     * 49.6 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int solutionSimplePartitionLoop(int[] arr, int l, int r) {
        // 注意元素个数为1的时候可不是返回0
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int mid = arr.length >> 1;
        // 很难加随机，而递归可以很容易加随机
/*        int pivot = l + (int) (Math.random() * (r - l + 1));
        swap(arr, pivot, r);*/
        int lessEqualIdx = simplePartition(arr, l, r);
        while (lessEqualIdx != mid) {
            if (lessEqualIdx < mid) {
                lessEqualIdx = simplePartition(arr, lessEqualIdx + 1, r);
            }
            else {

                lessEqualIdx = simplePartition(arr, l, lessEqualIdx - 1);
            }
        }
        // 如果lessEqualIdx == mid
        int candidate = arr[lessEqualIdx];
        boolean isMoreThanHalf = checkMoreThanHalf(arr, candidate);
        if (isMoreThanHalf) {
            return candidate;
        }
        return 0;
    }

    /**
     * 转化为：找排序后的中位数，而且中位数出现的次数确实得超过一半
     *
     * 执行用时 :
     * 831 ms
     * , 在所有 Java 提交中击败了
     * 5.29%
     * 的用户
     * 内存消耗 :
     * 52.3 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int solutionSimplePartitionRecur(int[] arr, int l, int r) {
        // 注意元素个数为1的时候可不是返回0
        if (arr == null || arr.length < 1) {
            return 0;
        }
        int mid = arr.length >> 1;
        int pivotIdx = l + (int) (Math.random() * (r - l + 1));
        swap(arr, pivotIdx, r);
        // 调用simplePartition必须以[r]为基准元
        int lessEqualIdx = simplePartition(arr, l, r);
        if (lessEqualIdx < mid) {
            return solutionSimplePartitionRecur(arr, lessEqualIdx + 1, r);
        }
        else if (lessEqualIdx > mid) {
            return solutionSimplePartitionRecur(arr, l, lessEqualIdx - 1);
        }
        // 如果lessEqualIdx == mid
        int candidate = arr[lessEqualIdx];
        boolean isMoreThanHalf = checkMoreThanHalf(arr, candidate);
        if (isMoreThanHalf) {
            return candidate;
        }
        return -1;
    }

    private static boolean checkMoreThanHalf(int[] arr, int candidate) {
        int times = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == candidate) {
                times++;
            }
        }
        return times > (arr.length >> 1);
    }

    private static int simplePartition(int[] arr, int l, int r) {
        int lessEqualIdx = l - 1;
        for (; l <= r; l++) {
            if (arr[l] <= arr[r]) {
                // 只靠小于等于区域右扩
                swap(arr, ++lessEqualIdx, l);
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
