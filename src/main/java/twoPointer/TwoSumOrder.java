package twoPointer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ShaneTang
 * @create 2021-02-12 12:37
 */
public class TwoSumOrder {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int l, r;
        l = 0;
        r = array.length - 1;
        while (l < r) {
            int cur = array[l] + array[r];
            if (cur < sum) {
                l++;
            } else if (cur > sum) {
                r--;
            } else {
//                 res.add(array[l]);
//                 res.add(array[r]);
//                 return res;
//                 return new ArrayList<>(Arrays.asList(array[l], array[r]));
                ArrayList<Integer> list = new ArrayList<>(2);
                Collections.addAll(list, new Integer[]{array[l], array[r]});
                return list;
            }
        }
        return res;
    }

    public int[] twoSum(int[] numbers, int target) {
        // write code here
        // 倒排map
        int n = numbers.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(numbers[i], i);
        }
        for (int i = 0; i < n; i++) {
            int other = target - numbers[i];
            if (map.containsKey(other) && map.get(other) != i) {
                return new int[]{i + 1, map.get(other) + 1};
            }
        }
        return null;
    }
}
