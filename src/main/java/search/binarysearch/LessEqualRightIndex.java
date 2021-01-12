package search.binarysearch;

public class LessEqualRightIndex {

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5};
        int index = right_bound(arr, 2);
        System.out.println("index = " + index);
    }

    static int right_bound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                left = mid + 1; // 注意
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid;
            }
        }
        // 如果需求是顺序插入位置
//		return left - 1; // 注意
        // 如果需求是不存在时返回-1
        if (left == 0) {
            return -1;
        }
        return nums[left - 1] == target ? (left - 1) : -1;
    }


    // 在arr上，找满足<=value的e最右位置
    public static int nearestIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        int index = Integer.MIN_VALUE;
        while (L < R) {
            int mid = L + ((R - L) >> 1);
            if (value >= arr[mid]) {
                index = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return index;
    }


}