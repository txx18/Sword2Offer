package search.binarysearch;

/**
 * 在arr上，找满足>=value的最左位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoreEqualLeftIndex {

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5};
        int[] arr2 = {1, 3, 5, 6};
        MoreEqualLeftIndex obj = new MoreEqualLeftIndex();

        int index = obj.left_bound(arr, 2);
        System.out.println("index = " + index);
    }

    public int upper_bound_(int n, int v, int[] a) {
        if (a.length == 0) {
            return -1;
        }
        int left = 0;
        int right = a.length; // 注意
        while (left < right) { // 注意
            int mid = left + ((right - left) >> 1);
            if (a[mid] == v) {
                right = mid;
            } else if (a[mid] < v) {
                left = mid + 1;
            } else if (v < a[mid]) {
                right = mid; // 注意
            }
        }
        return left + 1;
    }

    int left_bound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length; // 注意
        while (left < right) { // 注意
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid; // 注意
            }
        }
        // 如果需求是顺序插入位置
        return left;
        // 如果需求是不存在时返回-1
/*        // target 比所有数都大
        if (left == nums.length) {
            return -1;
        }
        // 类似之前算法的处理方式
        return nums[left] == target ? left : -1;*/
    }


    int upper_bound_fool(int n, int v, int[] a) {
        for (int i = 0; i < a.length; i++) {
            // 分别处理如下三种情况
            // 目标值在数组所有元素之前
            // 目标值等于数组中某一个元素
            // 目标值插入数组中的位置
            if (a[i] >= v) { // 一旦发现大于或者等于target的num[i]，那么i就是我们要的结果
                return i + 1;
            }
        }
        // 目标值在数组所有元素之后的情况
        return a.length + 1; // 如果target是最大的，或者 nums为空，则返回nums的长度
    }

    public int searchInsert(int[] nums, int target) {
        return solutionZS(nums, target);
//		return solutionME(nums, target);
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 38.9 MB
     * , 在所有 Java 提交中击败了
     * 36.78%
     * 的用户
     *
     * @param a
     * @param v
     * @return
     */
    // 在arr上，找满足>=value的最左位置
    public static int solutionZS(int[] a, int v) {
        int pl = 0;
        int pr = a.length - 1;
        // 给左神加了一点，防御插入最大值
        if (v > a[pr]) {
            return a.length;
        }
        int index = -1; // 记录最左的对号
        while (pl <= pr) {
            int mid = pl + ((pr - pl) >> 1);
            if (a[mid] >= v) {
                index = mid;
                pr = mid - 1;
            } else {
                pl = mid + 1;
            }
        }
        return index;
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 39 MB
     * , 在所有 Java 提交中击败了
     * 33.76%
     * 的用户
     *
     * @param a
     * @param v
     * @return
     */
    public int solutionME(int[] a, int v) {
        int left = 0, right = a.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (a[mid] == v) {
                return mid;
            } else if (a[mid] < v) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


}