package recur;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ShaneTang
 * @create 2021-03-07 21:35
 */
public class SubsetsRecur {

    int[] S;

    List<List<Integer>> resLC = new LinkedList<>();

    /**
     * 通过LC
     *
     * @param S
     * @return
     */
    public List<List<Integer>> solutionZS(int[] S) {
        this.S = S;
        ArrayList<Integer> path = new ArrayList<>();
        recurZS2(0, path);
        return resLC;
    }

    private void recurZS2(int i, ArrayList<Integer> path) {
        if (i == S.length) {
            resLC.add(path);
            return;
        }
        ArrayList<Integer> res1 = new ArrayList<>(path);
        recurZS2(i + 1, res1);
        ArrayList<Integer> res2 = new ArrayList<>(path);
        res2.add(S[i]);
        recurZS2(i + 1, res2);
    }


    public void processZS(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
            return;
        }
        processZS(chs, i + 1);
        char tmp = chs[i];
        chs[i] = 0;
        processZS(chs, i + 1);
        chs[i] = tmp;
    }
}
