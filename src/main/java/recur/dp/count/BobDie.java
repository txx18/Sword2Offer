package recur.dp.count;

/**
 * Bob的生存概率
 * 【题目】
 * 给定五个参数n,m,i,j,k。表示在一个N*M的区域，Bob处在(i,j)点，每次Bob等概率的向上、
 * 下、左、右四个方向移动一步，Bob必须走K步。如果走完之后，Bob还停留在这个区域上，
 * 就算Bob存活，否则就算Bob死亡。请求解Bob的生存概率，返回字符串表示分数的方式。
 *
 * @author ShaneTang
 * @create 2021-03-11 21:21
 */
public class BobDie {

    public static void main(String[] args) {
        int N = 10;
        int M = 10;
        int i = 3;
        int j = 2;
        int K = 5;
        BobDie obj = new BobDie();
        System.out.println(obj.bob1(N, M, i, j, K));
//        System.out.println(obj.bob2(N, M, i, j, K));
    }

    public String bob1(int N, int M, int i, int j, int K) {
        this.N = N;
        this.M = M;
        long all = (long) Math.pow(4, K);
        long live = dp(i, j, K);
        long gcd = gcd(all, live);
        return String.valueOf((live / gcd) + "/" + (all / gcd));
    }

    int N;
    int M;

    public long dp(int row, int col, int rest) {
        if (row < 0 || row == N || col < 0 || col == M) {
            return 0;
        }
        if (rest == 0) {
            return 1;
        }
        return dp(row, col - 1, rest - 1) +
                dp(row - 1, col, rest - 1) +
                dp(row, col + 1, rest - 1) +
                dp(row + 1, col, rest - 1);
    }


    public static long gcd(long m, long n) {
        return n == 0 ? m : gcd(n, m % n);
    }
}
