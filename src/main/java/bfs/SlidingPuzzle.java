package bfs;

import sun.font.FontRunIterator;

import java.util.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示.
 * <p>
 * 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 * <p>
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * <p>
 * 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 * <p>
 * 示例：
 * <p>
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 * 输入：board = [[1,2,3],[5,4,0]]
 * 输出：-1
 * 解释：没有办法完成谜板
 * 输入：board = [[4,1,2],[5,0,3]]
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: [[4,1,2],[5,0,3]]
 * 移动 1 次: [[4,1,2],[0,5,3]]
 * 移动 2 次: [[0,1,2],[4,5,3]]
 * 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]]
 * 移动 5 次: [[1,2,3],[4,5,0]]
 * 输入：board = [[3,2,4],[1,5,0]]
 * 输出：14
 * 提示：
 * <p>
 * board 是一个如上所述的 2 x 3 的数组.
 * board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-puzzle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ShaneTang
 * @create 2021-01-14 21:56
 */
public class SlidingPuzzle {

    public static void main(String[] args) {
        SlidingPuzzle obj = new SlidingPuzzle();
//        int res = obj.slidingPuzzle(new int[][]{{1, 2, 3}, {5, 4, 0}});
        int res = obj.slidingPuzzle(new int[][]{{4, 1, 2}, {5, 0, 3}});
        System.out.println("res = " + res);
    }

    final char HOLE = '0';
    final String TARGET = "123450";

    public int slidingPuzzle(int[][] board) {
        int m = 2, n = 3;
        String start = "";
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start += board[i][j];
            }
        }
        // 邻居的下标，对于一个2*3来说是固定的
        int[][] neighbor = {
                {1, 3},
                {0, 4, 2},
                {1, 5},
                {0, 4},
                {3, 1, 5},
                {4, 2}};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (TARGET.equals(cur)) {
                    return step;
                }
                if (cur == null) {
                    continue;
                }
                int holeIndex = cur.indexOf(HOLE);
                for (int adjIndex : neighbor[holeIndex]) {
                    // 这个地方并没有修改cur也无法修改
                    String nextBoard = swap(cur, adjIndex, holeIndex);
                    if (!visited.contains(nextBoard)) {
                        queue.offer(nextBoard);
                        visited.add(nextBoard);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    /**
     * 交换字符串中的两个字符
     * @param str
     * @param i
     * @param j
     * @return
     */
    private String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        return new String(chars);
    }


}
