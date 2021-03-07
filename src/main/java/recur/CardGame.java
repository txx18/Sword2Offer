package recur;

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
        int res = obj.solution(arr1);
        System.out.println("res = " + res);
    }


    private int solution(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        // 返回先手情况和后手情况的最大值
        return Math.max(
                pre(A, 0, A.length - 1),
                post(A, 0, A.length - 1)
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
    private int pre(int[] arr, int l, int r) {
        // base case 只剩一张牌，拿走
        if (l == r) {
            return arr[l];
        }
        // 先手获得的总收益有两部分 （1）先手拿走的牌 （2）后手的决策
        // 先手拿左和拿右是两种情况，用或连接
        return Math.max(
                arr[l] + post(arr, l + 1, r),
                arr[r] + post(arr, l, r - 1)
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
    private int post(int[] arr, int l, int r) {
        // base case 只剩一张牌，没牌了
        if (l == r) {
            return 0;
        }
        // 后手受先手控制，先手会把最小值留给后手
        // 先手拿左和拿右是两种情况，用或连接
        return Math.min(
                pre(arr, l + 1, r),
                pre(arr, l, r - 1)
        );
    }

}
