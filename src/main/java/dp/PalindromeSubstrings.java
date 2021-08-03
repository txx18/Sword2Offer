package dp;

/**
 * @author ShaneTang
 * @create 2021-06-03 20:25
 */
public class PalindromeSubstrings {
    /**
     * 通过NK
     */
    static class LPSubStringLength {
        public int getLongestPalindrome(String A, int n) {
            // write code here
            int res = 0;
            // dp[i][j] 定义为 [i,j] 之间的子串 是否 为回文子串
            boolean[][] dp = new boolean[n][n];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i; j < n; j++) { // j = i
                    if (A.charAt(i) == A.charAt(j)) {
                        if (j - i <= 1) {
                            dp[i][j] = true;
                        } else if (dp[i + 1][j - 1]) { // 左下角
                            dp[i][j] = true;
                        }
                        if (dp[i][j]) {
                            res = Math.max(res, j - i + 1);
                        }
                    }
                }
            }
            return res;
        }
    }

    static class CombineCount {
        public int dp(String s) {
            int n = s.length();
            int res = 0;
            // dp[i][j] 定义为 下标i 和 下标j 之间的子串 是否 为回文子串
            boolean[][] dp = new boolean[n][n];
            for (int i = n - 1; i >= 0; i--) {
                for (int j = i; j < n; j++) { // j = i
                    if (s.charAt(i) == s.charAt(j)) {
                        if (j - i <= 1) {
                            res++;
                            dp[i][j] = true;
                        } else if (dp[i + 1][j - 1]) {
                            res++;
                            dp[i][j] = true;
                        }
                    }
                }
            }
            return res;
        }
    }


}
