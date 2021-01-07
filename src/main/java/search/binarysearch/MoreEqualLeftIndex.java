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
        int[] arr = {1, 1, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5};
        int[] arr2 = {1, 3, 5, 6};
        MoreEqualLeftIndex obj = new MoreEqualLeftIndex();

        int index = obj.upper_bound_BS2(arr2.length, 0, arr2);
        System.out.println("index = " + index);
    }

    // todo 鬼题目从1开始数
    int upper_bound_BS2(int n, int v, int[] a) {
        int left = 0;
        int right = n; // 定义target在左闭右开的区间里，[left, right)  target
        int middle = -1;
        while (left < right) { // 因为left == right的时候，在[left, right)是无效的空间
            middle = left + ((right - left) >> 1);
            if (a[middle] > v) {
                right = middle; // target 在左间，在[left, middle)中
            } else if (a[middle] < v) {
                left = middle + 1; // target 在右区间，在 [middle+1, right)中
            } else { // nums[middle] == target
                return middle; // 数组中找到目标值的情况，直接返回下标
            }
        }
        // 分别处理如下四种情况
        // 目标值在数组所有元素之前 [0,0)
        // 目标值等于数组中某一个元素 return middle
        // 目标值插入数组中的位置 [left, right) ，return right 即可
        // 目标值在数组所有元素之后的情况 [left, right)，return right 即可
        return middle + 1;
    }

    int upper_bound_BS1(int n, int v, int[] a) {
        int left = 0;
        int right = n - 1; // 定义target在左闭右闭的区间里，[left, right]
        while (left <= right) { // 当left==right，区间[left, right]依然有效
            int middle = left + ((right - left) / 2);// 防止溢出 等同于(left + right)/2
            if (a[middle] > v) {
                right = middle - 1; // target 在左区间，所以[left, middle - 1]
            } else if (a[middle] < v) {
                left = middle + 1; // target 在右区间，所以[middle + 1, right]
            } else { // nums[middle] == target
                return middle;
            }
        }
        // 分别处理如下四种情况
        // 目标值在数组所有元素之前  [0, -1]
        // 目标值等于数组中某一个元素  return middle;
        // 目标值插入数组中的位置 [left, right]，return  right + 1
        // 目标值在数组所有元素之后的情况 [left, right]， return right + 1
        return right + 1;
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
    // 在arr上，找满足>=value的最左位置 todo
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
