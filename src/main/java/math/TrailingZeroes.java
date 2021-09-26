package math;

/**
 * @author ShaneTang
 * @create 2021-01-16 10:32
 */
public class TrailingZeroes {

    public static void main(String[] args) {
        TrailingZeroes obj = new TrailingZeroes();
        int input = Integer.MAX_VALUE;
        int res = obj.trailingZeroes(input);
        System.out.println("res = " + res);
    }

    public int trailingZeroes(int n) {
        if (n == 0) return 0;
        return n / 5 + trailingZeroes(n / 5);
    }

    int trailingZeroes1(int n) {
        int res = 0;
        for (int d = n; d / 5 > 0; d = d / 5) {
            res += d / 5;
        }
        return res;
    }

    int trailingZeroes2(int n) {
        int res = 0;
        long divisor = 5;
        while (divisor <= n) {
            res += n / divisor;
            divisor *= 5;
        }
        return res;
    }
}
