package recur.dp;

/**
 * @author ShaneTang
 * @create 2021-03-16 19:01
 */
public class MinCostClimbingStairs {

    public static void main(String[] args) {
        MinCostClimbingStairs obj = new MinCostClimbingStairs();
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int res = obj.solutionDpTable(cost);
        System.out.println("\n res = " + res);
    }

    public int solutionDpTable(int[] cost) {
        int N = cost.length;
        int[] dp = new int[N];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < N; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            System.out.print(dp[i] + ", ");
        }
        return Math.min(dp[N - 1], dp[N - 2]);
    }

    public int solutionDpOpt(int[] cost) {
        int N = cost.length;
        int dp0 = cost[0];
        int dp1 = cost[1];
        for (int i = 2; i < N; i++) {
            int dpi = Math.min(dp0, dp1) + cost[i];
            dp0 = dp1;
            dp1 = dpi;
        }
        return Math.min(dp0, dp1);
    }
}
