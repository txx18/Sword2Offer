package string;

/**
 * @author ShaneTang
 * @create 2021-02-05 23:03
 */
public class FirstNotRepeatingChar {

    public static void main(String[] args) {
        FirstNotRepeatingChar obj = new FirstNotRepeatingChar();
        int res = obj.FirstNotRepeatingChar("google");
        System.out.println("res = " + res);
    }

    public int FirstNotRepeatingChar(String str) {
        // char常用的有128个，用一个计数数组记录每个字符出现的次数
        int[] charCounts = new int[128];
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            charCounts[chars[i]]++;
        }
        // 靠的是第二次遍历
        for (int i = 0; i < chars.length; i++) {
            if (charCounts[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}
