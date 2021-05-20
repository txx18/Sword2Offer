package dp.max;

import java.util.Arrays;

/**
 * @author ShaneTang
 * @create 2021-01-25 10:31
 */
public class LISeqLength {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 3, 4, 2, 3};
        int[] arr1 = new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] arr2 = new int[0];
        LISeqLength obj = new LISeqLength();
//        int[] res = obj.LIS(arr1);
//        System.out.println("res = " + Arrays.toString(res));

        int res = obj.solutionDpTable1(arr1);
        System.out.println("res = " + res);
    }

    /**
     * dp[i]表示下标i-1及其之前的最长上升子序列，
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n]; // [0, n-1]
        Arrays.fill(dp, 1); // 初始化为 1
        int res = 0;
        for (int i = 1; i < n; i++) { // i: [1, n-1]
            for (int j = 0; j < i; j++) { // j: [0, i-1]
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            res = Math.max(res, dp[i]); // 取长的子序列
        }
        return res;
    }

    /**
     * 通过LC
     *
     * @param nums
     * @return
     */
    public int solutionDpTable1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                if (nums[j - 1] < nums[i - 1]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public int findLongestBS(int[] A, int n) {
        // 存储牌
        int[] top = new int[A.length];
        int pileCount = 0;
        for (int poker : A) {
            int left = 0;
            int right = pileCount;
            // 左边界二分查找
            while (left < right) {
                int mid = left + ((right - left) >> 1);
                if (poker <= top[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left == pileCount) {
                pileCount++;
            }
            top[left] = poker;
        }
        return pileCount;
    }
}
