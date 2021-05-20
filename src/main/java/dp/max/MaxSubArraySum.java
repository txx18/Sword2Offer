package dp.max;

/**
 * @author ShaneTang
 * @create 2021-02-21 17:33
 */
public class MaxSubArraySum {

    public static void main(String[] args) {
        MaxSubArraySum obj = new MaxSubArraySum();
        int res = obj.solutionGreedy(new int[]{1, -2, 3, 10, -4, 7, 2, -5});
        System.out.println("res = " + res);
    }

    public int solutionGreedy(int[] nums) {
        int res = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            res = Math.max(res, curSum);
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return res;
    }

    public int solutionDpOpt(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int val : array) {
            if (sum <= 0) {
                sum = val;
            } else {
                sum += val;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
