package tree.dfs.postorder;

import zhelper.TreeUtils.*;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-03 22:59
 */
public class LCA {

    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // write code here
        return dfsPost(root, o1, o2).val;
    }

    private TreeNode dfsPost(TreeNode root, int o1, int o2) {
        // write code here
        if (root == null || root.val == o1 || root.val == o2) {
            return root;
        }
        TreeNode left = dfsPost(root.left, o1, o2);
        TreeNode right = dfsPost(root.right, o1, o2);
        // 如果都不为null（互为祖先的情况）
        if (left != null && right != null) {
            return root;
        }
        // 否则至少一个为Null ，返回不是Null的那个（不互为祖先的情况）
        return left == null ? right : left;
    }
}
