package dp.subsequence;

import java.util.Arrays;

/**
 * @author ShaneTang
 * @create 2021-01-25 11:17
 */
public class LCS {

    public static void main(String[] args) {
        LCS obj = new LCS();
        int res = obj.dpTable1("1A2C3D4B56",10,"B1D23CA45B6A",12);
        System.out.println("res = " + res);

    }

    public int dpTable1(String A, int n, String B, int m) {
        // write code here
        // dp[i][j] A长度为i B长度为j时 LCS的长度
        int[][] dp = new int[n + 1][m + 1];
        // 默认初始为0了，主要是第一行第一列初始化为0，其余后面会更新
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}