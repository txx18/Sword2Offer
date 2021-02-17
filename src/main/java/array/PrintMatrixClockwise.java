package array;

import java.util.ArrayList;

/**
 * @author ShaneTang
 * @create 2021-02-14 12:05
 */
public class PrintMatrixClockwise {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int r1 = 0;
        int r2 = matrix.length - 1;
        int c1 = 0;
        int c2 = matrix[0].length - 1;
        // 所有的控制语句都用变量 r1 r2 c1 c2
        while (r1 <= r2 && c1 <= c2) {
            for (int j = c1; j <= c2; j++) {
                res.add(matrix[r1][j]);
            }
            for (int i = r1 + 1; i <= r2; i++) {
                res.add(matrix[i][c2]);
            }
            if (r1 != r2) {
                for (int j = c2 - 1; j >= c1; j--) {
                    res.add(matrix[r2][j]);
                }
            }
            if (c1 != c2) {
                for (int i = r2 - 1; i > r1; i--) {
                    res.add(matrix[i][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return res;
    }
}
