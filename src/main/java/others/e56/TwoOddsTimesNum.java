package others.e56;

/**
 *  一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-18 10:52
 */
public class TwoOddsTimesNum {

    public int[] singleNumbers(int[] nums) {
        return solutionEOR(nums);
    }

    /**
     * 只有两个出现奇数次，其余出现偶数次
     * 执行用时 :
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 48.2 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param arr2
     * @return
     */
    public static int[] solutionEOR(int[] arr2) {
        // 找到全体异或结果
        int eor = 0;
        for (int value : arr2) {
            eor ^= value;
        }
        // 因为他俩不同，所以必有一位为1
        // 找到他俩从右开始第一个为不同的1位
        // 设置一个除了那个1，其余位置零的数rightOne，也就是eor取反加一再相与
        int rightOne = eor & (~eor + 1);
        // 遍历数组
        int eor0 = 0;
        for (int value : arr2) {
            // 只让该位为0的数 异或 value
            if ((value & rightOne) == 0) {
                eor0 ^= value;
            }
        }
        // 这俩数一个是eor，一个是eor^eor0
        return new int[]{eor0, (eor ^ eor0)};
    }
}
