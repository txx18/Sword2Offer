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
    int k;

    /**
     * 通过LC
     *
     * @param root
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        recur(root);
        return res.val;
    }


    private void recur(TreeNode root) {
        if (root == null) {
            return;
        }
        // 先右后左
        recur(root.right);
        rank++;
        if (rank == k) {
            res = root;
            return;
        }
        recur(root.left);
    }

/*    private TreeNode recur(TreeNode root) {
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
    }*/
}
