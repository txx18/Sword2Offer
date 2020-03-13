package tree.taversal.preorder;

import zhelper.TreeUtils.*;


/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *  
 *
 * 示例 1：
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 1000
 *
 * 注意：本题与主站 101 题相同：https://leetcode-cn.com/problems/symmetric-tree/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-13 20:45
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        TreeNode goLeft = root;
        TreeNode goRight = root;
        // 一个头左右遍历，一个头右左遍历
        recur(goLeft, goRight);
        return isSym;
    }


    boolean isSym = true;

    private void recur(TreeNode goLeft, TreeNode goRight) {
        // 如果遇到了一边为null另一边不为null，变为false
        if(goLeft == null && goRight != null ||
                goRight == null && goLeft !=null) {
            isSym = false;
            return;
        }
        // 遍历中正常返回
        if (goLeft == null || goRight == null) {
            return;
        }
        // 如果值不相等，变为false
        if(goLeft.val != goRight.val) {
            isSym = false;
        }
        // 一个头左右遍历，一个头右左遍历
        recur(goLeft.left, goRight.right);
        recur(goLeft.right, goRight.left);
    }
}
