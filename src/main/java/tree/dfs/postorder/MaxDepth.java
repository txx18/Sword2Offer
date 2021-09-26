package tree.dfs.postorder;


import zhelper.TreeUtils.*;

/**
 * @author ShaneTang
 * @create 2021-02-05 23:18
 */
public class MaxDepth {

    /**
     * 可以转化为 求二叉树的高度
     * 后序
     * 二叉树的高度 == 二叉树的深度 == 叶子节点最大深度 == 根结点高度
     *
     * @param root
     * @return
     */
    public int postorder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 本质是后序
        int leftDepth = postorder(root.left);
        int rightDepth = postorder(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
        /*        return 1 + Math.max(postorder(root.left), postorder(root.right));*/
    }
}
