package hash;

/**
 * @author ShaneTang
 * @create 2021-02-05 23:03
 */
public class FirstUniqChar {

    public static void main(String[] args) {
        FirstUniqChar obj = new FirstUniqChar();
        int res = obj.FirstNotRepeatingChar("google");
        System.out.println("res = " + res);
    }

    public int FirstNotRepeatingChar(String str) {
        // char常用的有128个，用一个计数数组记录每个字符出现的次数
        int[] charCounts = new int[128];
        char[] chars = str.toCharArray();
        // 先记录每个字符的出现次数
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
