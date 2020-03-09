package greedy;

import java.util.PriorityQueue;

/**
 * 一块金条切成两半，是需要花费和长度数值一样的铜板的。比如长度为20的金
 * 条，不管切成长度多大的两半，都要花费20个铜板。
 * 一群人想整分整块金条，怎么分最省铜板?
 * 例如,给定数组{10,20,30}，代表一共三个人，整块金条长度为10+20+30=60。
 * 金条要分成10,20,30三个部分。 如果先把长度60的金条分成10和50，花费60；
 * 再把长度50的金条分成20和30，花费50；一共花费110铜板。
 * 但是如果先把长度60的金条分成30和30，花费60；再把长度30金条分成10和20，
 * 花费30；一共花费90铜板。
 * 输入一个数组，返回分割的最小代价。
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-08 15:18
 */
public class LeastMoneySplitGold {

    public static void main(String[] args) {
        int[] needArr = {10};
        LeastMoneySplitGold obj = new LeastMoneySplitGold();

        int sum = obj.solution(needArr);
        System.out.println("sum = " + sum);
    }

    private int solution(int[] needArr) {
        if (needArr == null || needArr.length == 0) {
            return 0;
        }
        // 准备一个小根堆，把需求的元素放进去
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int ele : needArr) {
            priorityQueue.offer(ele);
        }
        int res = 0;
        // 循环
        while (priorityQueue.size() > 1){
            // 每次取出最小的两个数，并且把它们的和累加到res，重新放进小根堆
            int tmp = priorityQueue.poll() + priorityQueue.poll();
            res += tmp;
            priorityQueue.offer(tmp);
        }
        return res;
    }
}
