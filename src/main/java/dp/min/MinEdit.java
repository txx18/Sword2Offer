package dp.min;

/**
 * @author ShaneTang
 * @create 2021-01-30 22:03
 */
public class MinEdit {

    public static void main(String[] args) {
        MinEdit obj = new MinEdit();
//        String word1 = "intention", word2 = "execution";
        String word1 = "abc", word2 = "adc";
//        int res = obj.dpRecur(word1, word2);
//        int res = obj.dpTable1(word1, word2);
        int res = obj.findMinCost(word1, word2, 5, 3, 2);
        System.out.println("res = " + res);
    }

    /**
     * str1变成str2
     *
     * @param str1
     * @param str2
     * @param ic
     * @param dc
     * @param rc
     * @return
     */
    public int findMinCost(String str1, String str2, int ic, int dc, int rc) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        // i = 0, i走完A，从A插入j剩下的到B
        for (int j = 1; j <= m; j++) {
            dp[0][j] = j * ic;
        }
        // j = 0, j走完B，从A删除i剩下的到B
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i * dc;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 相等，skip
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // 增 删 改，右边的状态怎么变成左边（赋值表达式啊）
                else {
                    dp[i][j] = min(dp[i][j - 1] + ic, // 从左到右变是要dc，那么倒推，左边的状态是右边ic之后的
                            dp[i - 1][j] + dc,
                            dp[i - 1][j - 1] + rc);
                }
            }
        }
        return dp[n][m];
    }

    /**
     * LC
     * word1 -> word2最小操作数
     *
     * @param word1
     * @param word2
     * @return
     */
    public int solutionDpTable1(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // dp[i][j]表示word1[0,i-1]与word2[0,j-1]的最短编辑距离
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                // 相等，skip
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // min(增 删 改)
                else {
                    dp[i][j] = min(dp[i][j - 1] + 1,
                            dp[i - 1][j] + 1,
                            dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    String word1;
    String word2;
    char[] word1Chars;
    char[] word2Chars;
    int[][] memoArray;


    public int solutionRecur(String word1, String word2) {
        this.word1 = word1;
        this.word2 = word2;
        return solutionDpRecurForce(word1.length() - 1, word2.length() - 1);
/*        memoArray = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            Arrays.fill(memoArray[i], Integer.MAX_VALUE);
        }
        return solutionDpMemoArray(word1.length() - 1, word2.length() - 1);*/
    }

    private int solutionDpMemoArray(int i, int j) {
        // todo
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if (memoArray[i][j] != Integer.MAX_VALUE) {
            return memoArray[i][j];
        }
        if (word1Chars[i] == word2Chars[j]) {
            memoArray[i][j] = solutionDpMemoArray(i - 1, j - 1);
            return memoArray[i][j];
        } else {
            // 增删
            memoArray[i][j - 1] = solutionDpMemoArray(i, j - 1) + 1;
            memoArray[i - 1][j] = solutionDpMemoArray(i - 1, j) + 1;
            memoArray[i - 1][j - 1] = solutionDpMemoArray(i - 1, j - 1) + 1;
            int min = Math.min(memoArray[i][j - 1], memoArray[i - 1][j]);
            // 改
            return Math.min(min, memoArray[i - 1][j - 1]);
        }
    }

    private int solutionDpRecurForce(int i, int j) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return solutionDpRecurForce(i - 1, j - 1);
        } else {
            return min(solutionDpRecurForce(i, j - 1) + 1, // 插入
                    solutionDpRecurForce(i - 1, j) + 1, // 删除
                    solutionDpRecurForce(i - 1, j - 1) + 1); // 替换
        }
    }


}
