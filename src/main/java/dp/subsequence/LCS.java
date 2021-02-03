package dp.subsequence;

import java.util.Arrays;

/**
 * @author ShaneTang
 * @create 2021-02-03 9:50
 */
public class LCS {

    public static void main(String[] args) {
        LCS obj = new LCS();
//        String res = obj.LCS("1A2C3D4B56", "B1D23CA45B6A");
        String res = obj.LCS("1AB2345CD","12345EF");
        System.out.println("res = " + res);
    }

    public String LCS(String s1, String s2) {
        // todo 奇怪没通过
        int n = s1.length();
        int m = s2.length();
        StringBuilder[][] dp = new StringBuilder[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], new StringBuilder());
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = new StringBuilder(String.valueOf(s1.charAt(i - 1))).append(dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        return dp[n][m].reverse().toString();
    }
}