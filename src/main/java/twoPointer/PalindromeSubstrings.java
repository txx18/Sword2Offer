package twoPointer;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author ShaneTang
 * @create 2021-06-03 20:50
 */
public class PalindromeSubstrings {

    static class MaxSubString {

        public static void main(String[] args) {
            MaxSubString obj = new MaxSubString();
            String test = "babad";
            String res = obj.longestPalindrome(test);
            System.out.println("res = " + res);
        }

        String s;

        public String longestPalindrome(String s) {
            this.s = s;
            String res = "";
            for (int i = 0; i < s.length(); i++) {
                String subRes1 = extend(i, i);
                if (subRes1.length() > res.length()) {
                    res = subRes1;
                }
                String subRes2 = extend(i, i + 1);
                if (subRes2.length() > res.length()) {
                    res = subRes2;
                }
            }
            return res;
        }

        private String extend(int i, int j) {
            //这个区间的回文子串个数 subRes = 0;，
            //这个区间的最长回文串长度
            StringBuilder subRes = new StringBuilder();
            if (i == j) {
                subRes.append(s.charAt(i));
                i--;
                j++;
            }
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                subRes.insert(0, s.charAt(i)).append(s.charAt(j));
                i--;
                j++;
            }
            return subRes.toString();
        }

        private int max(int a, int b, int c) {
            return Math.max(a, Math.max(b, c));
        }
    }

    class MaxLength {

        String s;

        public int getLongestPalindrome(String A, int n) {
            // write code here
            this.s = A;
            int res = 0;
            for (int i = 0; i < n; i++) {
                res = Math.max(res, extend(i, i));
                res = Math.max(res, extend(i, i + 1));
            }
            return res;

        }

        private int extend(int i, int j) {
            int subRes = 0;
            if (i == j) {
                subRes = 1;
                i--;
                j++;
            }
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                subRes += 2;
                i--;
                j++;
            }
            return subRes;
        }
    }

    class Count {

        String s;

        public int countSubstrings(String s) {
            this.s = s;
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                res += extend(i, i);
                res += extend(i, i + 1);
            }
            return res;
        }

        private int extend(int i, int j) {
            int subRes = 0;
            while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
                subRes++;
            }
            return subRes;
        }
    }
}