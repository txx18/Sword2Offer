package digit;

/**
 * @author ShaneTang
 * @create 2021-02-07 10:09
 */
public class AddNotUsePlus {

    public int solutionRecur(int a, int b) {
        if (b == 0) {
            return a;
        }
        return solutionRecur(a ^ b, (a & b) << 1);
    }

    public int solutionLoop(int a, int b) {
        int sum = 0;
        int carry = 0;
        while (b != 0) {
            // 1、不考虑进位，每一位相加
            sum = a ^ b;
            // 2、只考虑进位
            carry = (a & b) << 1;
            // 3、相加
            a = sum;
            b = carry;
        }
        return a;
    }
}
