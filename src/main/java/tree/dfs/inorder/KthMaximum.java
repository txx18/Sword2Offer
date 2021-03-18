package tree.dfs.inorder;

import zhelper.TreeUtils;
import zhelper.TreeUtils.*;

/**
 * @author ShaneTang
 * @create 2021-03-18 9:12
 */
public class KthMaximum {

    int rank;
    TreeNode res = null;

    /**
     * 通过LC
     *
     * @param root
     * @return
     */
    public int kthLargestLC(TreeNode root, int k) {
        rank = k;
        return recur(root).val;
    }


    private TreeNode recur(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 先右后左
        recur(root.right);
        if (rank == 1) {
            res = root;
            rank--; // 注意
            return res;
        }
        rank--;
        recur(root.left);
        return res;
    }
}
