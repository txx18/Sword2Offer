package tree.dfs.postorder;

import zhelper.TreeUtils.*;

public class IsSymmetricTree {

    public boolean isSymmetric(TreeNode pRoot) {
        // 一个头左右遍历，一个头右左遍历
        return postorder(pRoot, pRoot);
    }

    private boolean postorder(TreeNode p1, TreeNode p2) {
        if (p1 == null && p2 == null) {
            return true;
        }
        if (p1 == null || p2 == null) { // 注意
            return false;
        }
        if (p1.val != p2.val) {
            return false;
        }
        // 本题遍历只能是“后序遍历”，因为我们要通过递归函数的返回值来判断两个子树的内侧节点和外侧节点是否相等。
        boolean outside = postorder(p1.left, p2.right);
        boolean inside = postorder(p1.right, p2.left);
/*        // 放这也行
        if (p1.val != p2.val) {
            return false;
        }*/
        return outside && inside;
    }
}
