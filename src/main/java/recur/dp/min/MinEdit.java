package recur.dp.min;

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
        int res = obj.findMinCost(word1, word1.length(), word2, word2.length(), 5, 3, 2);
        System.out.println("res = " + res);
    }

    /**
     * A变成B，i变成j
     *
     * @param A
     * @param n
     * @param B
     * @param m
     * @param c0
     * @param c1
     * @param c2
     * @return
     */
    public int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
        // recur.dp[i][j]表示[0..i]与[0..j]的最短编辑距离
        int[][] dp = new int[n + 1][m + 1];
        // base case，初始化第一行第一列
        // i走完A，从A插入j剩下的到B
        for (int j = 1; j <= m; j++) {
            dp[0][j] = j * c0;
        }
        // j走完B，从A删除i剩下的到B
        for (int i = 1; i <= n; i++) {
            dp[i][0] = i * c1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 相等，skip
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // 增 删 改
                else {
                    dp[i][j] = min(dp[i][j - 1] + c0,
                            dp[i - 1][j] + c1,
                            dp[i - 1][j - 1] + c2);
                }
            }
        }
        return dp[n][m];
    }

    String word1;
    String word2;
    char[] word1Chars;
    char[] word2Chars;
    int[][] memoArray;

    /**
     * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
     * <p>
     * 你可以对一个单词进行如下三种操作：
     * <p>
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     * 示例 2：
     * <p>
     * 输入：word1 = "intention", word2 = "execution"
     * 输出：5
     * 解释：
     * intention -> inention (删除 't')
     * inention -> enention (将 'i' 替换为 'e')
     * enention -> exention (将 'n' 替换为 'x')
     * exention -> exection (将 'n' 替换为 'c')
     * exection -> execution (插入 'u')
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/edit-distance
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param word1
     * @param word2
     * @return
     */
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


    public int solutionDpTable1(String word1, String word2) {
        int m, n;
        m = word1.length();
        n = word2.length();
        // recur.dp[i][j]表示[0..i]与[0..j]的最短编辑距离
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 相等，skip
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // 增 删 改
                else {
                    dp[i][j] = min(dp[i][j - 1] + 1, dp[i - 1][j] + 1, dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp[m][n];
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

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
