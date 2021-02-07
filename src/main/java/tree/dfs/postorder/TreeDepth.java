package tree.dfs.postorder;


import zhelper.TreeUtils.*;

/**
 * @author ShaneTang
 * @create 2021-02-05 23:18
 */
public class TreeDepth {

    /**
     * 转化为求 二叉树的高度
     * 后序
     * 二叉树的高度 == 二叉树的深度 == 叶子节点最大深度 == 根结点高度
     * @param root
     * @return
     */
    public int TreeDepthRecur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 本质是后序
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
/*        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return 1 + Math.max(left, right);*/
    }

    int res;
    int curDepth;

    /**
     * 先序，自顶向下
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


}
