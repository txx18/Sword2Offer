package recurforcetry.backtrack;

import java.util.ArrayList;

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
public class Subsets {

    public static void main(String[] args) {
        Subsets obj = new Subsets();
        ArrayList<ArrayList<Integer>> res = obj.subsets(new int[]{1, 2, 3});
        System.out.println("res = " + res);
    }


    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> track = new ArrayList<>();
    int[] S;

    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        this.S = S;
//        ArrayList<Integer> track = new ArrayList<>();
//        btParam(track, S,0);
        backtrackMV(0);
        return res;
    }

    private void backtrackMV(int index) {
        // new ArrayList<>(track) 必须构造再加入
        res.add(new ArrayList<>(track));
        for (int i = index; i < S.length; i++) {
            track.add(S[i]);
            backtrackMV(i + 1);
            track.remove(track.size() - 1);
        }
    }

    private void btParam(ArrayList<Integer> track, int[] S, int index) {
        // new ArrayList<>(list)将复制list，以确保将元素存储到中res。如果list直接添加res，则该remove调用也会进行修改res
        res.add(new ArrayList<>(track));
        for (int i = index; i < S.length; i++) {
            track.add(S[i]);
            btParam(track, S, i + 1);
            track.remove(track.size() - 1);
        }
    }
}
