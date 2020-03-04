package others;

/**
 *
 * TODO 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-18 11:11
 */
public class OtherNum3TimesE5601 {

    public static void main(String[] args) {
        int[] arr1 = {3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1};
        int[] arr2 = {4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2};
        int[] arr3 = { 1024, -1025, 1024, -1025, 1024, -1025, 1023 };
        int res = singleNumber(arr1);
        System.out.println("res = " + res);
    }

    public static int singleNumber(int[] nums) {
        return solutionEOR(nums);
    }

    private static int solutionEOR(int[] nums) {
        return 0;
    }
}
