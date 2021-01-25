package dp.subsequence;

import zhelper.ListUtils;

import java.text.ParsePosition;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 对于一个数字序列，请设计一个复杂度为O(nlogn)的算法，返回该序列的最长上升子序列的长度，这里的子序列定义为这样一个序列U1，U2...，其中Ui < Ui+1，且A[Ui] < A[Ui+1]。
 *
 * 给定一个数字序列A及序列的长度n，请返回最长上升子序列的长度。
 *
 * 测试样例：
 * [2,1,4,3,1,5,6],7
 * 返回：4
 * @author ShaneTang
 * @create 2021-01-23 11:03
 */
public class LISLength {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 3, 4, 2, 3};
        int[] arr1 = new int[]{2,1,5,3,6,4,8,9,7};
        LISLength obj = new LISLength();
        int res = obj.findLongest(arr1, arr1.length);
        System.out.println("res = " + res);
    }

    public int findLongest(int[] A, int n) {
        // write code here
        // dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        int[] dp = new int[A.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
/*                    if (1 + dp[j] > dp[i]) {
                        dp[i] = 1 + dp[j];
                    }*/
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
