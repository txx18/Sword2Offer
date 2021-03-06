package dp.count;

import java.util.HashMap;
import java.util.Map;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: 2
 * 解释: 4 皇后问题存在如下两个不同的解法。
 * [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 * <p>
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-10 21:10
 */
public class NQueensMethodCount {

    public static void main(String[] args) {
        NQueensMethodCount obj = new NQueensMethodCount();
        int res = obj.Nqueen(8);
        System.out.println("res = " + res);
    }

    int[] track;
    int n;

    public int totalNQueens(int n) {
        if (n < 1) {
            return 0;
        }
        this.n = n;
        this.track = new int[n];
        // 从第0行开始
        return recur(0);
    }


    private int recur(int i) {
        // 如果 i == n 说明找到了一种
        if (i == n) {
            return 1; // 注意
        }
        int res = 0; // 注意
        // 在第i 行，尝试第j列
        for (int j = 0; j < n; j++) {
            boolean isValid = isValid(i, j);
            // isValid受到上一行决策的影响
            if (isValid) { // 分支限界
                // 记录第i行
                track[i] = j;
                // 【关键】继续尝试下一行
                res += recur(i + 1);
            }
        }
        return res; // 注意
    }

    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (col == track[i] || Math.abs(col - track[i]) == Math.abs(row - i)) {
                return false;
            }
        }
        return true;
    }

    int res = 0;

    private void backtrack(int row) {
        // 决策到最后一层，满足决策条件
        if (row == n) {
            res++;
        }
        for (int col = 0; col < n; col++) {
            if (!isValid(row, col)) {
                continue;
            }
            track[row] = col;
            backtrack(row + 1);
//            track[row] = -1; // 这句不需要
        }
    }


    private boolean isValidTrack(int i, int j, int[] track) {
        for (int k = 0; k < i; k++) {
            if (j == track[k] || Math.abs(j - track[k]) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    Map<Integer, Integer> map = new HashMap<>();

    public int Nqueen(int n) {
        if (n < 1) {
            return 0;
        }
        this.n = n;
        track = new int[n];
        // 从第0行（层）开始决策
//        backtrack(0);
        btMap(0);
        return res;
    }

    private void btMap(int row) {
        if (row == n) {
            res++;
        }
        for (int col = 0; col < n; col++) {
            if (!isValidMap(row, col)) {
                continue;
            }
            map.put(row, col);
            btMap(row + 1);
            // map.put(row,)
        }
    }

    private boolean isValidMap(int row, int col) {
        for (int i = 0; i < row; i++) {
            // int qCol = track[i];
            int qCol = map.get(i);
            if (qCol == col || Math.abs(row - i) == Math.abs(qCol - col)) {
                return false;
            }
        }
        return true;
    }


}
