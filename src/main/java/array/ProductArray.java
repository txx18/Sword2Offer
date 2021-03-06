package array;

import java.util.Arrays;

/**
 * @author ShaneTang
 * @create 2021-02-06 16:05
 */
public class ProductArray {

    public static void main(String[] args) {
        ProductArray obj = new ProductArray();
        int[] res = obj.solutionTwiceTraverse(new int[]{1, 2, 3, 4, 5});
        System.out.println("res = " + Arrays.toString(res));
    }

    /**
     * 通过LC
     *
     * @param a
     * @return
     */
    public int[] solutionTwiceTraverse(int[] a) {
        int product = 1;
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = product;
            product *= a[i];
        }
        product = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            res[i] *= product;
            product *= a[i];
        }
        return res;
    }

    public int[] nestFor(int[] A) {
        int[] B = new int[A.length];
        Arrays.fill(B, 1);
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i == j) {
                    continue;
                } else {
                    B[i] *= A[j];
                }
            }
        }
        return B;
    }
}
