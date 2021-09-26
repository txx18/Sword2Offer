package array;

/**
 * @author ShaneTang
 * @create 2021-02-12 21:45
 */
public class FindIn2dArray {

    /**
     * 通过LC
     * @param target
     * @param matrix
     * @return
     */
    public static boolean findNumberIn2DArray(int target, int[][] matrix) {
        // 初始为左下角的数，target比它大肯定往右找，target比他小肯定往上找
        int row = matrix.length - 1;
        int col = 0;
        for (int i = row, j = col; i >= 0 && j < matrix[0].length; ) { // i >= , j <
            if (target > matrix[i][j]) {
                j++;
            } else if (target < matrix[i][j]) {
                i--;
            } else {
                return true;
            }
        }
        return false;
    }
}
