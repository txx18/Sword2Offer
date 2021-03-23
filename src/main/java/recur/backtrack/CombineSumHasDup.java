package recur.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 一个数组中的数字可以重复出现多次，但是每个元素只能用一次
 *
 *
 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的每个数字在每个组合中只能使用一次。

 说明：

 所有数字（包括目标数）都是正整数。
 解集不能包含重复的组合。
 示例 1:

 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 所求解集为:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 示例 2:

 输入: candidates = [2,5,2,1,2], target = 5,
 所求解集为:
 [
 [1,2,2],
 [5]
 ]
 * @author ShaneTang
 * @create 2021-03-20 18:33
 */
public class CombineSumHasDup {

    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> track = new ArrayList<>();
    int[] nums;
    int targetSum;
    int curSum;

    /**
     * 通过LC NK
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // 注意
        nums = candidates;
        targetSum = target;
        bt(0);
        return res;
    }

    private void bt(int startIndex) {
        // 剪枝
        if (curSum > targetSum) {
            return;
        }
        if (curSum == targetSum) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i - 1] == nums[i]) { // 注意。去重，不去重的话会出现相同的组合，同一树层上不能重复选择
                continue;
            }
            curSum += nums[i];
            track.add(nums[i]);
            bt(i + 1); // i + 1
            curSum -= nums[i];
            track.remove(track.size() - 1);
        }
    }
}
