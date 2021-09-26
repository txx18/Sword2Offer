package bfs;

import static zhelper.TreeUtils.*;

import zhelper.TreeTest;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 *
 * 百度百科中对完全二叉树的定义如下：
 *
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,2,3,4,5,6]
 * 输出：true
 * 解释：最后一层前的每一层都是满的（即，结点值为 {1} 和 {2,3} 的两层），且最后一层中的所有结点（{4,5,6}）都尽可能地向左。
 * 示例 2：
 *
 *
 *
 * 输入：[1,2,3,4,5,null,7]
 * 输出：false
 * 解释：值为 7 的结点没有尽可能靠向左侧。
 *  
 *
 * 提示：
 *
 * 树中将会有 1 到 100 个结点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-01 16:54
 */
public class IsCBTree {

    public static void main(String[] args) {
        TreeNode treeNode = TreeTest.CBTree();
//        TreeNode treeNode = TreeTest.notCBT();

        IsCBTree obj = new IsCBTree();
        boolean res = obj.isCompleteTree(treeNode);
        System.out.println("res = " + res);
    }

    public boolean isCompleteTree(TreeNode root) {
        return solutionBFS(root);
    }

    /**
     * 执行用时 :
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 30.06%
     * 的用户
     * 内存消耗 :
     * 37.5 MB
     * , 在所有 Java 提交中击败了
     * 5.15%
     * 的用户
     * @param root
     * @return
     */
    private boolean solutionBFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        TreeNode cur = root;
        queue.offer(cur);
        // 是否遇到孩子不双全结点
        boolean occurNotTwoChildren = false;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            // 处理
            // 判定false条件
            // 1、有右孩子没左孩子
            if (!hasLeft(cur) && hasRight(cur)) {
                return false;
            }
            // 2、出现了孩子不双全结点之后，节点有孩子
            if (occurNotTwoChildren && hasChild(cur)) {
                return false;
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            // 判断是否孩子不双全
            if (!hasTwoChild(cur)) {
                occurNotTwoChildren = true;
            }
        }
        return true;
    }
}
