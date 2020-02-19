package binarysearch.e53;

import org.junit.Test;

public class MissingNumberTest {

    @Test
    public void getNotAppearNum() {
        int[] arr1 = {0, 1, 2, 3, 4, 5, 6, 8, 9};
        int[] arr2 = {0, 1, 2, 4, 5, 6, 7, 8, 9};
        int[] arr3 = {0, 1, 2, 3, 4, 6, 7, 8, 9};
//        int notAppearNum = NotAppearNum.solutionByTraverse(arr);
//        int notAppearNum = NotAppearNum.solutionByBinarySearch(arr2);
        int notAppearNum = MissingNumber.stoSolutionBS(arr3);
        System.out.println("notAppearNum = " + notAppearNum);
    }

    @Test
    public void stoTest()
    {
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
        Test6();

    }

    // ====================测试代码====================
    void Test(String testName, int[] numbers, int expected)
    {
        if(testName != null)
            System.out.printf("%s begins: ", testName);

        int result = MissingNumber.stoSolutionBS(numbers);
        if(result == expected)
            System.out.printf("Passed.\n");
        else
            System.out.printf("Failed.\n");
    }

    // 缺失的是第一个数字0
    void Test1()
    {
        int numbers[] = { 1, 2, 3, 4, 5 };
        int expected = 0;
        Test("Test1", numbers, expected);
    }

    // 缺失的是最后一个数字
    void Test2()
    {
        int numbers[] = { 0, 1, 2, 3, 4 };
        int expected = 5;
        Test("Test2", numbers, expected);
    }

    // 缺失的是中间某个数字0
    void Test3()
    {
        int numbers[] = { 0, 1, 2, 4, 5 };
        int expected = 3;
        Test("Test3", numbers, expected);
    }

    // 数组中只有一个数字，缺失的是第一个数字0
    void Test4()
    {
        int numbers[] = { 1 };
        int expected = 0;
        Test("Test4", numbers, expected);
    }

    // 数组中只有一个数字，缺失的是最后一个数字1
    void Test5()
    {
        int numbers[] = { 0 };
        int expected = 1;
        Test("Test5", numbers, expected);
    }

    // 空数组
    void Test6()
    {
        int expected = -1;
        Test("Test6", null, expected);
    }


}