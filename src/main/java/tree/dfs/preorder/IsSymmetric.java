package tree.dfs.preorder;

import zhelper.TreeUtils.*;

public class IsSymmetric {

    public boolean isSymmetric(TreeNode pRoot) {
        // 一个头左右遍历，一个头右左遍历
        return recur(pRoot, pRoot);
    }

    private boolean recur(TreeNode p1, TreeNode p2) {
        if (p1 == null && p2 == null) {
            return true;
        }
        if (p1 == null || p2 == null) { // 注意
            return false;
        }
        // 前序
        if (p1.val != p2.val) {
            return false;
        }
        return recur(p1.left, p2.right) && recur(p1.right, p2.left);
    }
}
