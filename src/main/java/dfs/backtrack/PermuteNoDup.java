package dfs.backtrack;

import java.util.*;

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
public class PermuteNoDup {

    public static void main(String[] args) {
        PermuteNoDup obj = new PermuteNoDup();
        int[] arr = {1, 2, 3};
        ArrayList<ArrayList<Integer>> res = obj.permute(arr);
        System.out.println("res = " + res);
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int[] nums;
    Map<Integer, Integer> trackMap = new HashMap<>();

    ArrayList<ArrayList<Integer>> permute(int[] num) {
        this.nums = num;
        btContainsNoParam();
//        btMap();
        return res;
    }

    void btContainsNoParam() {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
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
            res.add(new ArrayList<>(track));
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
            res.add(new ArrayList<>(track));
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