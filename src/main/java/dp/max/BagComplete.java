package dp.max;

/**
 * @author ShaneTang
 * @create 2021-04-13 10:59
 */
public class BagComplete {

    public int dpTable1d(int[] weights, int[] values, int limit) {
        int n = weights.length;
        int[] dp = new int[limit + 1];
        // 既可以外物品内背包，也可以外背包内物品
        for (int i = 0; i < n; i++) {
            for (int j = weights[i]; j <= limit; j++) {
                dp[j] = Math.max(dp[j], values[i] + dp[j - weights[i]]);
            }
        }
        return dp[limit];
    }
}
