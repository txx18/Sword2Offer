package recurforcetry.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
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

    //    char[][] board;
//    List<char[][]> resBoardList = new LinkedList<>();
    List<int[]> myRes;
    int[] myTrack;

    List<List<String>> res = new LinkedList<>();
    List<String> resTrack = new LinkedList<>();
    int n;
    StringBuilder boardRowSb = new StringBuilder();

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return new LinkedList<>();
        }
        this.n = n;
        myTrack = new int[n];
        myRes = new LinkedList<>();
//        bt(0);
//        convertToShaBi();
        for (int i = 0; i < n; i++) {
            boardRowSb.append(".");
        }
//        btCharArray(0);
//        btStringBuilder(0);
        btStringBuilderTrack(resTrack, 0);
        return res;
    }

    private void btStringBuilderTrack(List<String> resTrack, int row) {
        if (row == n) {
            res.add(new LinkedList<>(resTrack));
        }
        for (int col = 0; col < n; col++) {
            if (!isValidStringBuilder(row, col)) {
                continue;
            }
            StringBuilder sb = new StringBuilder(boardRowSb);
            sb.setCharAt(col, 'Q');
            resTrack.add(sb.toString());
            btStringBuilderTrack(resTrack, row + 1);
            resTrack.remove(resTrack.size() - 1);
        }
    }

    private void btStringBuilder(int row) {
        if (row == n) {
            res.add(new LinkedList<>(resTrack));
        }
        for (int col = 0; col < n; col++) {
            if (!isValidStringBuilder(row, col)) {
                continue;
            }
            StringBuilder sb = new StringBuilder(boardRowSb);
            sb.setCharAt(col, 'Q');
            resTrack.add(sb.toString());
            btStringBuilder(row + 1);
            resTrack.remove(resTrack.size() - 1);
        }
    }

    private void btCharArray(int row) {
        if (row == n) {
            res.add(new LinkedList<>(resTrack));
        }
        for (int col = 0; col < n; col++) {
            if (!isValidStringBuilder(row, col)) {
                continue;
            }
            char[] chars = boardRowSb.toString().toCharArray();
            chars[col] = 'Q';
            resTrack.add(new String(chars));
            btStringBuilder(row + 1);
            resTrack.remove(resTrack.size() - 1);
        }
    }

    private boolean isValidStringBuilder(int row, int col) {
        for (int i = 0; i < row; i++) {
            int queenCol = resTrack.get(i).indexOf('Q');
            if (col == queenCol || Math.abs(col - queenCol) == Math.abs(row - i)) {
                return false;
            }
        }
        return true;
    }

    private void convertToShaBi() {
        for (int i = 0; i < myRes.size(); i++) {
            resTrack = new LinkedList<>();
            for (int row = 0; row < n; row++) {
                StringBuilder s = new StringBuilder();
                for (int col = 0; col < n; col++) {
                    if (myRes.get(i)[row] != col) {
                        s.append(".");
                    } else {
                        s.append("Q");
                    }
                }
                resTrack.add(s.toString());
            }
            res.add(resTrack);
        }
    }

    private void bt(int row) {
        if (row == n) {
            myRes.add(Arrays.copyOf(myTrack, myTrack.length));
        }
        for (int col = 0; col < n; col++) {
            if (!myIsValid(row, col)) {
                continue;
            }
            myTrack[row] = col;
            bt(row + 1);
            myTrack[row] = -1;
        }
    }

    private boolean myIsValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            int queenCol = myTrack[i];
            if (col == queenCol || Math.abs(col - queenCol) == Math.abs(row - i)) {
                return false;
            }
        }
        return true;
    }


    /**
     * 第i行的皇后放在第j列
     * 下标为i的值为j
     */
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<String>> solveNQueens1(int n) {
        if (n < 1) {
            return new LinkedList<>();
        }
        this.n = n;
        this.track = new LinkedList<>();
        recur(0);
        return res;
    }


    private void recur(int i) {
        // base case
        if (i == n) {
            saveOneRes(track);
            return;
        }
        // 当前在第i行，尝试第j列
        for (int j = 0; j < n; j++) {
            // 如果在第i行找到合法位置
            boolean isValid = isValid(i, j);
            if (isValid) {
                // 把第i行的queen放到第j列
                track.add(j);
                // 继续尝试下一行
                recur(i + 1);
                // 撤销选择
                track.removeLast();
            }

        }
    }

    private void saveOneRes(LinkedList<Integer> track) {
        this.resTrack = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == track.get(i)) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            this.resTrack.add(sb.toString());
        }
        res.add(this.resTrack);
    }

    private boolean isValid(int i, int j) {
        // 检查跟之前i行添加的Q有没有冲突
        for (int k = 0; k < i; k++) {
            // 1* 同列
            // 2* 同斜线（纵距离 == 横距离）
            Integer queenIdx = track.get(k);
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
