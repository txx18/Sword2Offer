package dp.count;

/**
 * @author ShaneTang
 * @create 2021-04-13 11:39
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (S > sum) {
            return 0;
        }
        if ((S + sum) % 2 == 1) {
            return 0;
        }
        int limit = (S + sum) / 2;
        int[] dp = new int[limit + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = limit; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[limit];
    }
}
