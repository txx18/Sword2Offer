package recurforce;

import java.util.ArrayList;
import java.util.List;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * <p>
 * <p>
 * 上图为 8 皇后问题的一种解法。
 * <p>
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * <p>
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例:
 * <p>
 * 输入: 4
 * 输出: [
 * [".Q..",  // 解法 1
 * "...Q",
 * "Q...",
 * "..Q."],
 * <p>
 * ["..Q.",  // 解法 2
 * "Q...",
 * "...Q",
 * ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-09 17:53
 */
public class NQueens01 {

    public static void main(String[] args) {
        NQueens01 obj = new NQueens01();

        List<List<String>> res = obj.solveNQueens(4);
        for (List<String> oneRes : res) {
            for (String row : oneRes) {
                System.out.println(row);
            }
            System.out.println("-----------------------------------");
        }
    }

    public List<List<String>> solveNQueens(int n) {
        return solution(n);
    }

    /**
     * 放全体结果
     */
    List<List<String>> res = new ArrayList<>();

    List<String> oneRes = new ArrayList<>();

    private List<List<String>> solution(int n) {
        if (n < 1) {
            return null;
        }
//        int[] record = new int[n];
        recur(0, n);
        return this.res;
    }


    private List<String> recur(int i, int n) {
        // base case
        if (i == n) {
            return oneRes;
        }
        oneRes = new ArrayList<>();
        // 当前在第i行，尝试第j列
        for (int j = 0; j < n; j++) {
            // 如果在第i行找到合法位置
            boolean isValid = isValid(i, j, oneRes);
            if (isValid) {
                // 添加这一行到oneRes
                addRow(j, n, oneRes);
//                record[i] = j;
                // 继续尝试下一行
                this.res.add(recur(i + 1, n));
            }
        }
        return oneRes;
    }

    private void addRow(int j, int n, List<String> oneRes) {
        char[] chars = new char[n];
        for (int k = 0; k < n; k++) {
            if (k == j) {
                chars[k] = 'Q';
            } else {
                chars[k] = '.';
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < n; k++) {
            sb.append(chars[k]);
        }
        oneRes.add(sb.toString());
    }

    private boolean isValid(int i, int j, List<String> oneRes) {
        // 检查跟之前i行添加的Q有没有冲突
        for (int k = 0; k < oneRes.size(); k++) {
            // 1* 同列
            // 2* 同斜线（纵距离 == 横距离）
            String row = oneRes.get(k);
            if (j == row.indexOf("Q") ||
                    Math.abs(j - row.indexOf("Q")) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(int i, int j, int[] record) {
        for (int k = 0; k < i; k++) { // 之前的某个k行的皇后
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }
}
