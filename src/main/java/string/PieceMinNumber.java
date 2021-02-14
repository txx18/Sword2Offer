package string;

import java.util.Arrays;

/**
 * @author ShaneTang
 * @create 2021-02-14 16:25
 */
public class PieceMinNumber {

    public static void main(String[] args) {
        PieceMinNumber obj = new PieceMinNumber();
        String res = obj.PrintMinNumber(new int[]{3, 32, 321});
        System.out.println("res = " + res);
    }

    public String PrintMinNumber(int[] numbers) {
        int n = numbers.length;
        String[] numStrs = new String[n];
        for (int i = 0; i < n; i++) {
            numStrs[i] = String.valueOf(numbers[i]);
        }
//        Arrays.sort(numStrs, (String s1, String s2) -> {
//            return (s1 + s2).compareTo(s2 + s1);
//        });
        Arrays.sort(numStrs, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder res = new StringBuilder();
        for (String val : numStrs) {
            res.append(val);
        }
        return res.toString();
    }
}
