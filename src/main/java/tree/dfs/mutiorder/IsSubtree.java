package tree.dfs.mutiorder;

import zhelper.TreeUtils.*;

public class IsSubtree {

    /**
     * 通过LC
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 我们约定空树不是任意一个树的子结构
        // 必须有判断
        if (A == null || B == null) {
            return false;
        }
        boolean res = postOrPreorder(A, B);
        // 必须判true，因为一true则true, 而不是一false则false
        if (res) {
            return true;
        }
        boolean leftRes = isSubStructure(A.left, B);
        if (leftRes) {
            return true;
        }
        return isSubStructure(A.right, B);
    }

    /**
     * 通过LC
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure2(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        boolean leftRes = isSubStructure2(A.left, B);
        if (leftRes) {
            return true;
        }
        boolean rightRes = isSubStructure2(A.right, B);
        if (rightRes) {
            return true;
        }
        // 这真是既可以先序也可以后序啊
        return postOrPreorder(A, B);
    }

    private boolean postOrPreorder(TreeNode A, TreeNode B) {
        // 必须先判断子树B
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        // 放这也行
/*        if (A.val != B.val) {
            return false;
        }*/
        boolean leftRes = postOrPreorder(A.left, B.left);
        boolean rightRes = postOrPreorder(A.right, B.right);
        // 放这也行
        if (A.val != B.val) {
            return false;
        }
        return leftRes && rightRes;
    }

}
