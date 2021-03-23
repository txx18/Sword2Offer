package zhelper;

import binarysearch.NumCountOfSortedArray;

import static zhelper.ArrayUtils.*;


/**
 * @author Shane Tang
 * @version V1.0
 * @Description
 * @create 2020-02-04 12:23
 */
public class ReturnIntTestHelper {

    private static int solution(int[] arr) {
        return NumCountOfSortedArray.solutionBSRecurME(arr, 1);
    }

    // for test
    public static int comparator(int[] arr) {
        NumCountOfSortedArray obj = new NumCountOfSortedArray();
        return obj.solutionBSLoop(arr, 1);
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int solution = solution(arr1);
            int comparator = comparator(arr2);
            if (solution != comparator) {
                succeed = false;
                System.out.print("测试数组：");
                printArray(arr1);
                System.out.println("solution = " + solution);
                System.out.println("comparator = " + comparator);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        // 一次实验展示
        if (succeed) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            System.out.println("arr2.length = " + arr2.length);
            printArray(arr1);
            int solution = solution(arr1);
            System.out.println("solution = " + solution);
            int comparator = comparator(arr2);
            System.out.println("comparator = " + comparator);
        }
    }

}
