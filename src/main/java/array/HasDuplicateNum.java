package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * 数组中重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-07 11:22
 */
public class HasDuplicateNum {

    /**
     * NK
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
//        return solutionBySort(numbers, length, duplication);
//        return solutionByHashMap(numbers, length, duplication);
//        return solutionByHashSet(numbers, length, duplication);
        return solutionSwap(numbers, length, duplication);
    }

    /**
     * LC
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        return solutionSwapSTO(nums);
    }

    /**
     * NK
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    private boolean solutionSwap(int[] numbers, int length, int[] duplication) {
        if (numbers == null || length < 2) {
            return false;
        }
        // 遍历数组，arr[i]的值本来是i，如果是不是i，则准备与下标为arr[i]的元素交换（换到它应该在的位置）
        for (int i = 0; i < length; i++) {
            // 如果正常，判断下一个
            if (numbers[i] == i) {
                continue;
            }
            // 如果两元素相等，则返回
            if (numbers[i] == numbers[numbers[i]]) {
                duplication[0] = numbers[i];
                return true;
            }
            // 否则把该元素交换到本来的位置
            swap(numbers, numbers[i], i);
        }
        return false;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        // 异或方法i不能等于j
/*        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];*/
    }

    private int solutionSwapSTO(int[] nums) {
        if (nums == null || nums.length < 2) {
            return -1;
        }
        // 遍历数组，arr[i]的值本来是i，如果是不是i，则准备与下标为arr[i]的元素交换（换到它应该在的位置）
        for (int i = 0; i < nums.length; i++) {
            // 如果正常，判断下一个
            if (nums[i] == i) {
                continue;
            }
            // 如果两元素相等，则返回
            if (nums[i] == nums[nums[i]]) {
                return nums[i];
            }
            // 否则把该元素交换到本来的位置
            swap(nums, nums[i], i);
        }
        return -1;
    }


    private boolean solutionByHashSet(int[] numbers, int length, int[] duplication) {
        if (numbers == null || length < 2) {
            return false;
        }
        HashSet<Integer> set = new HashSet<>(10);
        for (int number : numbers) {
            if (set.contains(number)) {
                duplication[0] = number;
                return true;
            } else {
                set.add(number);
            }
        }
        return false;
    }

    private boolean solutionByHashMap(int[] numbers, int length, int[] duplication) {
        if (numbers == null || length < 2) {
            return false;
        }
        // 如果哈希表中已存在，则返回
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int number : numbers) {
            if (map.get(number) == null) {
                map.put(number, 1);
            } else {
                duplication[0] = number;
                return true;
            }
        }
        return false;
    }

    private boolean solutionBySort(int[] numbers, int length, int[] duplication) {
        if (numbers == null || length < 2) {
            return false;
        }
        // 排序数组
        Arrays.sort(numbers);
        // 开始遍历
        for (int i = 0; i < length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }


}
