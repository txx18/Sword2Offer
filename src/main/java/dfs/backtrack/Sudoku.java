package dfs.backtrack;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @author ShaneTang
 * @create 2021-01-12 23:03
 */
public class Sudoku {

    char[][] boardChar;
    static int[][] board;
    static int colLength = 9;
    static int rowLength = 9;

    public static void main(String[] args) {
        Sudoku obj = new Sudoku();
        input2dArray(rowLength, colLength);
        bt(0, 0);
        print2dArray(board, " ");
    }

    private static boolean bt(int row, int col) {
        if (col == colLength) {
            return bt(row + 1, 0);
        }
        if (row == rowLength) {
            return true;
        }
        for (int i = row; i < rowLength; i++) {
            for (int j = col; j < colLength; j++) {
                if (board[i][j] != 0) {
                    return bt(i, j + 1);
                }
                for (int k = 1; k <= 9; k++) {
                    if (!isValid(i, j, k)) {
                        continue;
                    }
                    board[i][j] = k;
                    boolean trueRes = bt(i, j + 1);
                    if (trueRes) {
                        return true;
                    }
                    board[i][j] = 0;
                }
                return false;
            }
        }
        return false;
    }

    private static boolean isValid(int row, int col, int k) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == k) {
                return false;
            }
            if (board[i][col] == k) {
                return false;
            }
            if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == k) {
                return false;
            }
        }
        return true;
    }

    public static void print2dArray(int[][] arr, String SEP) {
        for (int i = 0; i < arr.length; i++) {
            StringJoiner sj = new StringJoiner(SEP);
            for (int j = 0; j < arr[0].length; j++) {
                sj.add(arr[i][j] + "");
            }
            System.out.println(sj);
        }
    }

    public static int[][] input2dArray(int rowLength, int colLength) {
        Scanner sc = new Scanner(System.in);
        board = new int[rowLength][colLength];
        for (int i = 0; i < rowLength; i++) {
            String[] splits = sc.nextLine().split(" ");
            for (int j = 0; j < colLength; j++) {
                board[i][j] = Integer.parseInt(splits[j]);
            }
        }
        return board;
    }

    void solveSudoku(char[][] board) {
        this.boardChar = board;
        this.colLength = board[0].length;
        this.rowLength = board.length;
        btChar(0, 0);
    }

    boolean btChar(int r, int c) {
        if (c == colLength) {
            // 穷举到最后一列的话就换到下一行重新开始。
            return btChar(r + 1, 0);
        }
        if (r == rowLength) {
            // 找到一个可行解，触发 base case
            return true;
        }
        // 就是对每个位置进行穷举
        for (int i = r; i < rowLength; i++) {
            for (int j = c; j < colLength; j++) {
                if (boardChar[i][j] != '.') {
                    // 如果有预设数字，不用我们穷举
                    return btChar(i, j + 1);
                }
                for (char ch = '1'; ch <= '9'; ch++) {
                    // 如果遇到不合法的数字，就跳过
                    if (!isValid(i, j, ch)) {
                        continue;
                    }
                    boardChar[i][j] = ch;
                    // 如果找到一个可行解，立即结束
                    boolean trueRes = btChar(i, j + 1);
                    if (trueRes) {
                        return true;
                    }
                    boardChar[i][j] = '.';
                }
                // 穷举完 1~9，依然没有找到可行解，此路不通
                return false;
            }
        }
        return false;
    }

    // 判断 board[i][j] 是否可以填入 n
    boolean isValid(int r, int c, char ch) {
        for (int i = 0; i < 9; i++) {
            // 判断行是否存在重复
            if (boardChar[r][i] == ch) return false;
            // 判断列是否存在重复
            if (boardChar[i][c] == ch) return false;
            // 判断 3 x 3 方框是否存在重复
            if (boardChar[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == ch)
                return false;
        }
        return true;
    }
}
