package dp;

import java.util.Arrays;


public class FrogJumpFloor {

    public static void main(String[] args) {
        FrogJumpFloor obj = new FrogJumpFloor();
        int res = obj.dpTable(3);
        System.out.println("res = " + res);
    }


    public int dpTable(int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target];
    }

    public int pow(int target) {
        return (int) Math.pow(2, target - 1);
    }

}
