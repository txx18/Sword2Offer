package tree.dfs.postorder;

import zhelper.TreeUtils.*;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-03 22:59
 */
public class LCA {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return postorder2(root, p, q);
    }

    private TreeNode postorder2(TreeNode root, TreeNode p, TreeNode q) {
        // base case
        if (root == null || root == p || root == q) {
            return root;
        }
        // 递归
        TreeNode left = postorder2(root.left, p, q);
        TreeNode right = postorder2(root.right, p, q);
        // 如果都不为null（互为祖先的情况）
        if (left != null && right != null) {
            return root;
        }
        // 否则至少一个为Null ，返回不是Null的那个（不互为祖先的情况）
        return left != null ? left : right;
    }

    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // write code here
        return postorder(root, o1, o2).val;
    }

    private TreeNode postorder(TreeNode root, int o1, int o2) {
        // write code here
        if (root == null || root.val == o1 || root.val == o2) {
            return root;
        }
        TreeNode left = postorder(root.left, o1, o2);
        TreeNode right = postorder(root.right, o1, o2);
        // 如果都不为null（互为祖先的情况）
        if (left != null && right != null) {
            return root;
        }
        // 否则至少一个为Null ，返回不是Null的那个（不互为祖先的情况）
        return left == null ? right : left;
    }
}
