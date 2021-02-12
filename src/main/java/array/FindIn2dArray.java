package array;

/**
 * @author ShaneTang
 * @create 2021-02-12 21:45
 */
public class FindIn2dArray {

    public static boolean Find(int target, int[][] array) {
        // 初始为左下角的数，target比它大肯定往右找，target比他小肯定往上找
        int row = array.length - 1;
        int col = 0;
        while (row >= 0 && col < array[0].length) {
            if (target > array[row][col]) {
                col++;
            } else if (target < array[row][col]) {
                row--;
            } else {
                return true;
            }
        }
        return false;
    }
}