package dp.count;

/**
 * @author ShaneTang
 * @create 2021-03-16 19:24
 */
public class RectangleWalkWays {

    public static void main(String[] args) {
        RectangleWalkWays obj = new RectangleWalkWays();
        int res = obj.uniquePaths(3, 7);
        System.out.println("res = " + res);
    }

    public int uniquePaths(int m, int n) {
/*        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][1] = 1;
        }
        for (int j = 1; j <= n; j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];*/
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
