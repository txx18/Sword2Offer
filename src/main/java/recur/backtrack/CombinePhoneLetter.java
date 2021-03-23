package recur.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShaneTang
 * @create 2021-03-22 22:08
 */
public class CombinePhoneLetter {

    List<String> res = new ArrayList<>();
    StringBuilder track = new StringBuilder();
    String[] phone;
    String digits;

    /**
     * 通过LC
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return res;
        }
        this.digits = digits;
        // 1 ~ 9 按键
        phone = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        bt(0);
        return res;
    }

    /**
     * 来到 index 位置
     * @param digitIndex
     */
    private void bt(int digitIndex) {
        if (track.length() == digits.length()) {
            res.add(track.toString());
            return;
        }
        // 得到digitIndex位置输入的数字， char 转 int
        int digit = digits.charAt(digitIndex) - '0';
        // 不同集合求组合
        for (int i = 0; i < phone[digit].length(); i++) {
            track.append(phone[digit].charAt(i));
            bt(digitIndex + 1);
            track.deleteCharAt(track.length() - 1);
        }
    }

}
