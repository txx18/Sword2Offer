package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ShaneTang
 * @create 2021-01-25 10:31
 */
public class LISeqLength {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 3, 4, 2, 3};
        int[] arr1 = new int[]{2, 1, 5, 3, 6, 4, 8, 9, 7};
        int[] arr2 = new int[0];
        LISeqLength obj = new LISeqLength();
//        int[] res = obj.LIS(arr1);
//        System.out.println("res = " + Arrays.toString(res));

        int res = obj.solutionDpTable1(arr2, arr2.length);
        System.out.println("res = " + res);
    }

    /**
     * 通过LC
     * @param A
     * @param n
     * @return
     */
    public int solutionDpTable1(int[] A, int n) {
        // write code here
        // 在子数组array中，从1开始第i个的目标子序列（最长递增子序列）的长度是dp[i]。
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (A[j - 1] < A[i - 1]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


//    public int lengthOfLIS(int[] nums) {
//        // write code here
//        // 在子数组array中，从1开始第i个的目标子序列（最长递增子序列）的长度是dp[i]。
//        int[] dp = new int[nums.length + 1];
//        Arrays.fill(dp, 1);
//        int res = 0;
//        for (int i = 1; i <= nums.length; i++) {
//            for (int j = 1; j < i; j++) {
//                if (nums[j - 1] < nums[i - 1]) {
//                    dp[i] = Math.max(dp[i], 1 + dp[j]);
//                }
//            }
//            res = Math.max(res, dp[i]);
//        }
//        return res;
//    }

    public int dpTable0(int[] A, int n) {
        // write code here
        int[] dp = new int[n];
        // 在子数组array[0..i]中，以下标i结尾的目标子序列（最长递增子序列）的长度是dp[i]。
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        int res = 0;
        for (int val : dp) {
            res = Math.max(res, val);
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

    public int[] LIS(int[] A) {
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
                    } else if (dp[j].size() + 1 > dp[i].size() && dicOrder(dp[j], dp[i])) {
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
