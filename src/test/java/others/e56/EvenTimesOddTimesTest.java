package others.e56;

import org.junit.Test;
import zhelper.ArrayUtils;

import java.util.Arrays;

public class EvenTimesOddTimesTest {

    @Test
    public void findTheOnlyOddTimesNum() {
        int[] arr1 = {3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1};
        int res1 = EvenTimesOddTimes.findTheOnlyOddTimesNum(arr1);
        System.out.println("res1 = " + res1);
    }

    @Test
    public void findTheTwoOddTimesNum() {
        int[] arr2 = {4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2};
        ArrayUtils.printArray(arr2);
        int[] res2 = EvenTimesOddTimes.findTheTwoOddTimesNum(arr2);
        System.out.println(Arrays.toString(res2));
    }

    /**
     * TODO
     */
    @Test
    public void findTheOnlyOneTimeNum() {
        int[] arr3 = { 1024, -1025, 1024, -1025, 1024, -1025, 1023 };
        int res3 = EvenTimesOddTimes.findTheOnlyOneTimeNum(arr3);
        System.out.println("res3 = " + res3);
    }
}