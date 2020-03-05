package tree.dp;

import zhelper.TreeUtils.*;

/**
 * LC98 验证二叉搜索时
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-23 12:13
 */
public class IsBSTreeDP {

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(2);
        tree1.left = new TreeNode(1);
        tree1.right = new TreeNode(3);
        IsBSTreeDP obj = new IsBSTreeDP();
        boolean res = obj.isValidBST(tree1);
        System.out.println("res = " + res);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root).isBST;
    }

    /**
     * 需要左右子树信息：isBST, min, max（本来只 需要左子树的max和右子树的min，但是递归过程要求过程统一，所以统一获得）
     *
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 79.04%
     * 的用户
     * 内存消耗 :
     * 41.1 MB
     * , 在所有 Java 提交中击败了
     * 5.02%
     * 的用户
     * @param x
     * @return
     */
    private Info recur(TreeNode x) {
        // base case
        if (x == null) {
            // 如果不确定整个返回结果，就先返回null，此时在调用的时候要做判断
            return null;
        }
        // 分别找左右子树要信息
        Info leftData = recur(x.left);
        Info rightData = recur(x.right);
        // 需要搞定isBST min max 3个信息
        // min max 就是x自己和左右子树的min max pk，更新min max
        int min = x.val;
        int max = x.val;
        boolean isBST = true;
        // 判断 leftData rightData 不为空，因为base case 说了为空返回null，不为空可以用信息
        if (leftData != null) {
            min = Math.min(min, leftData.min);
            max = Math.max(max, leftData.max);
            if (!leftData.isBST || leftData.max >= x.val) {
                isBST = false;
            }
        }
        if (rightData != null) {
            min = Math.min(min, rightData.min);
            max = Math.max(max, rightData.max);
            if (!rightData.isBST || x.val >= rightData.min) {
                isBST = false;
            }
        }
        // 返回信息
        return new Info(isBST, min, max);
    }

    private class Info {
        boolean isBST;
        int min;
        int max;

        public Info(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
}
