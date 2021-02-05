package array;

/**
 * @author ShaneTang
 * @create 2021-02-04 20:49
 */
public class FindMaxPeak {

    public int solve (int[] a) {
        // write code here
        for (int i = a.length - 1; i > 0; i--) {
            if (a[i - 1] < a[i]) {
                return i;
            }
        }
        return 0;
    }
}
