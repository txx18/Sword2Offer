package tree.dfs.preorder;

import zhelper.TreeUtils.*;

public class IsSubtree {


    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        // 我们约定空树不是任意一个树的子结构
        // 必须有判断
        if (root1 == null || root2 == null) {
            return false;
        }
        boolean res = check(root1, root2);
        // 必须判true，因为一true则true, 而不是一false则false
        if (res) {
            return true;
        }
        boolean leftRes = HasSubtree(root1.left, root2);
        if (leftRes) {
            return true;
        }
        return HasSubtree(root1.right, root2);
    }

    private boolean check(TreeNode A, TreeNode B) {
        // 必须先判断子树B
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        return check(A.left, B.left) && check(A.right, B.right);
    }

}
