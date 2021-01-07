package tree.taversal.postorder;

import zhelper.TreeUtils.*;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-03 22:59
 */
public class LowestCommonAncestorE6802 {

    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
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
        if (left != null && right != null) {
            return root;
        }
        // todo 没有特别懂
        return left == null? right: left;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solutionTrick(root, p, q);
    }

    /**
     * 执行用时 :
     * 8 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 40.8 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param root
     * @param p
     * @param q
     * @return
     */
    private TreeNode solutionTrick(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        // 递归
        TreeNode left = solutionTrick(root.left, p, q);
        TreeNode right = solutionTrick(root.right, p, q);
        // 如果都不为null（互为祖先的情况）
        if (left != null && right != null) {
            return root;
        }
        // 否则至少一个为Null ，返回不是Null的那个（不互为祖先的情况）
        return left != null ? left: right;
    }
}
