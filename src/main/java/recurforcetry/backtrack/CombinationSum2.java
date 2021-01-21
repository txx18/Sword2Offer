package recurforcetry.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * todo 没有符合题意
 * @author ShaneTang
 * @create 2021-01-18 11:25
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        CombinationSum2 obj = new CombinationSum2();
//        ArrayList<ArrayList<Integer>> res = obj.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        ArrayList<ArrayList<Integer>> res = obj.combinationSum2(new int[]{100,10,20,70,60,10,50, 10}, 80);
        System.out.println("res = " + res);
    }

    ArrayList<Integer> track = new ArrayList<>();
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    int[] nums;
    int target;
    int sum;

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
/*        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < num.length; i++) {
            treeSet.add(num[i]);
        }
        this.nums = treeSet.toArray(new Integer[0]);*/
        Arrays.sort(num);
        this.nums = num;
        this.target = target;
        bt(0);
        return res;
    }

    private void bt(int index) {
        if (sum == target) {
            res.add(new ArrayList<>(track));
        }
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            track.add(nums[i]);
            sum += nums[i];
            bt(i + 1);
            track.remove(track.size() - 1);
            sum -= nums[i];
        }
    }
}
