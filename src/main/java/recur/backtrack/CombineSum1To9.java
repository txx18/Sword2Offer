package recur.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 *
 * 说明：
 *
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShaneTang
 * @create 2021-03-20 18:19
 */
public class CombineSum1To9 {

    public static void main(String[] args) {
        CombineSum1To9 obj = new CombineSum1To9();
        List<List<Integer>> res = obj.combinationSum3(3, 9);
        System.out.println("res = " + res);
    }

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int targetSum;
    int k;
    int curSum;

    /**
     * 通过LC
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0 || n <= 0) {
            return res;
        }
        this.targetSum = n;
        this.k = k;
        bt(1);
        return res;
    }

    private void bt(int startNum) {
        if (curSum > targetSum) {
            return;
        }
        if (track.size() == k && curSum == targetSum) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = startNum; i <= 9 - (k - track.size()) + 1; i++) { // <= 9 的剪枝
            curSum += i;
            track.add(i);
            bt(i + 1);
            curSum -= i;
            track.remove(track.size() - 1);
        }
    }


}
