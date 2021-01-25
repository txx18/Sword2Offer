package dp.subsequence;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ShaneTang
 * @create 2021-01-25 10:31
 */
public class LIS {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 3, 4, 2, 3};
        int[] arr1 = new int[]{2,1,5,3,6,4,8,9,7};
        LIS obj = new LIS();
        int[] res = obj.LIS(arr1);
        System.out.println("res = " + Arrays.toString(res));
    }

    public int[] LIS (int[] A) {
        // todo write code here
        LinkedList<Integer>[] dp = new LinkedList[A.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new LinkedList<>();
            dp[i].add(A[i]);
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    if (dp[i].size() == 1) {
                        dp[i] = new LinkedList<>(dp[j]);
                        dp[i].add(A[i]);
                    }
                    else if (dp[j].size() + 1 > dp[i].size() && dicOrder(dp[j], dp[i])) {
                        dp[i] = new LinkedList<>(dp[j]);
                        dp[i].add(A[i]);
                    }
                }
            }
        }
        LinkedList<Integer> resList = new LinkedList<>();
        for (LinkedList<Integer> item : dp) {
            if (item.size() > resList.size()) {
                resList = item;
            }/*else if (item.size() == resList.size()) {
                boolean replace = false;
                // 要求字典序最小
                for (int i = 0; i < item.size(); i++) {
                    if (item.get(i) < resList.get(i)) {
                        replace = true;
                        break;
                    }
                }
                if (replace) {
                    resList = item;
                }
            }*/
        }
        return convertToArray(resList);
    }

    private boolean dicOrder(LinkedList<Integer> dpi, LinkedList<Integer> dpj) {
        boolean replace = false;
        // 要求字典序最小
        for (int i = 0; i < dpi.size(); i++) {
            if (dpj.get(i) < dpi.get(i)) {
                replace = true;
                break;
            }
        }
        return replace;
    }

    public int[] convertToArray(List<Integer> list) {
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
