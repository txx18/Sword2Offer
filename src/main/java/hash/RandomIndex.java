package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
 * <p>
 * 注意：
 * 数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。
 * <p>
 * 示例:
 * <p>
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 * <p>
 * // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
 * solution.pick(3);
 * <p>
 * // pick(1) 应该返回 0。因为只有nums[0]等于1。
 * solution.pick(1);
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/random-pick-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-23 20:58
 */
public class RandomIndex {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3};
        RandomIndex obj = new RandomIndex(nums);
        int res = obj.pick(3);
        System.out.println("res = " + res);

    }

    HashMap<Integer, List<Integer>> keyIndexMap = new HashMap<>();

    public RandomIndex(int[] nums) {
        // 装填keyIndexMap
        for (int i = 0; i < nums.length; i++) {
            // 如果已经包含，把新的index加上
            if (keyIndexMap.containsKey(nums[i])) {
                keyIndexMap.get(nums[i]).add(i);
            }
            // 如果没有，new 一个索引List加上
            else {
                List<Integer> keyIndexes = new ArrayList<Integer>();
                keyIndexes.add(i);
                keyIndexMap.put(nums[i], keyIndexes);
            }
        }
    }

    public int pick(int target) {
        List<Integer> keyIndexes = keyIndexMap.get(target);
        int chooseIndex = (int) (Math.random() * keyIndexes.size());
        return keyIndexes.get(chooseIndex);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */

