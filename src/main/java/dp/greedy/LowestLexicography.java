package dp.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个字符串类型的数组strs，找到一种拼接方式，使得把所有字符串拼起来之后形成的字符串具有最小的字典序。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-06 18:01
 */
public class LowestLexicography {

    public static void main(String[] args) {
        String[] strings = {"abc", "xdfa", "dsahf", "sdgjk",};
//        String[] strings = { "jibw", "ji", "jp", "bw", "jibw" };

        LowestLexicography obj = new LowestLexicography();
        String res = obj.solution(strings);
        System.out.println("res = " + res);
    }

    private String solution(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }
        // 贪心策略，必须是有效的比较策略：传递性
        // a.b <= b.a && b.c <= c.b ==> a.c <= c.a
        // 贪心排序：s1拼接s2的字典序如果小于 s2拼接s1的字典序，就把s1排在前面
        // String 的排序默认按字典序
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder res = new StringBuilder();
        // 两个一组遍历，
        for (String string : strings) {
            res.append(string);
        }
        return res.toString();
    }
}
