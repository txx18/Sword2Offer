package digit;

/**
 * @author ShaneTang
 * @create 2021-02-07 10:09
 */
public class AddNotUsePlus {

    public int recur(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return recur(num1 ^ num2, (num1 & num2) << 1);
    }

    public int loop(int num1, int num2) {
        int sum = 0;
        int carry = 0;
        while (num2 != 0) {
            // 1、不考虑进位，每一位相加
            sum = num1 ^ num2;
            // 2、考虑进位
            carry = (num1 & num2) << 1;
            // 3、相加
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }
}
