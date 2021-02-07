package array;

import java.util.Arrays;

/**
 * @author ShaneTang
 * @create 2021-02-06 16:05
 */
public class ProductArray {

    public static void main(String[] args) {
        ProductArray obj = new ProductArray();
        int[] res = obj.leftRight(new int[]{1, 2, 3, 4, 5});
        System.out.println("res = " + Arrays.toString(res));
    }


    public int[] leftRight(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        int product = 1;
        for (int i = 0; i < n; i++) {
            B[i] = product;
            product *= A[i];
        }
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            B[i] *= product;
            product *= A[i];
        }
        return B;
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
