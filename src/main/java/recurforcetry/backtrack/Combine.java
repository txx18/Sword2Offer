package recurforcetry.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author ShaneTang
 * @create 2021-01-12 11:17
 */
public class Combine {

    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int n;
    int k;

    List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n <= 0) {
            return res;
        }
        this.n = n;
        this.k = k;
        backtrack(1);
        return res;
    }

    void backtrack(int index) {
        // 到达树的底部
        if (track.size() == k) {
            res.add(new LinkedList<>(track));
            return;
        }
        // 注意 i 从 start 开始递增
        for (int i = index; i <= n; i++) {
            // 做选择
            track.add(i);
            backtrack(i + 1);
            // 撤销选择
            track.removeLast();
        }
    }
}
