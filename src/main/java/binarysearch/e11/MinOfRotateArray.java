package binarysearch.e11;

/**
 * 旋转数组的最小数字
 *
 * @author Shane Tang
 * @create 2019-10-07 10:45
 */
public class MinOfRotateArray {

    public static int minNumberInRotateArray(int[] array) {
//        return solutionBSLoop(array);
//        return solutionBSRecur(array, 0, array.length - 1);
        return cycMinNumberInRotateArray(array);
    }

    /**
     * 通过NK
     * @param array
     * @param l
     * @param r
     * @return
     */
    public static int mystoSolutionBSRecur(int[] array, int l, int r) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (r - l == 1) {
            return array[r];
        }
        int mid = l + ((r - l) >> 1);
        // 如果一开始中间和两边的数相等，只能采用遍历的方式找最小值
        if (array[mid] == array[l] && array[mid] == array[r]) {
            return findByTraverse(array, l, r);
        }
        // 这里比较保守
        if (array[mid] >= array[l]) {
            return mystoSolutionBSRecur(array, mid, r);
        } else if (array[mid] <= array[r]) {
            return mystoSolutionBSRecur(array, l, mid);
        }
        return -1;
    }

    /**
     * 通过NK
     * @param array 非递减数组
     * @return
     */
    public static int stoSolutionBSLoop(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int l = 0, r = array.length - 1;
        int mid = -1;
        // 保证不越界
        for (; array[l] >= array[r]; ) {
            mid = l + ((r - l) >> 1);
            // 如果一开始中间和两边的数相等，只能采用遍历的方式找最小值
            if (array[mid] == array[l] && array[mid] == array[r]) {
                return findByTraverse(array, l, r);
            }
            if (r - l == 1) {
                return array[r];
            }
            // 二分查找的没有等，比较激进；这里比较保守
            if (array[mid] >= array[l]) {
                l = mid;
            } else if (array[mid] <= array[r]) {
                r = mid;
            }
        }
        return -1;
    }

    public static int getSmallestNumByLoop(int[] rotateArr) {
        if (rotateArr == null || rotateArr.length == 0) {
            return -1;
        }
        // 方法二：循环
//        return findByLoop(rotateArr, 0, rotateArr.length - 1);
        // 移动0个数的特殊情况，返回l
        int l = 0;
        int r = rotateArr.length - 1;
        int mid = l;
        // 一般来说l值大于等于r值
        while (rotateArr[l] >= rotateArr[r]) {
            // 停在r指针处
            if (r - l <= 1) {
                mid = r;
                break;
            }
            mid = l + ((r - l) >> 1);
            // 如果一开始中间和两边的数相等，只能采用遍历的方式找最小值
            if (rotateArr[mid] == rotateArr[l] && rotateArr[mid] == rotateArr[r]) {
                return findByTraverse(rotateArr, l, r);
            }
            // 一般情况
            if (rotateArr[mid] > rotateArr[l]) {
                l = mid + 1;
            } else if (rotateArr[mid] < rotateArr[r]) {
                r = mid - 1;
            }
        }
        return rotateArr[mid];
    }

    private static int findByTraverse(int[] rotateArr, int l, int r) {
        int minIndex = l;
        for (int i = l + 1; i <= r; i++) {
            if (rotateArr[i] < rotateArr[minIndex]) {
                minIndex = i;
            }
        }
        return rotateArr[minIndex];
    }

    private static int stoFindByLoop(int[] rotateArr, int l, int r) {
        // 移动0个数的特殊情况，返回l
        int mid = l;
        // 一般来说l值大于等于r值
        while (rotateArr[l] >= rotateArr[r]) {
            // 停在r指针处
            if (r - l <= 1) {
                mid = r;
                break;
            }
            mid = l + ((r - l) >> 1);
            // 如果一开始中间和两边的数相等，只能采用遍历的方式找最小值
            if (rotateArr[mid] == rotateArr[l] && rotateArr[mid] == rotateArr[r]) {
                return findByTraverse(rotateArr, l, r);
            }
            // 一般情况
            if (rotateArr[mid] >= rotateArr[l]) {
                l = mid;
            } else if (rotateArr[mid] <= rotateArr[r]) {
                r = mid;
            }
        }
        return rotateArr[mid];
    }

    /**
     * 通过NK
     * @param nums
     * @return
     */
    public static int cycMinNumberInRotateArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[l] == nums[m] && nums[m] == nums[h]) {
                return minNumber(nums, l, h);
            } else if (nums[m] <= nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }

    private static int minNumber(int[] nums, int l, int h) {
        for (int i = l; i < h; i++) {
            if (nums[i] > nums[i + 1])
                return nums[i + 1];
        }
        return nums[l];
    }
}
