package twoPointer.leftright;

/**
 * @author ShaneTang
 * @create 2021-02-03 22:52
 */
public class JudgePalindrome {

    public boolean judge(String str) {
        // write code here
        char[] chars = str.toCharArray();
        for (int l = 0, r = chars.length - 1; l < r; l++, r--) {
            if (chars[l] != chars[r]) {
                return false;
            }
        }
        return true;
    }
}
