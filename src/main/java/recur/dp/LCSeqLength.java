package recur.dp;

/**
 * @author ShaneTang
 * @create 2021-01-25 11:17
 */
public class LCSeqLength {

    public static void main(String[] args) {
        LCSeqLength obj = new LCSeqLength();
        String str1 = "1A2C3D4B56";
        String str2 = "B1D23CA45B6A";
        int res = obj.solutionDpTable1(str1, str1.length(), str2, str2.length());
        System.out.println("res = " + res);

    }

    public int solutionDpTable1(String A, int n, String B, int m) {
        // write code here
        // recur.dp[i][j] A长度为i（从1开始数第i个） B长度为j时 LCS的长度
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

//    /**
//     * 通过LC
//     * @param text1
//     * @param text2
//     * @return
//     */
//    public int dpTable1(String text1, String text2) {
//        int n = text1.length();
//        int m = text2.length();
//        // write code here
//        // recur.dp[i][j] A长度为i（从1开始数第i个） B长度为j时 LCS的长度
//        int[][] recur.dp = new int[n + 1][m + 1];
//        // 默认初始为0了，主要是第一行第一列初始化为0，其余后面会更新
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= m; j++) {
//                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
//                    recur.dp[i][j] = 1 + recur.dp[i - 1][j - 1];
//                } else {
//                    recur.dp[i][j] = Math.max(recur.dp[i - 1][j], recur.dp[i][j - 1]);
//                }
//            }
//        }
//        return recur.dp[n][m];
//    }


}