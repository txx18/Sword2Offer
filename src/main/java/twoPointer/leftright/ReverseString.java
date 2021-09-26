package twoPointer.leftright;

/**
 * @author ShaneTang
 * @create 2021-02-03 22:44
 */
public class ReverseString {

    public String sb(String str) {
        // write code here
        return new StringBuilder(str).reverse().toString();
    }

    public String twoPointer(String str) {
        // write code here
        char[] chars = str.toCharArray();
        for (int l = 0, r = chars.length - 1; l < r; l++, r--) {
            char tmp = chars[l];
            chars[l] = chars[r];
            chars[r] = tmp;
        }
        return new String(chars);
    }
}
