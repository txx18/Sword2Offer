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
     *
     * @param text1
     * @param text2
     * @return
     */
    public int dpTable(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        // 定义dp[i][j] 原字符串下标为[0,i-1]和[0,j-1]的结果
        // 相当于在下标二维数组中前插0行和0列，表示 ""
        int[][] dp = new int[n + 1][m + 1];
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