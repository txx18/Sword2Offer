package zhelper;


import sort.MyQuickSortV3;

import java.util.Arrays;

import static zhelper.ArrayUtils.*;

/**
 * 对数器
 *
 * @author Shane Tang
 * @create 2019-09-16 20:31
 */
public class ArrayTestHelper {

    private static void solution(int[] arr) {
        MyQuickSortV3.solution(arr);
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
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
            solution(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                System.out.print("solution  ：");
                printArray(arr1);
                System.out.print("comparator：");
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
        if (succeed) {
            // 一次实验展示
            int[] arr = generateRandomArray(maxSize, maxValue);
            System.out.println("一次成功实验展示:");
            System.out.print("生成：");
            printArray(arr);
            solution(arr);
            System.out.print("测试：");
            printArray(arr);
        }
    }
}
