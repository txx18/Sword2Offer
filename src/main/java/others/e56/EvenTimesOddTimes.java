package others.e56;

/**
 * @author Shane Tang
 * @version V1.0
 * @Description 数组中数字出现的次数
 * @create 2020-02-05 13:08
 */
public class EvenTimesOddTimes {

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

    /**
     * 只有两个出现奇数次，其余出现偶数次
     * @param arr2
     * @return
     */
    public static int[] findTheTwoOddTimesNum(int[] arr2) {
        // 找到全体异或结果
        int eor = 0;
        for (int value : arr2) {
            eor ^= value;
        }
        // 因为他俩不同，所以必有一位为1
        // 找到他俩从右开始第一个为不同的1位
        // 设置一个除了那个1，其余位置零的数rightOne，也就是eor取反加一再相与
        int rightOne = eor & (~eor + 1);
        // 遍历数组，只让该位是1（或者0）的元素异或rightOne
        int eor0 = 0;
        for (int value : arr2) {
            if ((value & rightOne) == 0) {
                eor0 ^= value;
            }
        }
        // 这俩数一个是eor，一个是eor^eor0
        return new int[]{eor0, (eor ^ eor0)};
    }

    /**
     * 只有一个出现1次，其余出现3次
     * @param arr3
     * @return
     */
    public static int findTheOnlyOneTimeNum(int[] arr3) {
        return 0;
    }


}
