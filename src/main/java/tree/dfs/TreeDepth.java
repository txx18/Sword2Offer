package tree.dfs;


import zhelper.TreeUtils.*;

/**
 * @author ShaneTang
 * @create 2021-02-05 23:18
 */
public class TreeDepth {

    int res;
    int curDepth;

    /**
     * 通过LC
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return res;
        }
        curDepth++;
        if (root.left == null && root.right == null) {
            if (curDepth > res) {
                res = curDepth;
            }
        }
        TreeDepth(root.left);
        TreeDepth(root.right);
        curDepth--;
        return res;
    }

    public int TreeDepthRecur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
}
