package math;

/**
 * @author ShaneTang
 * @create 2021-01-16 10:24
 */
public class PreimageSizeFZF {

    public static void main(String[] args) {
        PreimageSizeFZF obj = new PreimageSizeFZF();
        long res = obj.preimageSizeFZF(100);
        System.out.println("res = " + res);
    }

    long preimageSizeFZF(int K) {
        // 左边界和右边界之差 + 1 就是答案
        return right_bound(K) - left_bound(K) + 1;
    }

    /* 搜索 trailingZeroes(n) == K 的左侧边界 */
    long left_bound(int target) {
        long lo = 0, hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) < target) {
                lo = mid + 1;
            } else if (trailingZeroes(mid) > target) {
                hi = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    /* 搜索 trailingZeroes(n) == K 的右侧边界 */
    long right_bound(int target) {
        long lo = 0, hi = Long.MAX_VALUE;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (trailingZeroes(mid) < target) {
                lo = mid + 1;
            } else if (trailingZeroes(mid) > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo - 1;
    }

    public long trailingZeroes(long x) {
        if (x == 0) return 0;
        return x / 5 + trailingZeroes(x / 5);
    }
}
