package tree;

import zhelper.TreeUtils.*;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-03 23:00
 */
public class LCABST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solution(root, p, q);
    }

    /**
     * 执行用时 :
     * 10 ms
     * , 在所有 Java 提交中击败了
     * 21.96%
     * 的用户
     * 内存消耗 :
     * 42.5 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    private TreeNode solution(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 判断cur和p q 的大小关系
        // 画条数轴，要么都大于，要么都小于，要么在中间（或等于）
        // 如果都小于，证明LCA在左子树上
        if (p.val < root.val && q.val < root.val) {
            return solution(root.left, p, q);
        }
        // 如果都大于，证明LCA在右子树上
        else if (p.val > root.val && q.val > root.val) {
            return solution(root.right, p, q);
        }
        // 如果跨两边，LCA就是root
        return root;
    }
}
