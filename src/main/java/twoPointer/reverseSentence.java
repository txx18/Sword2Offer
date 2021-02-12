package twoPointer;

/**
 * @author ShaneTang
 * @create 2021-01-11 10:40
 */

import java.util.*;

public class reverseSentence {
    public static void main(String[] args) {
        reverseSentence obj = new reverseSentence();
        Scanner sc = new Scanner(System.in);
        String[] splits = sc.nextLine().split(" ");
        String[] reversedArr = obj.reverseArr(splits);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < reversedArr.length; i++) {
            sb.append(reversedArr[i]);
            if(i < reversedArr.length - 1) {
                sb.append(" ");
            }
        }
        System.out.print(sb.toString());
    }

    private String[] reverseArr(String[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            String t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
        return arr;
    }
}
