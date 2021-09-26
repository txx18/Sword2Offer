package dp.max;

/**
 * @author ShaneTang
 * @create 2021-02-21 17:33
 */
public class MaxSubArraySum {

    public static void main(String[] args) {
        MaxSubArraySum obj = new MaxSubArraySum();
        int res = obj.solutionGreedy(new int[]{1, -2, 3, 10, -4, 7, 2, -5});
        System.out.println("res = " + res);
    }

    public int dpTable(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int solutionGreedy(int[] nums) {
        return new greedy.MaxSubArraySum().solutionGreedy(nums);
    }

    public int solutionDpOpt(int[] nums) {
        return new greedy.MaxSubArraySum().solutionDpOpt(nums);
    }
}
