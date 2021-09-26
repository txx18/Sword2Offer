package hash;

/**
 * @author ShaneTang
 * @create 2021-04-02 16:01
 */
public class IsAnagram {

    public static void main(String[] args) {
        IsAnagram obj = new IsAnagram();
        boolean res = obj.isAnagram("rat", "car");
        System.out.println("res = " + res);
    }

    public boolean isAnagram(String s, String t) {
        // 数组作为哈希表的思想
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            counts[t.charAt(i) - 'a']--;
            if (counts[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
