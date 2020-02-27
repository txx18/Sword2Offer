package binarysearch;

/**
 * 在arr上，找满足>=value的最左位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * 示例 3:
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * 示例 4:
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoreEqualLeftIndex {

	public static void main(String[] args) {
		int[] arr = {1,1, 2, 2, 3,3,3,3,3 , 4,4,4,4,4, 5,5,5,5,5,5,5,5};
		int[] arr2 = {1,3,5,6};
		int index = solutionZS(arr2, 0);
		System.out.println("index = " + index);
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
	 * @param arr
	 * @param value
	 * @return
	 */
	// 在arr上，找满足>=value的最左位置
	public static int solutionZS(int[] arr, int value) {

		int L = 0;
		int R = arr.length - 1;
		// 给左神加了一点，防御插入最大值
		if (value > arr[R]) {
			return arr.length;
		}
		int index = -1; // 记录最左的对号
		while (L <= R) {
			int mid = L + ((R - L) >> 1);
			if (arr[mid] >= value) {
				index = mid;
				R = mid - 1;
			} else {
				L = mid + 1;
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
	 * @param nums
	 * @param target
	 * @return
	 */
	public int solutionME(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(nums[mid] == target) {
				return mid;
			}
			else if(nums[mid] < target) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
			}
		}
		return left;
	}



}
