package recur.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ShaneTang
 * @create 2021-03-06 23:06
 */
public class PermuteString {


    public static void main(String[] args) {
        PermuteString obj = new PermuteString();
        ArrayList<String> res = obj.Permutation("abbc");
        System.out.println("res = " + res);
    }

    ArrayList<String> res = new ArrayList<>();
    char[] chars;
    int[] nums;

    List<List<Integer>> resLC = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public ArrayList<String> Permutation(String str) {
        chars = str.toCharArray();
        processChars(0);
        return res;
    }


    // str[i..]范围上，所有的字符，都可以在i位置上，后续都去尝试
    // str[0..i-1]范围上，是之前做的选择
    // 请把所有的字符串形成的全排列，加入到res里去
    public void processChars(int i) {
        if (i == chars.length) {
            res.add(String.valueOf(chars));
        }
        boolean[] visit = new boolean[26]; // visit[0 1 .. 25]
        for (int j = i; j < chars.length; j++) {
            if (!visit[chars[j] - 'a']) {  // 可以应对有重复字符
                visit[chars[j] - 'a'] = true;
                swap(chars, i, j);
                processChars(i + 1);
                swap(chars, i, j);
            }
        }
    }

    public void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }

    public void swap(int[] chs, int i, int j) {
        int tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }
}
