package dp.count;

import java.util.Arrays;


public class JumpFloorAbnormal {

    public static void main(String[] args) {
        JumpFloorAbnormal obj = new JumpFloorAbnormal();
        int res = obj.solutionRecurForce(8);
        System.out.println("res = " + res);
    }

    public int solutionDpTable(int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target];
    }

    public int solutionRecurForce(int target) {
        if (target <= 1) {
            return 1;
        }
        int res = 0; // 注意 res = 赋值
        for (int i = 1; i <= target; i++) {
            res += solutionRecurForce(target - i); // res +=
        }
        return res;
    }

    int[] cache;

    public int solutionCache(int target) {
        cache = new int[target + 1];
        return dp(target);
    }


    private int dp(int target) {
        if (target <= 1) {
            return 1;
        }
        if (cache[target] != 0) {
            return cache[target];
        }
        for (int i = 1; i <= target; i++) {
            cache[target - i] = dp(target - i);
            cache[target] += cache[target - i];
        }
        return cache[target];
    }


    public int solutionMathPow(int target) {
        return (int) Math.pow(2, target - 1);
    }


}
