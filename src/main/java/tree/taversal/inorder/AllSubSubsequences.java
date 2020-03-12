package tree.taversal.inorder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-12 17:08
 */
public class AllSubSubsequences {

    public static void main(String[] args) {
        String str = "abcd";
        AllSubSubsequences obj = new AllSubSubsequences();
        List<String> res = obj.solution(str);
        System.out.println("res = " + res);

        obj.process("abcd".toCharArray(), 0);
    }

    List<String> res = new ArrayList<>();

    private List<String> solution(String str) {
        String path = "";
        char[] chars = str.toCharArray();
        return recur(0, chars, path);
    }

    /**
     *
     * @param i 来到第i位
     * @param chars
     * @param path 之前选择的路径
     * @return
     */
    private List<String> recur(int i, char[] chars, String path) {
        // 第i层，一共n层，一共有2^n个结果
        if (i == chars.length) {
            res.add(path);
            return res;
        }
        // 先序框架
        String noPath = path;
        recur(i + 1, chars, noPath);
        String yesPath = path + chars[i];
        recur(i + 1, chars, yesPath);
        return res;
    }

    public void process(char[] str, int i) {
        if (i == str.length) {
            System.out.println(String.valueOf(str));
            return;
        }
        process(str, i + 1); // 要当前字符的路
        char tmp = str[i];
        str[i] = 0;
        process(str, i + 1); // 不要当前字符的路
        str[i] = tmp;
    }
}
