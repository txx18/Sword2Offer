package recur.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ShaneTang
 * @create 2021-03-20 18:33
 */
public class CombineSum2 {

    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> track = new ArrayList<>();
    int[] nums;
    int targetSum;
    int curSum;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        nums = candidates;
        targetSum = target;
        bt(0);
        return res;
    }

    private void bt(int index) {
        // 剪枝
        if (curSum > targetSum) {
            return;
        }
        if (curSum == targetSum) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i - 1] == nums[i]) {
                continue;
            }
            curSum += nums[i];
            track.add(nums[i]);
            bt(i + 1);
            curSum -= nums[i];
            track.remove(track.size() - 1);
        }
    }
}
