package recur.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * 组合这类问题，默认是，如果输入里就有重复的，那结果中这些重复的各可以使用1次
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShaneTang
 * @create 2021-01-12 11:17
 */
public class CombineKNum {

    public static void main(String[] args) {
        CombineKNum obj = new CombineKNum();
        int[] test = new int[]{4, 1, 3, 2, 2};
//        List<List<Integer>> res = obj.combine(4, 2);
        List<List<Integer>> res = obj.combine(test, 3);
        System.out.println("res = " + res);
    }

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int n;
    int k;
    int[] nums;

    List<List<Integer>> combine(int[] num, int k) {
        if (k <= 0 || num.length <= 0) {
            return res;
        }
        this.nums = num;
        this.k = k;
        bt(0);
        return res;
    }

    private void bt(int startIndex) {
        // 到达树的底部，要求层数为k
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
        }
        // 从 startIndex 开始逐渐缩小选择集，
        for (int i = startIndex; i < nums.length; i++) {
            track.add(nums[i]);
            // 不含以前有的（交换位置不算）
            bt(i + 1);
            track.remove(track.size() - 1);
        }
    }

    List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n <= 0) {
            return res;
        }
        this.n = n;
        this.k = k;
        bt1ToN(1);
        return res;
    }

    private void bt1ToN(int startNum) {
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
//        已经选择的元素个数：path.size();
//        还需要的元素个数为: k - path.size();
//        在集合n中至多要遍历到 : n - (k - path.size()) + 1
//        为什么有个+1呢，因为包括起始位置，我们要是一个左闭的集合。
        for (int i = startNum; i <= n - (k - track.size()) + 1; i++) { // 不剪枝是 <= n
            track.add(i);
            bt1ToN(i + 1);
            track.remove(track.size() - 1);
        }
    }
}
