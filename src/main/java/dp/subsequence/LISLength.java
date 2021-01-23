package dp.subsequence;

import java.text.ParsePosition;
import java.util.Arrays;

/**
 * @author ShaneTang
 * @create 2021-01-23 11:03
 */
public class LISLength {

    public int findLongest(int[] A, int n) {
        // write code here
        int[] dp = new int[A.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        int res = 0;
        for (int j : dp) {
            res = Math.max(res, j);
        }
        return res;
    }

    public int findLongestBS(int[] A, int n) {
        // 存储牌
        int[] top = new int[A.length];
        int pileCount = 0;
        for (int poker : A) {
            int left = 0;
            int right = pileCount;
            // 左边界二分查找
            while (left < right) {
                int mid = left + ((right - left) >> 1);
                if (poker <= top[mid]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left == pileCount) {
                pileCount++;
            }
            top[left] = poker;
        }
        return pileCount;
    }

}
