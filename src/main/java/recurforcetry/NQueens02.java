package recurforcetry;

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
public class NQueens02 {

    public static void main(String[] args) {
        NQueens02 obj = new NQueens02();
        int res = obj.totalNQueens(4);
        System.out.println("res = " + res);
    }

    public int totalNQueens(int n) {
        return solution(n);
    }

    /**
     * [i] == j  第i行的皇后放在第j列
     */
    int[] queenCol = null;

    private int solution(int n) {
        if (n < 1) {
            return 0;
        }
        queenCol = new int[n];
        // 从第0行开始
        return recur(0, n);
    }


    private int recur(int i, int n) {
        // 如果 i == n 说明找到了一种
        if (i == n) {
            return 1;
        }
        // 【关键】不成功要清0
        int res = 0;
        // 在第i 行
        for (int j = 0; j < n; j++) {
            boolean isValid = isValid(i, j);
            if (isValid) {
                queenCol[i] = j;
                res += recur(i + 1, n);
            }
        }
        return res;
    }

    private boolean isValid(int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == queenCol[k] || Math.abs(j - queenCol[k]) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }
}
