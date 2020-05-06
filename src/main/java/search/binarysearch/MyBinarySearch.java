package search.binarysearch;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 *
 * 示例 1:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 9
 * 输出: 4
 * 解释: 9 出现在 nums 中并且下标为 4
 * 示例 2:
 *
 * 输入: nums = [-1,0,3,5,9,12], target = 2
 * 输出: -1
 * 解释: 2 不存在 nums 中因此返回 -1
 *  
 *
 * 提示：
 *
 * 你可以假设 nums 中的所有元素是不重复的。
 * n 将在 [1, 10000]之间。
 * nums 的每个元素都将在 [-9999, 9999]之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyBinarySearch {

    public static void main(String[] args) {
        int[] arr = {3, 5, 11, 17, 21, 23, 28, 30, 32, 50, 64, 78, 81, 95, 101};
        int[] arr2 = {-1,0,3,5,9,12};
        MyBinarySearch obj = new MyBinarySearch();
        int res = obj.search(arr2, 6);
        System.out.println("res = " + res);

    }

    public int search(int[] nums, int target) {
        return solutionME(nums, target);
//        return solutionMELessEqual(nums, target);
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 42.4 MB
     * , 在所有 Java 提交中击败了
     * 5.01%
     * 的用户
     * @param sortedArr
     * @param target
     * @return
     */
    private int solutionMELessEqual(int[] sortedArr, int target) {
        if (sortedArr == null || sortedArr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        while (L <= R) {
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == target) {
                return mid;
            }
            else if (sortedArr[mid] > target) {
                R = mid - 1;
            }
            else {
                L = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 42.3 MB
     * , 在所有 Java 提交中击败了
     * 5.01%
     * 的用户
     * @param sortedArr
     * @param num
     * @return
     */
    public static int solutionME(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        while (L < R) {
            mid = L + ((R - L) >> 1);
            if (sortedArr[mid] == num) {
                return mid;
            }
            else if (sortedArr[mid] > num) {
                R = mid - 1;
            }
            else {
                L = mid + 1;
            }
        }
        if (sortedArr[L] == num){
        	return L;
		}
        return -1;
    }

    private static int getArbitraryIdxByLoop(int[] sortedArr, int k) {
        // 关键：l <= r
        int mid = -1;
        for (int l = 0, r = sortedArr.length - 1; l <= r; ) {
            mid = l + ((r - l) >> 1);
            if (k < sortedArr[mid]) {
                r = mid - 1;
            } else if (k > sortedArr[mid]) {
                l = mid + 1;
            } else {
                return mid;
            }

        }
        return -1;
    }

    public static int getFirstIdxByLoop(int[] sortedArr, int k) {
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


    private int solutionRecur(int[] sortedArr, int tar) {
        if (sortedArr == null || sortedArr.length == 0) {
            return Integer.MIN_VALUE;
        }
        // 方法二：递归
        return recur(sortedArr, 0, sortedArr.length - 1, tar);
    }


    private int recur(int[] sortedArr, int l, int r, int num) {
        if (l >= r) {
            return -1;
        }
        int mid = l + ((r - l) >> 1);
        if (sortedArr[mid] == num) {
            r = mid;
        } else if (num < sortedArr[mid]) {
            return recur(sortedArr, l, mid - 1, num);
        } else if (num > sortedArr[mid]) {
            return recur(sortedArr, mid + 1, r, num);
        }
        if (num == sortedArr[r]){
            return r;
        }
        return -1;
    }

    private static int solutionCYC(int[] nums, int K) {
        int l = 0, h = nums.length;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= K) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    private static int solutionJDK(int[] a, int fromIndex, int toIndex,
                                   int key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }
}
