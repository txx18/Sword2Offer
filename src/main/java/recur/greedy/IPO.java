package recur.greedy;

import java.util.*;

/**
 * 假设 力扣（LeetCode）即将开始其 IPO。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
 * <p>
 * 给定若干个项目。对于每个项目 i，它都有一个纯利润 Pi，并且需要最小的资本 Ci 来启动相应的项目。最初，你有 W 资本。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
 * <p>
 * 总而言之，从给定项目中选择最多 k 个不同项目的列表，以最大化最终资本，并输出最终可获得的最多资本。
 * <p>
 * 示例 1:
 * <p>
 * 输入: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].
 * <p>
 * 输出: 4
 * <p>
 * 解释:
 * 由于你的初始资本为 0，你尽可以从 0 号项目开始。
 * 在完成后，你将获得 1 的利润，你的总资本将变为 1。
 * 此时你可以选择开始 1 号或 2 号项目。
 * 由于你最多可以选择两个项目，所以你需要完成 2 号项目以获得最大的资本。
 * 因此，输出最后最大化的资本，为 0 + 1 + 3 = 4。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ipo
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-08 16:03
 */
public class IPO {

    public static void main(String[] args) {
        int[] capital = {0, 1, 1};
//        int[] capital = {1, 1, 2, 2, 3, 4};
        int[] profits = {1, 2, 3};
//        int[] profits = {1, 4, 3, 7, 2, 10};
        int k = 2;
        int w = 0;
        IPO obj = new IPO();

        int res = obj.solution2DArray(capital, profits, k, w);
        System.out.println("res = " + res);
    }

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
//        return solution2DArray(Capital, Profits, k, W);
        return solutionClass(Capital, Profits, k, W);
//        return findMaximizedCapitalZS(k, W, Profits, Capital);
    }

    /**
     * 执行用时 :
     * 44 ms
     * , 在所有 Java 提交中击败了
     * 39.69%
     * 的用户
     * 内存消耗 :
     * 45.6 MB
     * , 在所有 Java 提交中击败了
     * 64.76%
     * 的用户
     * @param capital
     * @param profits
     * @param k
     * @param w
     * @return
     */
    private int solutionClass(int[] capital, int[] profits, int k, int w) {
        // 把成本和利润绑定Project
        PriorityQueue<Project> SPQ = new PriorityQueue<Project>(capital.length, new ProjectCapitalComparator<Project>());
        for (int i = 0; i < capital.length; i++) {
            SPQ.add(new Project(capital[i], profits[i]));
        }
        // 准备一个大根堆
        PriorityQueue<Project> BPQ = new PriorityQueue<Project>(new ProjectProfitComparator<Project>());
        int projectCount = 0;
        // 循环
        while (!SPQ.isEmpty() || !BPQ.isEmpty()) {
            if (projectCount == k) {
                break;
            }
            // 取出小根堆中<=资本的的成本，把相应利润放进大根堆
            while (!SPQ.isEmpty() && SPQ.peek().capital <= w) {
                BPQ.offer(SPQ.poll());
            }
            // 取出大根堆中最大的一个利润，计算目前资本
            if (BPQ.isEmpty()) {
                break;
            }
            Project chooseProject = BPQ.poll();
            projectCount++;
            // 成本吃进去了最后回本，净赚利润，不用减成本
            w += chooseProject.profit;
        }
        return w;
    }

    /**
     * 执行用时 :
     * 79 ms
     * , 在所有 Java 提交中击败了
     * 21.37%
     * 的用户
     * 内存消耗 :
     * 45.3 MB
     * , 在所有 Java 提交中击败了
     * 70.48%
     * 的用户
     * @param k
     * @param W
     * @param Profits
     * @param Capital
     * @return
     */
    public static int findMaximizedCapitalZS(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());
        // 所有项目扔到被锁池中, 花费组织的小根堆
        for (int i = 0; i < Profits.length; i++) {
            minCostQ.add(new Node(Profits[i], Capital[i]));
        }
        for (int i = 0; i < k; i++) { // 进行K轮
            // 能力所及的项目，全解锁
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= W) {
                maxProfitQ.add(minCostQ.poll());
            }
            if (maxProfitQ.isEmpty()) {
                return W;
            }
            W += maxProfitQ.poll().p;
        }
        return W;
    }

    private static class Node {
        public int p;
        public int c;

        public Node(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static class MinCostComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;
        }

    }

    public static class MaxProfitComparator implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;
        }

    }



    /**
     * 执行用时 :
     * 69 ms
     * , 在所有 Java 提交中击败了
     * 24.43%
     * 的用户
     * 内存消耗 :
     * 48.7 MB
     * , 在所有 Java 提交中击败了
     * 5.71%
     * 的用户
     * @param capital
     * @param profits
     * @param k
     * @param w
     * @return
     */
    private int solution2DArray(int[] capital, int[] profits, int k, int w) {
        if (capital == null || capital.length == 0 || profits == null || profits.length == 0) {
            return 0;
        }
        // 把成本和利润绑定成二维数组
        Integer[][] projects = bind(capital, profits);

        // 先把项目放进小根堆
        PriorityQueue<Integer[]> SPQ = new PriorityQueue<>(projects.length, new CapitalComparator<Integer[]>());
        SPQ.addAll(Arrays.asList(projects));
        // 准备一个大根堆
        PriorityQueue<Integer[]> BPQ = new PriorityQueue<>(new ProfitComparator<Integer[]>());
        int projectCount = 0;
        // 循环
        while (!SPQ.isEmpty() || !BPQ.isEmpty()) {
            if (projectCount == k) {
                break;
            }
            // 取出小根堆中<=资本的的成本，记住index，把相应利润放进大根堆
            while (!SPQ.isEmpty() && SPQ.peek()[0] <= w) {
                Integer[] cur = SPQ.poll();
                BPQ.offer(cur);
            }
            // 取出大根堆中最大的一个利润，计算目前资本
            if (BPQ.isEmpty()) {
                break;
            }
            Integer[] chooseProject = BPQ.poll();
            projectCount++;
            // 成本吃进去了最后回本，净赚利润，不用减成本
            w = w + chooseProject[1];
        }
        return w;
    }

    private Integer[][] bind(int[] capital, int[] profits) {
        Integer[][] bind = new Integer[capital.length][2];
        for (int i = 0; i < capital.length; i++) {
            bind[i][0] = capital[i];
            bind[i][1] = profits[i];
        }
        return bind;
    }

    private class Project {
        int capital;
        int profit;

        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    private class ProfitComparator<T> implements Comparator<Integer[]> {
        @Override
        public int compare(Integer[] o1, Integer[] o2) {
            return o2[1] - o1[1];
        }
    }

    private class CapitalComparator<T> implements Comparator<Integer[]> {
        @Override
        public int compare(Integer[] o1, Integer[] o2) {
            return o1[0] - o2[0];
        }
    }

    private class ProjectCapitalComparator<T> implements Comparator<Project> {

        @Override
        public int compare(Project o1, Project o2) {
            return o1.capital - o2.capital;
        }
    }

    private class ProjectProfitComparator<T> implements Comparator<Project> {
        @Override
        public int compare(Project o1, Project o2) {
            return o2.profit - o1.profit;
        }
    }
}
