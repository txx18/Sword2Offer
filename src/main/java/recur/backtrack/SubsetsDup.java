package recur.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ShaneTang
 * @create 2021-04-01 14:33
 */
public class SubsetsDup {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> track = new ArrayList<>();
    boolean[] hasUsed;
    int[] nums;

    /**
     * 通过LC
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        this.hasUsed = new boolean[nums.length];
        bt(0);
        return res;
    }

    private void bt(int startIndex) {
        res.add(new ArrayList<>(track));
        for (int i = startIndex; i < nums.length; i++) {
            if (hasUsed[i]) {
                continue;
            }
            // used[i - 1] == true，说明同一树支candidates[i - 1]使用过
            // used[i - 1] == false，说明同一树层candidates[i - 1]使用过
            // 而我们要对同一树层使用过的元素进行跳过
            if (i > startIndex && nums[i - 1] == nums[i] && !hasUsed[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            hasUsed[i] = true;
            bt(i + 1);
            track.remove(track.size() - 1);
            hasUsed[i] = false;
        }
    }

}
