package math;

/**
 * @author ShaneTang
 * @create 2021-03-10 21:01
 */
public class GCD {

    public int gcd(int a, int b) {
        // write code here
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static int GCD(int a, int b) {
        while (b != 0) {
            int mod = a % b;
            a = b;
            b = mod;
        }
        return a;
    }
}
