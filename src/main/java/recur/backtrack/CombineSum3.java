package recur.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ShaneTang
 * @create 2021-03-20 18:19
 */
public class CombineSum3 {

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
        for (int i = startNum; i <= 9; i++) {
            curSum += i;
            track.add(i);
            bt(i + 1);
            curSum -= i;
            track.remove(track.size() - 1);
        }
    }


}
