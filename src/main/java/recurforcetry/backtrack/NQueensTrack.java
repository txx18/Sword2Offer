package recurforcetry.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
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
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-09 17:53
 */
public class NQueensTrack {

    public static void main(String[] args) {
        NQueensTrack obj = new NQueensTrack();

        List<List<String>> res = obj.solveNQueens(8);
        for (List<String> oneRes : res) {
            for (String row : oneRes) {
                System.out.println(row);
            }
            System.out.println("-----------------------------------");
        }
    }

    /**
     * 放全体结果
     */
    List<List<String>> res = new ArrayList<>();
    List<String> oneRes = new ArrayList<>();
    /**
     * 第i行的皇后放在第j列
     * 下标为i的值为j
     */
//    HashMap<Integer, Integer> track;
    LinkedList<Integer> trackLinkedList;
    int n;

    /**
     * 执行用时 :
     * 7 ms
     * , 在所有 Java 提交中击败了
     * 33.57%
     * 的用户
     * 内存消耗 :
     * 41.2 MB
     * , 在所有 Java 提交中击败了
     * 8.67%
     * 的用户
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return null;
        }
        this.n = n;
//        this.track = new HashMap<>(n);
        this.trackLinkedList = new LinkedList<>();
        recur(0);
        return res;
    }


    private void recur(int i) {
        // base case
        if (i == n) {
            saveOneRes(trackLinkedList);
            return;
        }
        // 当前在第i行，尝试第j列
        for (int j = 0; j < n; j++) {
            // 如果在第i行找到合法位置
            boolean isValid = isValid(i, j);
            if (isValid) {
                // 把第i行的queen放到第j列
                trackLinkedList.add(j);
                // 继续尝试下一行
                recur(i + 1);
                // 撤销选择
                trackLinkedList.removeLast();
            }

        }
    }

    private void saveOneRes(LinkedList<Integer> track) {
        oneRes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == track.get(i)) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            oneRes.add(sb.toString());
        }
        res.add(oneRes);
    }

    private boolean isValid(int i, int j) {
        // 检查跟之前i行添加的Q有没有冲突
        for (int k = 0; k < i; k++) {
            // 1* 同列
            // 2* 同斜线（纵距离 == 横距离）
            Integer queenIdx = trackLinkedList.get(k);
            if (j == queenIdx || Math.abs(j - queenIdx) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

/*
    private void recur(int i) {
        // base case
        if (i == n) {
//            saveOneRes(track);
            saveOneRes(trackLinkedList);
            return;
        }
        // 当前在第i行，尝试第j列
        for (int j = 0; j < n; j++) {
            // 如果在第i行找到合法位置
            boolean isValid = isValid(i, j);
            if (isValid) {
                // 把第i行的queen放到第j列
//                track.put(i, j);
                trackLinkedList.add(j);
                // 继续尝试下一行
                recur(i + 1);
                // 撤销选择
//                track.remove(i);
                trackLinkedList.removeLast();
            }

        }
    }*/

/*    private void saveOneRes(HashMap<Integer, Integer> track) {
        oneRes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == track.get(i)) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            oneRes.add(sb.toString());
        }
        res.add(oneRes);
    }*/


/*    private void addRow(int j) {
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
    }*/

/*    private boolean isValid(int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == track[k] || Math.abs(j - track[k]) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }*/



/*    private boolean isValid(int i, int j) {
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
    }*/


}
