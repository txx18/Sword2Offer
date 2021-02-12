package binarysearch;

import java.util.Arrays;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-06 11:53
 */
public class NumCountOfSortArr {

    public static void main(String[] args) {
        int[] arr1 = {3, 5, 11, 17, 21, 23, 28, 28, 28, 28, 30, 32, 50, 64, 64, 78, 81, 95, 101};
        int[] arr2 = {1, 2, 3, 3, 3, 3, 4, 6};
        int res = search(arr2, 3);
        System.out.println("res = " + res);
    }


    /**
     * LC
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
//        return mySolutionBSRecur(nums, target);
//        return solutionByTraverse(nums, target);
        return solutionBSLoop(nums, target);
    }

    /**
     * 已通过NKOJ
     */
    public static int solutionBSLoop(int[] array, int k) {
        // 搜索k和k+1的左边界
        int firstIndex = BS(array, k);
        int lastIndex = BS(array, k + 1);
        return (firstIndex == array.length || array[firstIndex] != k) ? 0 : lastIndex - firstIndex;
    }

    private static int BS(int[] nums, int k) {
        int l = 0, r = nums.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (k <= nums[m]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    /**
     * NK
     *
     * @param array
     * @param k
     * @return
     */
    public static int GetNumberOfK(int[] array, int k) {
//        return stoSolutionBSLoop(array, k);
        return solutionBSRecurME(array, k);
    }

    /**
     * 通过NK
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 48.5 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param array
     * @param k
     * @return
     */
    public static int solutionBSRecurME(int[] array, int k) {
        int l = 0, r = array.length - 1;
        int firstIdx = getFirstIdxByRecur(array, l, r, k);
        if (firstIdx < 0) {
            return 0;
        }
        int lastIdx = getLastIdxByRecur(array, l, r, k);
//        System.out.println("firstIdx = " + firstIdx);
//        System.out.println("lastIdx = " + lastIdx);
        return lastIdx - firstIdx + 1;
    }

    private static int getFirstIdxByRecur(int[] array, int l, int r, int k) {
        if (l > r) {
            return -1;
        }
        int mid = l + ((r - l) >> 1);
        if (k < array[mid]) {
            return getFirstIdxByRecur(array, l, mid - 1, k);
        } else if (k > array[mid]) {
            return getFirstIdxByRecur(array, mid + 1, r, k);
        } else {
            if ((mid == 0 || array[mid - 1] != k)) {
                return mid;
            }
            return getFirstIdxByRecur(array, l, mid - 1, k);
        }
    }

    private static int getLastIdxByRecur(int[] array, int l, int r, int k) {
        if (l > r) {
            return -1;
        }
        int mid = l + ((r - l) >> 1);
        if (k < array[mid]) {
            return getLastIdxByRecur(array, l, mid - 1, k);
        } else if (k > array[mid]) {
            return getLastIdxByRecur(array, mid + 1, r, k);
        } else {
            if ((mid == array.length - 1 || array[mid + 1] != k)) {
                return mid;
            }
            return getLastIdxByRecur(array, mid + 1, r, k);
        }
    }

    /**
     * 已通过NKOJ
     *
     * @param sortedArr
     * @param k
     * @return
     */
    private static int solutionBSLoopSTO(int[] sortedArr, int k) {
        int firstIdx = getFirstIdx(sortedArr, k);
        if (firstIdx < 0) {
            return 0;
        }
        int lastIdx = getLastIdx(sortedArr, k);
//        System.out.println("firstIdx = " + firstIdx);
//        System.out.println("lastIdx = " + lastIdx);
        return lastIdx - firstIdx + 1;
    }

    private static int getFirstIdx(int[] sortedArr, int k) {
        // 关键：l <= r
        int mid = -1;
        for (int l = 0, r = sortedArr.length - 1; l <= r; ) {
            mid = l + ((r - l) >> 1);
            if (k < sortedArr[mid]) {
                r = mid - 1;
            } else if (k > sortedArr[mid]) {
                l = mid + 1;
            } else {
/*                if ((mid > 0 && sortedArr[mid - 1] == k)){
                    r = mid - 1;
                }
                else {
                    return mid;
                }*/
                if ((mid == 0 || sortedArr[mid - 1] != k)) {
                    return mid;
                }
                r = mid - 1;
            }

        }
        return -1;
    }

    private static int getLastIdx(int[] sortedArr, int k) {
        // 关键：l <= r
        for (int l = 0, r = sortedArr.length - 1, mid = -1; l <= r; ) {
            mid = l + ((r - l) >> 1);
            if (k < sortedArr[mid]) {
                r = mid - 1;
            } else if (k > sortedArr[mid]) {
                l = mid + 1;
            } else {
                if (mid < sortedArr.length - 1 && sortedArr[mid + 1] == k) {
                    l = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    /**
     * 左右扫描，时间O(n)，效率和遍历一样，面试官不会满意
     *
     * @param sortedArr
     * @param k
     * @return
     */
    private static int solutionUseJdk(int[] sortedArr, int k) {
        int cnt = 0;
        // https://docs.oracle.com/javase/8/docs/api/index.html
        // binarySearch()方法的返回值为：
        // 1、如果找到关键字，则返回值为关键字在数组中的位置索引，且索引从0开始，如果包含重复元素，不保证返回哪个
        // 2、如果没有找到关键字，返回值为负的插入点值，所谓插入点值就是第一个比关键字大的元素在数组中的位置索引，而且这个位置索引从1开始。
        int oneIdx = Arrays.binarySearch(sortedArr, k);
        if (oneIdx < 0) {
            return 0;
        }
        for (int i = oneIdx; i >= 0; i--) {
            if (sortedArr[i] == k) {
                cnt++;
            }
        }
        for (int i = oneIdx + 1; i < sortedArr.length; i++) {
            if (sortedArr[i] == k) {
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 44.93%
     * 的用户
     * 内存消耗 :
     * 48.9 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param arr
     * @param k
     * @return
     */
    private static int solutionTraverse(int[] arr, int k) {
        // 出现一次，就记录一次
        int count = 0;
        for (int value : arr) {
            if (value == k) {
                count++;
            }
        }
        return count;
    }


}
