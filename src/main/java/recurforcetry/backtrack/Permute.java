package recurforcetry.backtrack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShaneTang
 * @create 2021-01-12 11:09
 */
public class Permute {

    public static void main(String[] args) {
        Permute obj = new Permute();
        int[] arr = {1, 2, 3};
        obj.permute(arr);
    }

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int[] nums;
    Map<Integer, Integer> trackMap = new HashMap<>();

    List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        bt(0);
        return res;
    }

    private void bt(int index) {
        if (index == nums.length) {
            res.add(new LinkedList<>(track));
        }
        for (int i = 0; i < nums.length; i++) {
            if (trackMap.getOrDefault(nums[i],  0) != 0) {
                continue;
            }
            track.add(nums[i]);
            trackMap.put(nums[i], trackMap.getOrDefault(nums[i], 0) + 1);
            bt(index + 1);
            track.remove(track.size() - 1);
            trackMap.put(nums[i], 0);
        }
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现

    void backtrack() {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i])) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack();
            // 取消选择
            track.removeLast();
        }
    }
}
