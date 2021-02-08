package dp;

import math.TrailingZeroes;

import java.util.Arrays;


public class FrogJumpFloor {

    public static void main(String[] args) {
        FrogJumpFloor obj = new FrogJumpFloor();
        int res = obj.solutionRecur(15);
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

    public int solutionMathPow(int target) {
        return (int) Math.pow(2, target - 1);
    }


    public int solutionRecur(int target) {
        memo = new int[target + 1];
        return dp(target);

    }

    int[] memo;
    
    private int dp(int target) {
        if (target <= 1) {
            return 1;
        }
        if (memo[target] != 0) {
            return memo[target];
        }
        for (int i = 1; i <= target; i++) {
            memo[target - i] = dp(target - i);
            memo[target] += memo[target - i];
        }
        return memo[target];
    }
}
