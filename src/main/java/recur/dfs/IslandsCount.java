package recur.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-25 20:26
 */
public class IslandsCount {

    public static void main(String[] args) {
        IslandsCount obj = new IslandsCount();
        int[][] m1 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
//        System.out.println(obj.numIslands(m1));
//        System.out.println(obj.islandElementCountList.toString());

        IslandsCount obj2 = new IslandsCount();
        int[][] m2 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 1, 1, 0, 0, 0, 1, 1, 0},
                {0, 0, 0, 0, 0, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},};
//        System.out.println(obj2.numIslands(m2));
//        System.out.println(obj2.islandElementCountList.toString());

    }

    //    int elementCount;
//    List<Integer> islandElementCountList = new ArrayList<>();

    char[][] grid;
    int islandCount;
    boolean[][] visited;


    /**
     * 通过LC
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.visited = new boolean[grid.length][grid[0].length];
        // 遍历每一个元素
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 碰到 1 就开始深度优先搜索
                if (grid[i][j] == '1' && !visited[i][j]) {
//                    elementCount = 0;
                    islandCount++;
//                    dfs(i, j);
                    bfs(i, j);
//                    islandElementCountList.add(elementCount);
                }
            }
        }
        return islandCount;
    }

    /**
     * 通过LC
     *
     * @param i
     * @param j
     */
    private void dfs(int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[i].length) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        /*// 【关键】新遇到的1改成2
        grid[i][j] = '2';*/
//        elementCount++;
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }

    /**
     * 通过LC
     *
     * @param i
     * @param j
     */
    private void bfs(int i, int j) {
        Queue<String> queue = new LinkedList<>();
        queue.add(i + "-" + j);
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            int[] coord = getCoord(poll);
            for (int[] adj : adj(coord[0], coord[1])) {
                if (adj[0] < 0 || adj[0] == grid.length || adj[1] < 0 || adj[1] == grid[i].length) {
                    continue;
                }
                if (visited[adj[0]][adj[1]]) {
                    continue;
                }
                if (grid[adj[0]][adj[1]] != '1') {
                    continue;
                }
                queue.add(adj[0] + "-" + adj[1]);
                visited[adj[0]][adj[1]] = true;
            }
        }
    }

    private int[][] adj(int i, int j) {
        return new int[][]{{i - 1, j}, {(i + 1), j}, {i, j - 1}, {i, j + 1}};
    }

    private int[] getCoord(String str) {
        String[] split = str.split("-");
        return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])};
    }

}
