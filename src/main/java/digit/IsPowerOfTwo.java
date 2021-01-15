package digit;

/**
 * @author ShaneTang
 * @create 2021-01-15 21:00
 */
public class IsPowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0;
    }
}
