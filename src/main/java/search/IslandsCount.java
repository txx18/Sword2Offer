package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-25 20:26
 */
public class IslandsCount {

    public static void main(String[] args) {
        IslandsCount obj = new IslandsCount();
        int[][] m1 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 0, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(obj.numIslands(m1));
        System.out.println(obj.islandElementCountList.toString());

        IslandsCount obj2 = new IslandsCount();
        int[][] m2 = {  { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
                { 0, 1, 1, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
        System.out.println(obj2.numIslands(m2));
        System.out.println(obj2.islandElementCountList.toString());

    }

    int[][] grid;
    int islandCount;
    final int ISLANDELEMENT = 1;
    final int WATERELEMENT = 0;
    final int OTHERELEMENT = 2;
    int elementCount;
    List<Integer> islandElementCountList = new ArrayList<>();

    /**
     *
     * 时间复杂度：O(N*M)
     *
     * 执行用时 :
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 94.63%
     * 的用户
     * 内存消耗 :
     * 42.1 MB
     * , 在所有 Java 提交中击败了
     * 5.02%
     * 的用户
     * @param grid
     * @return
     */
    public int numIslands(int[][] grid) {
        this.grid = grid;
        // 遍历每一个元素
        for (int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                // 碰到ISLANDELEMENT就开始深度优先搜索
                if(grid[i][j] == ISLANDELEMENT) {
                    elementCount = 0;
                    islandCount++;
                    dfs(i, j);
                    islandElementCountList.add(elementCount);
                }
            }
        }
        return islandCount;
    }

    private void dfs(int i, int j) {
        // base case
        if(i < 0 || i > grid.length - 1 || j < 0 || j > grid[i].length - 1 || grid[i][j] != ISLANDELEMENT) {
            return;
        }
        // 【关键】新遇到的1改成2
        grid[i][j] = OTHERELEMENT;
        elementCount++;
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }

}
