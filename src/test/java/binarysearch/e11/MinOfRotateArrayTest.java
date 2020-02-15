package binarysearch.e11;

import org.junit.Test;

/**
 * 旋转数组的最小数字
 *
 * @author Shane Tang
 * @create 2019-10-07 23:45
 */
public class MinOfRotateArrayTest {


    int[] rotateArr = {21,23,28,30,32,50,64,78,81,95,101,3,5,11,17};
    int[] rotateArr1 = {3,5,11,17,21,23,28,30,32,50,64,78,81,95,101,2};
    // {0, 1, 1, 1, 1}
    int[] rotateArr2 = {1, 0, 1, 1, 1};
    int[] rotateArr3 = {1, 1, 1, 0, 1};

    @Test
    public void minNumberInRotateArray() {
        int minNumberInRotateArray = MinOfRotateArray.minNumberInRotateArray(rotateArr1);
        System.out.println("minNumberInRotateArray = " + minNumberInRotateArray);
    }


    @Test
    public void  testGetSmallestNumByLoop(){
        int smallestNum = MinOfRotateArray.getSmallestNumByLoop(rotateArr);
        System.out.println("smallestNum = " + smallestNum);
    }


}
