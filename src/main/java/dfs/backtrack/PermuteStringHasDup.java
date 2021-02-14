package dfs.backtrack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ShaneTang
 * @create 2021-02-08 15:33
 */
public class PermuteStringHasDup {

    public static void main(String[] args) {
        PermuteStringHasDup obj = new PermuteStringHasDup();
        ArrayList<String> res = obj.solutionBackTracking("ab");
        System.out.println("res = " + res);
    }

    ArrayList<String> res = new ArrayList<>();
    char[] chars;
    boolean[] hasUsed;
    StringBuilder track = new StringBuilder();

    public ArrayList<String> solutionBackTracking(String str) {
        chars = str.toCharArray();
        // 排序使重复的挨在一起
        Arrays.sort(chars);
        hasUsed = new boolean[chars.length];
        bt();
        return res;
    }

    private void bt() {
        if (track.length() == chars.length) {
            res.add(track.toString());
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i]) {
                continue;
            }
            // 此if使 i来到重复的最后一个下标处，之前的跳过
            if (i > 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) { // hasUsed[i-1]
                continue;
            }
            track.append(chars[i]);
            hasUsed[i] = true;
            bt();
            track.deleteCharAt(track.length() - 1);
            hasUsed[i] = false;
        }
    }
}
