package greedy;

/**
 * 子矩阵的最大和
 *
 * @author ShaneTang
 * @create 2021-03-13 10:50
 */
public class GreatestSumOfSubMatrix {

    public static void main(String[] args) {
        GreatestSumOfSubMatrix obj = new GreatestSumOfSubMatrix();
        int[][] matrix = {{-5, 3, 6, 4}, {-7, 9, -5, 3}, {-10, 1, -200, 4}};
        int res = obj.solution(matrix);
        System.out.println("res = " + res);
    }

    public int solution(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < mat.length; i++) {
            // 一个在更新的子数组
            int[] tmp = new int[mat[0].length];
            for (int j = i; j < mat.length; j++) { // j从i开始
                int cur = 0;
                // 对当前子数组
                for (int k = 0; k < tmp.length; k++) {
                    tmp[k] += mat[j][k];
                    cur += tmp[k];
                    res = Math.max(res, cur);
                    if (cur < 0) {
                        cur = 0;
                    }
                }
            }
        }
        return res;
    }
}
