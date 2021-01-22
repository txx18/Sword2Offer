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
        List<List<Integer>> res = obj.permute(arr);
        System.out.println("res = " + res);
    }

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int[] nums;
    Map<Integer, Integer> trackMap = new HashMap<>();

    List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
//        btContainsNoParam();
        btMap();
        return res;
    }

    void btContainsNoParam() {
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        // 全选择集遍历，跳过重复的，每一层都是全选择集遍历
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            btContainsNoParam();
            track.remove(track.size() - 1);
        }
    }


    void btContains(int index) {
        // 用index作参数可以
        if (index == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        // 全选择集遍历，跳过重复的，每一层都是全选择集遍历
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            btContains(index + 1);
            track.remove(track.size() - 1);
        }
    }

    private void btMap() {
        if (track.size()  == nums.length) {
            res.add(new LinkedList<>(track));
        }
        for (int i = 0; i < nums.length; i++) {
            if (trackMap.getOrDefault(nums[i],  0) != 0) {
                continue;
            }
            track.add(nums[i]);
            trackMap.put(nums[i], trackMap.getOrDefault(nums[i], 0) + 1);
            btMap();
            track.remove(track.size() - 1);
            trackMap.put(nums[i], 0);
        }
    }

}
