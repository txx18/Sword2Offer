package tree.taversal.preorder;

import zhelper.TreeUtils.*;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * <p>
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 * <p>
 *    4 
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-11 20:36
 */
public class IsSubStructureE26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return solution(A, B);
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 39.57%
     * 的用户
     * 内存消耗 :
     * 42.7 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param A
     * @param B
     * @return
     */
    private boolean solution(TreeNode A, TreeNode B) {
        // 必须要
        if (A == null || B == null) {
            return false;
        }
        // 先序遍历框架
        boolean isSub = check(A, B);
        if (isSub) {
            return true;
        }
        boolean isLeftSub = solution(A.left, B);
        if (isLeftSub) {
            return true;
        }
        return solution(A.right, B);
//        return check(A, B) || solution(A.left, B) || solution(A.right, B);
    }

    private boolean check(TreeNode A, TreeNode B) {
        // 先序遍历框架
        // 如果B跟随A遍历完，返回true
        if (B == null) {
            return true;
        }
        // 如果A遍历完都没成功，或者值不相等
        if (A == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }
        // B跟随A遍历过程
        boolean checkLeft = check(A.left, B.left);
        boolean checkRight = check(A.right, B.right);
        return checkLeft && checkRight;
//        return check(A.left, B.left) && check(A.right, B.right);

    }
}
