package tree.treedp;

import zhelper.TreeUtils.*;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-09 23:47
 */
public class MaxDepthDPE5501 {


    public int maxDepth(TreeNode root) {
//        return solution(root);
        return solutionDP(root);
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 39.2 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param root
     * @return
     */
    private int solutionDP(TreeNode root) {
/*        Info info = recur(root);
        return info.height;*/
        return recur(root);
    }

    private int recur(TreeNode x) {
        if (x == null) {
//            return new Info(0);
            return 0;
        }
        int leftHeight = recur(x.left);
        int rightHeight = recur(x.right);
        //        return new Info(maxDepth);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private class Info{
        int height;

        public Info(int height) {
            this.height = height;
        }
    }

    int res = Integer.MIN_VALUE;
    int curDepth = 0;

    private int solution(TreeNode root) {
        if (root == null) {
            return Math.max(res, curDepth);
        }
        curDepth++;
        solution(root.left);
        solution(root.right);
        return Math.max(res, curDepth);
    }
}
