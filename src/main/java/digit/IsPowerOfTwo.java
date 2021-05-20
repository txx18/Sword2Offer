package digit;

/**
 * @author ShaneTang
 * @create 2021-01-15 21:00
 */
public class IsPowerOfTwo {

    public static void main(String[] args) {
        IsPowerOfTwo obj = new IsPowerOfTwo();
        boolean res = obj.solutionGetRightOne(-2147483648);
        System.out.println("res = " + res);
    }

    public boolean solutionGetRightOne(int n) {
        if (n <= 0) {
            return false;
        }
        long x = (long) n;
        long res = x & (-x);
        return res == x;
    }

    public boolean solutionRemoveRightOne(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
