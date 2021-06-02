package dp.max;

/**
 * 判断子序列
 *
 * @author ShaneTang
 * @create 2021-05-28 19:13
 */
public class IsSubsequence {


    /**
     * 1、可以当成判断LCS长度来做
     * 2、由于s长度<=t长度，可以简化为t到s编辑距离问题的删除情况
     *
     * @param s
     * @param t
     * @return
     */
    public boolean dpLCS(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[n][m] == s.length();
    }
}
