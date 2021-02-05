package binarysearch;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-06 16:39
 */
public class MissingNumberE5302 {

    public static void main(String[] args) {
        int[] arr1 = {0, 1, 3, 4, 5};
        int[] arr2 = {1, 2, 3, 4, 5};
        int[] arr3 = {0, 1, 2, 3, 4};
        int[] arr4 = {};
        int[] arr5 = {0};
        int[] arr6 = {0, 1};
//        System.out.println(arr4 == null);
        int res = missingNumber(arr6);
        System.out.println("res = " + res);
    }

    public static int missingNumber(int[] nums) {
//        return solutionBSLoopME(nums);
        return solutionTraverse(nums);
    }

    /**
     *
     * 转化为：找第1个下标不等于值的那个数
     *
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 50.9 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param arr
     * @return
     */
    public static int solutionBSLoopME(int[] arr) {
        if (arr == null) {
            return -1;
        }
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            // 把值和下标比较
            // 如果在那个缺的数字之后，值肯定大于下标
            if (arr[mid] > mid) {
                // 边界条件：如果压缩到0或者它前一个数字是正常的，则返回它
                if (mid == 0 || arr[mid - 1] == mid - 1) {
                    return mid;
                }
                // 否则压缩右边
                r = mid - 1;
            }
            // 如果值等于下标
            else if (arr[mid] == mid) {
                // 边界条件：如果压缩到右端 或者 它后一个数字开始不正常，返回它后面一个数字
                if (mid == arr.length - 1 || arr[mid + 1] != mid + 1) {
                    return mid + 1;
                }
                l = mid + 1;
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
     * 42.9 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param arr
     * @return
     */
    public static int solutionTraverse(int[] arr) {
        int i = 0;
        for (; i < arr.length; i++) {
            if (arr[i] != i) {
                return arr[i] - 1;
            }
        }
        // 缺的是最后一个数字
        return i;
    }
}
