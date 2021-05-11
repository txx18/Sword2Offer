package recur.backtrack;

import java.util.*;

/**
 * 题目描述
 * 现在有一个没有重复元素的整数集合S，求S的所有子集
 * 注意：
 * 你给出的子集中的元素必须按升序排列
 * 给出的解集中不能出现重复的元素
 * 示例1
 * 输入
 * 复制
 * [1,2,3]
 * 返回值
 * 复制
 * [[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]
 *
 * @author ShaneTang
 * @create 2021-01-12 10:20
 */
public class SubsetsNoDup {

    public static void main(String[] args) {
        SubsetsNoDup obj = new SubsetsNoDup();
//        List<List<Integer>> res = obj.subsets(new int[]{1, 2, 3});
        List<List<Integer>> res = obj.subsets(new int[]{1, 2});
//        obj.processZS(new char[]{'a', 'b', 'c'}, 0);
        System.out.println("res = " + res);
    }


    ArrayList<Integer> track = new ArrayList<>();
    int[] S;

    List<List<Integer>> resLC = new LinkedList<>();

    /**
     * 通过LC
     *
     * @param S
     * @return
     */
    public List<List<Integer>> subsets(int[] S) {
        this.S = S;
        bt(0);
        return resLC;
    }


    private void bt(int startIndex) {
        // 没有必要加终止条件，若startIndex>=S.length则for循环终止
/*        if (startIndex >= S.length) {
            return;
        }*/
        // 每一层的track都是一个结果
        resLC.add(new ArrayList<>(track));
        // 从 startIndex 开始逐渐缩小选择集，
        for (int i = startIndex; i < S.length; i++) {
            track.add(S[i]);
            // 不含以前有的（交换位置不算）
            bt(i + 1);
            track.remove(track.size() - 1);
        }
    }


//    private void btParam(LinkedList<Integer> track, int[] S, int index) {
//        // new ArrayList<>(list)将复制list，以确保将元素存储到中res。如果list直接添加res，则该remove调用也会进行修改res
//        res.add(new LinkedList<>(track));
//        for (int i = index; i < S.length; i++) {
//            track.add(S[i]);
//            btParam(track, S, i + 1);
//            track.remove(track.size() - 1);
//        }
//    }
}
