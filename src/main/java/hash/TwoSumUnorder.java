package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ShaneTang
 * @create 2021-02-21 9:16
 */
public class TwoSumUnorder {

    /**
     * 通过LC
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        // write code here
        // 倒排map
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < n; i++) {
            int other = target - nums[i];
            if (map.containsKey(other) && map.get(other) != i) { // 注意两下标不能相同
                return new int[]{i, map.get(other)};
            }
        }
        return null;
    }
}
