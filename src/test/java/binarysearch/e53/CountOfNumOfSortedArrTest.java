package binarysearch.e53;

import org.junit.Test;

public class CountOfNumOfSortedArrTest {

    int[] arr1 = {1, 2, 3, 3, 3, 3, 4, 6};
    int[] arr2 = {3, 5, 11, 17, 21, 23, 28, 28, 28, 28, 30, 32, 50, 64, 64, 78, 81, 95, 101};

    @Test
    public void getNumberOfK() {
        int cnt1 = CountOfNumOfSortedArr.GetNumberOfK(arr1, 3);
        System.out.println("cnt1 = " + cnt1);
        int cnt2 = CountOfNumOfSortedArr.GetNumberOfK(arr2, 28);
        System.out.println("cnt2 = " + cnt2);
    }


    @Test
    public void cycGetNumberOfK() {
        int count = CountOfNumOfSortedArr.cycGetNumberOfK(arr1, 4);
        System.out.println("count = " + count);
    }

    @Test
    public void solutionByTraverse() {
        int count = CountOfNumOfSortedArr.solutionByTraverse(arr1, 3);
        System.out.println("count = " + count);
    }

    @Test
    public void stoSolutionByBS() {
        int count1 = CountOfNumOfSortedArr.stoSolutionBSLoop(arr1, 3);
        System.out.println("count1 = " + count1);
        int count2 = CountOfNumOfSortedArr.stoSolutionBSLoop(arr2, 28);
        System.out.println("count2 = " + count2);
    }

    @Test
    public void jdkSolution() {
        int count = CountOfNumOfSortedArr.useJdkSolution(arr1, 3);
        System.out.println("count = " + count);
    }


}