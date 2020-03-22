package recurforcetry.backtrack;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-10 21:10
 */
public class NQueensCount {

    public static void main(String[] args) {
        NQueensCount obj = new NQueensCount();
        int res = obj.totalNQueens(8);
        System.out.println("res = " + res);
    }


    /**
     * [i] == j  第i行的皇后放在第j列
     */
    int[] track = null;
    /**
     * n皇后问题：棋盘有n行n列
     */
    int n;

    /**
     * 执行用时 :
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 60.26%
     * 的用户
     * 内存消耗 :
     * 36.8 MB
     * , 在所有 Java 提交中击败了
     * 5.10%
     * 的用户
     * @param n
     * @return
     */
    public int totalNQueens(int n) {
        if (n < 1) {
            return 0;
        }
        this.n = n;
        this.track = new int[n];
        // 从第0行开始
        return recur(0);
    }


    /**
     *
     * @param i 来到第i行
     * @return
     */
    private int recur(int i) {
        // 如果 i == n 说明找到了一种
        if (i == n) {
            return 1;
        }
        // 【关键】不成功要清0
        int res = 0;
        // 在第i 行，尝试第j列
        for (int j = 0; j < n; j++) {
            boolean isValid = isValid(i, j);
            // isValid受到上一行决策的影响
            if (isValid) {
                // 记录第i行
                track[i] = j;
                // 【关键】继续尝试下一行
                res += recur(i + 1);
            }
        }
        return res;
    }

    /**
     * 检查[0..i]行是否合法
     * @param i 来到第i行
     * @param j 来到第j列
     * @return
     */
    private boolean isValid(int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == track[k] || Math.abs(j - track[k]) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }
}
