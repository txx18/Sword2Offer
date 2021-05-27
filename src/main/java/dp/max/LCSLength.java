package dp.max;

/**
 * @author ShaneTang
 * @create 2021-01-25 11:17
 */
public class LCSLength {

    public static void main(String[] args) {
        LCSLength obj = new LCSLength();
        String str1 = "1A2C3D4B56";
        String str2 = "B1D23CA45B6A";
        int res = obj.dpTable(str1, str2);
        System.out.println("res = " + res);

    }

    /**
     * 通过LC
     * <p>
     * 前插0行和0列，dp[i][j] A下标为[1, i] B下标为[1, j]时 LCS的长度
     *
     * @param text1
     * @param text2
     * @return
     */
    public int dpTable(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        // 为了在下标二维数组中前插0行和0列，表示 ""
        int[][] dp = new int[n + 1][m + 1];
        // 默认初始为0了，主要是第一行第一列初始化为0，其余后面会更新
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }

}