package recur.dp.max;

import java.util.Arrays;
import java.util.List;

/**
 * @author ShaneTang
 * @create 2021-02-03 11:09
 */
public class LISeq {

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] arr2 = {1, 2, 8, 6, 4};
        LISeq obj = new LISeq();
        int[] res = obj.LIS(arr2);
        System.out.println("res = " + Arrays.toString(res));
    }


    public int[] LIS(int[] A) {
        // todo 超时 write code here
        int n = A.length;
        StringBuilder[] dpSb = new StringBuilder[n + 1];
        for (int i = 1; i <= n; i++) {
            dpSb[i] = new StringBuilder(String.valueOf(A[i - 1]));
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (A[j - 1] < A[i - 1]) {
                    StringBuilder newSb = new StringBuilder(dpSb[j]).append(A[i - 1]);
                    if (newSb.length() > dpSb[i].length() || smallerDicOrder(newSb, dpSb[i])) {
                        dpSb[i] = newSb;
                    }
                }
            }
        }
        StringBuilder resSb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (dpSb[i].length() > resSb.length() || smallerDicOrder(dpSb[i], resSb)) {
                resSb = dpSb[i];
            }
        }
        return toIntArray(resSb);
    }

    private int[] toIntArray(StringBuilder sb) {
        char[] chars = sb.toString().toCharArray();
        int[] res = new int[sb.length()];
        for (int i = 0; i < chars.length; i++) {
            res[i] = Character.getNumericValue(chars[i]);
        }
        return res;
    }

    private boolean smallerDicOrder(StringBuilder sb1, StringBuilder sb2) {
        int compare = sb1.toString().compareTo(sb2.toString());
        return compare < 0;
    }

    public int[] convertToArray(List<Integer> list) {
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
