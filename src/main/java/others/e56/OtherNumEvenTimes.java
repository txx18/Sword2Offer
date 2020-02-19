package others.e56;

/**
 *
 * @author Shane Tang
 * @version V1.0
 * @Description 数组中数字出现的次数
 * @create 2020-02-05 13:08
 */
public class OtherNumEvenTimes {

    /**
     * 只有一个出现奇数次，其余出现偶数次
     * @param arr1
     * @return
     */
    public static int findTheOnlyOddTimesNum(int[] arr1) {
        int eor = 0;
        for (int i = 0; i < arr1.length; i++) {
            eor ^= arr1[i];
        }
        return eor;
    }


}
