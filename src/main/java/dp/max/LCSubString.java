package dp.max;

/**
 * @author ShaneTang
 * @create 2021-06-19 14:31
 */
public class LCSubString {


    /**
     * 通过NK
     *
     * @param str1
     * @param str2
     * @return
     */
    public String LCS(String str1, String str2) {
        // write code here
        int m = str1.length();
        int n = str2.length();
        // dp[i][j] str1和str2 下标i-1 j-1之及其之前的的最长公共子串长度
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        int end = 0;
        for (int i = 0; i < m + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < n + 1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > res) {
                    res = dp[i][j];
                    end = j;
                }
            }
        }
        return res == 0 ? "-1" : str2.substring(end - res, end);
    }
}
