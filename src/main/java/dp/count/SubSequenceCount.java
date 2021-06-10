package dp.count;

/**
 * 有多少个不同的子序列
 * @author ShaneTang
 * @create 2021-05-28 20:38
 */
public class SubSequenceCount {

    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        // dp[i][j]：以i-1为结尾的s子序列中出现以j-1为结尾的t的个数为dp[i][j]。
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j < m; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // 1）用s[i-1]匹配，个数为dp[i-1][j-1]
                    // 2）不用s[i-1]匹配，个数为dp[i-1][j]
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // 不用s[i-1]匹配
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }
}
