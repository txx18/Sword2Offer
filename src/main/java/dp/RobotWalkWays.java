package dp;

import java.util.Arrays;

/**
 * 机K器MP人算达法到扩指展定题位目置二方法数
 * 【题目】
 * 假设有排成一行的 N 个位置，记为 1~N，N 一定大于或等于 2。开始时机器人在其中的 M 位
 * 置上(M 一定是 1~N 中的一个)，机器人可以往左走或者往右走，如果机器人来到 1 位置， 那
 * 么下一步只能往右来到 2 位置;如果机器人来到 N 位置，那么下一步只能往左来到 N-1 位置。
 * 规定机器人必须走 K 步，最终能来到 P 位置(P 也一定是 1~N 中的一个)的方法有多少种。给
 * 定四个参数 N、M、K、P，返回方法数。
 * 【举例】
 * N=5,M=2,K=3,P=3
 * 上面的参数代表所有位置为 1 2 3 4 5。机器人最开始在 2 位置上，必须经过 3 步，最后到
 * 达 3 位置。走的方法只有如下 3 种: 1)从2到1，从1到2，从2到3 2)从2到3，从3到2，从2到3
 * 3)从2到3，从3到4，从4到3
 * 所以返回方法数 3。
 * <p>
 * N=3,M=1,K=3,P=3
 * 上面的参数代表所有位置为 1 2 3。机器人最开始在 1 位置上，必须经过 3 步，最后到达 3
 * 位置。怎么走也不可能，所以返回方法数 0。
 *
 * @author ShaneTang
 * @create 2021-03-04 14:51
 */
public class RobotWalkWays {

    public static void main(String[] args) {
        RobotWalkWays obj = new RobotWalkWays();
//        int res = obj.solutionRecurForce(5, 2, 3, 3);
        int res = obj.solutionRecurMemo(5, 2, 3, 3);
        System.out.println("res = " + res);
    }

    int N;
    int E;

    public int solutionRecurForce(int N, int S, int E, int K) {
        this.N = N;
        this.E = E;
        return recurForce(K, S);
    }

    private int recurForce(int rest, int cur) {
        // rest == 0停止点
        if (rest == 0) {
            return cur == E ? 1 : 0;
        }
        // 左端
        if (cur == 1) {
            return recurForce(rest - 1, 2);
        }
        // 右端
        if (cur == N) {
            return recurForce(rest - 1, N - 1);
        }
        // 中间位置
        return recurForce(rest - 1, cur - 1) + recurForce(rest - 1, cur + 1);
    }

    int[][] dpMemo;

    private int solutionRecurMemo(int N, int S, int E, int K) {
        this.N = N;
        this.E = E;
        dpMemo = new int[K + 1][N + 1];
        for (int i = 0; i <= K; i++) {
            Arrays.fill(dpMemo[i], -1);
        }
        return recurMemo(K, S);
    }

    private int recurMemo(int rest, int cur) {
        if (dpMemo[rest][cur] != -1) {
            return dpMemo[rest][cur];
        }
        // rest == 0停止点
        if (rest == 0) {
            dpMemo[rest][cur] = cur == E ? 1 : 0;
            return dpMemo[rest][cur];
        }
        // 左端
        if (cur == 1) {
            dpMemo[rest][cur] = recurForce(rest - 1, 2);
            return dpMemo[rest][cur];
        }
        // 右端
        if (cur == N) {
            dpMemo[rest][cur] = recurForce(rest - 1, N - 1);
            return dpMemo[rest][cur];
        }
        // 中间位置
        dpMemo[rest][cur] = recurForce(rest - 1, cur - 1) + recurForce(rest - 1, cur + 1);
        return dpMemo[rest][cur];
    }


}
