package tree;

import zhelper.TreeUtils.*;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-03 23:00
 */
public class LowestCommonAncestorBSTreeE6801 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solutionTraverse(root, p, q);
    }

    /**
     *      执行用时 :
     *      6 ms
     *      , 在所有 Java 提交中击败了
     *      100.00%
     *      的用户
     *      内存消耗 :
     *      42.3 MB
     *      , 在所有 Java 提交中击败了
     *      100.00%
     *      的用户
     * @param root
     * @param p
     * @param q
     * @return
     */
    private TreeNode solutionTraverse(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null ){
            return null;
        }
        // 判断cur和p q 的大小关系
        // 画条数轴，要么都大于，要么都小于，要么在中间（或等于）
        if (root.val > p.val && root.val > q.val) {
            return solutionTraverse(root.left, p, q);
        }
        else if (root.val < p.val && root.val < q.val) {
            return solutionTraverse(root.right, p, q);
        }
        return root;
    }
}
