package string;

/**
 * @author ShaneTang
 * @create 2021-02-05 23:03
 */
public class FirstNotRepeatingChar {

    public int FirstNotRepeatingChar(String str) {
        // char只有256种可能
        int[] counts = new int[256];
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            counts[aChar]++;
        }
        for (int i = 0; i < chars.length; i++) {
            if (counts[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}
