package array.partition;

import java.util.Arrays;

/**
 * 【左神】有一道题目，是奇数放在数组左边，偶数放在数组右边，还要求原始的相对次序不变，O(N)
 * 碰到这个问题，可以怼面试官。
 * 【答】这是0-1 stable问题，快排的Partition做不到稳定性，那么这个问题本质是partition，如果partition能做到，这个题也就能解了
 * 请您教教我吧（嗷嗷待哺）
 * （面试官肯定怂）
 */

/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-14 14:53
 */
public class ReOrderArrayE21 {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr2 = {2, 16, 3, 5, 13, 1, 16, 1, 12, 18, 11, 8, 11, 11, 5, 1};
        reOrderArray(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    /**
     * NK
     *
     * @param array
     */
    public static void reOrderArray(int[] array) {
//        stoSolutionSimpleSwap(array);
//        mySolutionSimplePartition(array);
//        mySolutionPartition(array);
//        stoSolutionSwap(array);
//        cycSolutionBubble(array);
        solutionCopyArray(array);
    }

    /**
     * 通过LC（10， 57.3）
     * 保证奇偶相对顺序稳定
     *
     * @param array
     */
    private static void solutionCopyArray(int[] array) {
        int[] cloneArr = new int[array.length];
        int oddCount = 0;
        for (int i = 0; i < array.length; i++) {
            cloneArr[i] = array[i];
            if (array[i] % 2 != 0) {
                oddCount++;
            }
        }
        int oddIndex = 0;
        int evenIndex = oddCount;
        for (int i = 0; i < cloneArr.length; i++) {
            if (cloneArr[i] % 2 != 0) {
                array[oddIndex++] = cloneArr[i];
            } else {
                array[evenIndex++] = cloneArr[i];
            }
        }
    }

    /**
     * LC
     *
     * @param nums
     * @return
     */
    public static int[] exchange(int[] nums) {
        solutionSimplePartitionOnce(nums);
        // mySolutionPartition(nums);
        //stoSolutionSwap(nums);
        // cycSolutionBubble(nums);
        // cycSolutionNewArrayCopy(nums);
        return nums;
    }


    /**
     * 通过LC （3， 55.2）
     * 如果不保证奇数偶数相对位置不变，是对的
     * 不保证奇偶相对顺序稳定
     * 执行用时 :
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 69.40%
     * 的用户
     * 内存消耗 :
     * 56.7 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param array
     */
    private static void solutionSimplePartitionOnce(int[] array) {
        int oddRightIdx = -1;
        for (int i = 0; i < array.length; i++) {
            if (isOddNum(array[i])) {
                swap(array, i, ++oddRightIdx);
            }
        }
    }

    /**
     * 通过NK，LC（8，57）
     * 保证奇偶相对顺序稳定
     *
     * @param array
     */
    private static void stoSolutionSwap(int[] array) {
        int l = 0, r = array.length - 1;
        while (l < r) {
            if (isOddNum(array[l]) && isOddNum(array[r])) {
                l++;
            } else if (isOddNum(array[l]) && isEvenNum(array[r])) {
                l++;
                r--;
            } else if (isEvenNum(array[l]) && isOddNum(array[r])) {
                swap(array, l, r);
            } else if (isEvenNum(array[l]) && isEvenNum(array[r])) {
                r--;
            }
        }
    }


    /**
     * LC超时
     * 保证奇偶相对顺序稳定
     *
     * @param array
     */
    private static void cycSolutionBubble(int[] array) {
        // 冒泡思想
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (isEvenNum(array[j]) && isOddNum(array[j + 1])) {
                    swap(array, j, j + 1);
                }
            }
        }
    }


    private static boolean isOddNum(int num) {
        return num % 2 != 0;
    }

    private static boolean isEvenNum(int num) {
        return num % 2 == 0;
    }

    /**
     * 通过NK，LC（529， 57.1）
     * 保证奇偶相对顺序稳定
     *
     * @param array
     */
    private static void mySolutionPartition(int[] array) {
        int oddRightIdx = -1, evenLeftIdx = array.length;
        int l = 0;
        for (; l < evenLeftIdx; ) {
            if (array[l] % 2 == 1) {
                swap(array, l, ++oddRightIdx);
                l++;
            } else {
                // 放到末尾，之后的往前挪动一个
                int evenNum = array[l];
                for (int j = l; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = evenNum;
                // 偶数区左移 但是l不++
                evenLeftIdx--;
            }
        }
    }

    /**
     * FIXME   好像一个指针是不够的，停不下来
     */
/*    private static void stoSolutionSimpleSwap(int[] array) {
        //
        int l = 0;
        for (int i = 0; i < array.length; ) {
            if (array[i] % 2 == 1) {
                i++;
            }
            else {
                // 如果是偶数
                int evenNum = array[i];
                for (int j = i; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = evenNum;
                // 偶数不应该i++，挪动之后要接着判断i位置
            }
        }
    }*/
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        // 异或方法i不能等于j
/*        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];*/
    }
}
