package recur.backtrack;

import java.util.*;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShaneTang
 * @create 2021-01-12 11:09
 */
public class PermuteNumNoDup {

    public static void main(String[] args) {
        PermuteNumNoDup obj = new PermuteNumNoDup();
        int[] arr = {1, 2, 3};
//        ArrayList<ArrayList<Integer>> res = obj.permute(arr);
        List<List<Integer>> res = obj.solutionSwap(arr);
        System.out.println("res = " + res);
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int[] nums;


    /**
     * 通过NK
     *
     * @param num
     * @return
     */
    ArrayList<ArrayList<Integer>> solutionBt(int[] num) {
        this.nums = num;
        btContains(0);
//        btMap();
        return res;
    }


//    /**
//     * 通过LC
//     * @param nums
//     * @return
//     */
//    List<List<Integer>> permuteLC(int[] nums) {
//        this.nums = nums;
//        btContains(0);
////        btMap();
//        return resLC;
//    }

    private void btContains(int index) {
        // 用index作参数可以
        if (index == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }
        // 全选择集遍历，跳过重复用过的，每一层都是全选择集遍历
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            track.add(nums[i]);
            btContains(index + 1);
            track.remove(track.size() - 1);
        }
    }

    List<List<Integer>> resLC = new ArrayList<>();

    /**
     * 通过LC
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> solutionSwap(int[] nums) {
        this.nums = nums;
        process(0);
        return resLC;
    }

    private void process(int i) {
        if (i == nums.length) {
            Integer[] integerArr = new Integer[nums.length];
            for (int j = 0; j < integerArr.length; j++) {
                integerArr[j] = nums[j];
            }
//            Integer[] integerArr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
            resLC.add(Arrays.asList(integerArr));
        }
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            process(i + 1);
            swap(nums, i, j);
        }
    }

    private void swap(int[] ints, int i, int j) {
        int tmp = ints[i];
        ints[i] = ints[j];
        ints[j] = tmp;
    }

    private void btContainsNoParam() {
        // track的长度可以当做base case
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

//    Map<Integer, Integer> trackMap = new HashMap<>();
//
//    private void btMap() {
//        if (track.size() == nums.length) {
//            res.add(new ArrayList<>(track));
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (trackMap.getOrDefault(nums[i], 0) != 0) {
//                continue;
//            }
//            track.add(nums[i]);
//            trackMap.put(nums[i], trackMap.getOrDefault(nums[i], 0) + 1);
//            btMap();
//            track.remove(track.size() - 1);
//            trackMap.put(nums[i], 0);
//        }
//    }

}
