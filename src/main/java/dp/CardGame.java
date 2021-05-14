package dp;

/**
 * 给定一个整型数组arr，代表数值不同的纸牌排成一条线。玩家A和玩家B依次拿走每张纸
 * 牌，规定玩家A先拿，玩家B后拿，但是每个玩家每次只能拿走最左或最右的纸牌，玩家A
 * 和玩家B都绝顶聪明。请返回最后获胜者的分数。
 * <p>
 * 【举例】
 * arr=[1,2,100,4]。
 * 开始时，玩家A只能拿走1或4。如果开始时玩家A拿走1，则排列变为[2,100,4]，接下来
 * 玩家 B可以拿走2或4，然后继续轮到玩家A...
 * 如果开始时玩家A拿走4，则排列变为[1,2,100]，接下来玩家B可以拿走1或100，然后继
 * 续轮到玩家A...
 * 玩家A作为绝顶聪明的人不会先拿4，因为拿4之后，玩家B将拿走100。所以玩家A会先拿1，
 * 让排列变为[2,100,4]，接下来玩家B不管怎么选，100都会被玩家 A拿走。玩家A会获胜，
 * 分数为101。所以返回101。
 * arr=[1,100,2]。
 * 开始时，玩家A不管拿1还是2，玩家B作为绝顶聪明的人，都会把100拿走。玩家B会获胜，
 * 分数为100。所以返回100。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-18 17:28
 */
public class CardGame {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 100, 4};

        CardGame obj = new CardGame();
        int res = obj.solutionRecur(arr1);
        System.out.println("res = " + res);
    }

    /**
     * NK超时
     * @param A
     * @return
     */
    private int solutionRecur(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        // 返回先手情况和后手情况的最大值
        return Math.max(
                first(A, 0, A.length - 1),
                second(A, 0, A.length - 1)
        );
    }

    /**
     * 先手情况
     * 在 [l, r]范围上尝试
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private int first(int[] arr, int l, int r) {
        // base case 只剩一张牌，拿走
        if (l == r) {
            return arr[l];
        }
        // 先手获得的总收益有两部分 （1）先手拿走的牌 （2）后手的决策
        // 先手拿左和拿右是两种情况，用或连接
        return Math.max(
                arr[l] + second(arr, l + 1, r),
                arr[r] + second(arr, l, r - 1)
        );
    }

    /**
     * 后手情况
     * 在 [l, r]范围上尝试
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private int second(int[] arr, int l, int r) {
        // base case 只剩一张牌，没牌了
        if (l == r) {
            return 0;
        }
        // 后手受先手控制，先手会把最小值留给后手
        // 先手拿左和拿右是两种情况，用或连接
        return Math.min(
                first(arr, l + 1, r),
                first(arr, l, r - 1)
        );
    }


    /**
     * 通过NK
     * @param A
     * @return
     */
    private int solutionDpTable(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int N = A.length;
        int[][] first = new int[N][N];
        int[][] second = new int[N][N];
        for (int i = 0; i < N; i++) {
            first[i][i] = A[i];
        }
/*        for (int i = 0; i < r; i++) {
            second[i][i] = 0;
        }*/
        // 集中体现了，遍历顺序是根据暴力递归的依赖来的
        for (int i = 1; i < N; i++) {
            int l = 0;
            int r = i;
            // 填对角线右上方的斜线，从左上到右下
            while (l < N && r < N) {
                first[l][r] = Math.max(
                        A[l] + second[l + 1][r],
                        A[r] + second[l][r - 1]
                );
                second[l][r] = Math.min(
                        first[l + 1][r],
                        first[l][r - 1]
                );
                l++;
                r++;
            }

        }
        return Math.max(first[0][N - 1], second[0][N - 1]);
    }
}
