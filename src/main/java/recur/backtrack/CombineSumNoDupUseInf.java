package recur.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShaneTang
 * @create 2021-03-23 17:39
 */
public class CombineSumNoDupUseInf {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> track = new ArrayList<>();
    int[] nums;
    int target;
    int curSum;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        nums = candidates;
        this.target = target;
        bt(0);
        return res;
    }

    private void bt(int startIndex) {
        if (curSum == target) {
            res.add(new ArrayList<>(track));
            return;
        }
        if (curSum > target) {
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            track.add(nums[i]);
            curSum += nums[i];
            bt(i); // i
            track.remove(track.size() - 1);
            curSum -= nums[i];
        }
    }
}
