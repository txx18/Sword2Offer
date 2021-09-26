package twoPointer.frontbehind;

/**
 * @author ShaneTang
 * @create 2021-03-05 23:22
 */
public class FindMaxNoDupSubstringLength {

    public static void main(String[] args) {
        FindMaxNoDupSubstringLength obj = new FindMaxNoDupSubstringLength();
        int res = obj.maxLength(new int[]{2, 3, 4, 5});
        System.out.println("res = " + res);
    }

    public int maxLength(int[] arr) {
        // write code here
        if (arr.length <= 1) {
            return arr.length;
        }
        int i, j;
        i = 0;
        j = 1;
        while (j < arr.length) {
            if (arr[i] == arr[j]) {
                i = j;
            }
            j++;
        }
        return j - i + 1;
    }
}
