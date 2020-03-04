package tree.taversal;

import zhelper.TreeTest;
import zhelper.TreeUtils.*;

import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-01 11:45
 */
public class IsBSTree {

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(-2147483648);
        TreeNode treeNode = TreeTest.integerMinTree();

//        TreeNode treeNode = new TreeNode(1);
//        treeNode.left = new TreeNode(1);

//        TreeNode treeNode = TreeTest.BST();

        IsBSTree obj = new IsBSTree();
        boolean res = obj.isValidBST(treeNode);
        System.out.println("res = " + res);
     }

    public boolean isValidBST(TreeNode root) {
//        return solutionInTraverseRecur(root);
        return solutionInTraverseLoop(root);
//        return solutionInTraverseRecurArrayList(root);
    }

    /**
     * 执行用时 :
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 40.30%
     * 的用户
     * 内存消耗 :
     * 38.8 MB
     * , 在所有 Java 提交中击败了
     * 27.21%
     * 的用户
     * @param root
     * @return
     */
    private boolean solutionInTraverseLoop(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            else {
                cur = stack.pop();
                // 处理
                if (cur.val <= this.preVal) {
                    return false;
                }
                else {
                    this.preVal = cur.val;
                }
                cur = cur.right;
            }
        }
        return true;
    }

    /**
     *  判断中序遍历升序
     *
     * 执行用时 :
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 40.30%
     * 的用户
     * 内存消耗 :
     * 40.7 MB
     * , 在所有 Java 提交中击败了
     * 5.01%
     * 的用户
     * @param root
     * @return
     */
    private boolean solutionInTraverseRecurArrayList(TreeNode root) {
        TraversalRecur traversalRecur = new TraversalRecur();
        List<Integer> inorderList = traversalRecur.inorderTraversal(root);
        for (int i = 0; i < inorderList.size() - 1; i++) {
            if (inorderList.get(i) >= inorderList.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * 全局变量，记录前一个值
     * 【注意】这个起头的必须足够小才行，Integer.MIN不够小
     */
    private double preVal = -Double.MAX_VALUE;

    /**
     * 动态检查
     *
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 38.7 MB
     * , 在所有 Java 提交中击败了
     * 29.80%
     * 的用户
     *
     * @param root
     * @return
     */
    private boolean solutionInTraverseRecur(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 递归左子树
        boolean isLeftBST = solutionInTraverseRecur(root.left);
        // 处理
        if (!isLeftBST) {
            return false;
        }
        // 判断如果当前值<=preVal，则不成立
        if (root.val <= this.preVal) {
           return false;
        }
        // cur.val > preVal
        else {
            this.preVal = root.val;
        }
        boolean isRightBST = solutionInTraverseRecur(root.right);
        return isRightBST;
    }

/*    private boolean recur(TreeNode cur, int preVal) {
        if (cur == null) {
            return true;
        }
        boolean isLeftBST = recur(cur.left, preVal);
        // 处理
        if (!isLeftBST) {
            return false;
        }
        if (cur.val <= preVal) {
            return false;
        }
        // cur.val > preVal
        else {
            preVal = cur.val;
        }
        boolean isRightBST = recur(cur.right, preVal);
        return isRightBST;
    }*/
}
