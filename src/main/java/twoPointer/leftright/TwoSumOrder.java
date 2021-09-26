package twoPointer.leftright;

import java.util.*;

/**
 * @author ShaneTang
 * @create 2021-02-12 12:37
 */
public class TwoSumOrder {

    /**
     * 通过LC
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int l, r;
        l = 0;
        r = numbers.length - 1;
        while (l < r) {
            int cur = numbers[l] + numbers[r];
            if (cur < target) {
                l++;
            } else if (cur > target) {
                r--;
            } else {
/*                 res.add(numbers[l]);
                 res.add(numbers[r]);
                 return res;
                 return new ArrayList<>(Arrays.asList(numbers[l], numbers[r]));*/
/*                ArrayList<Integer> list = new ArrayList<>(2);
                Collections.addAll(list, new Integer[]{numbers[l], numbers[r]});
                return list;*/
                return new int[]{l + 1, r + 1};
            }
        }
        return null;
    }


}
