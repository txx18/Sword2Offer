package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ShaneTang
 * @create 2021-02-21 9:16
 */
public class TwoSumUnorder {

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
