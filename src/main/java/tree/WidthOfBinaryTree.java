package tree;

import zhelper.TreeTest;
import zhelper.TreeUtils;
import zhelper.TreeUtils.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * <p>
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 3     2
 * / \     \
 * 5   3     9
 * <p>
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * /
 * 3
 * / \
 * 5   3
 * <p>
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * 示例 3:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * /
 * 5
 * <p>
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 * 示例 4:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * /     \
 * 5       9
 * /         \
 * 6           7
 * 输出: 8
 * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * TODO leetcode的没做出来
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-28 16:08
 */
public class WidthOfBinaryTree {

    public static void main(String[] args) {

//        TreeNode tree = TreeTest.fbt();
        TreeNode tree = TreeTest.cbt();
//        TreeNode tree = TreeTest.notCBT();

//        TreeNode tree = TreeUseCase.notCBT();
        TreeUtils.printTree(tree);

        WidthOfBinaryTree obj = new WidthOfBinaryTree();
        int res = obj.widthOfBinaryTree(tree);
        System.out.println("res = " + res);
    }

    /**
     * LC题是包括中间的null的
     * ZS题是不包括null的
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
//        return solutionBFSHashMapExcludeNull(root);
//        return solutionBFSPointerExcludeNull(root);
        return solutionBFSIncludeNull(root);
//        return getMaxWidthZS(root);
    }

    private int solutionBFSPointerExcludeNull(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        TreeNode curLevelEnd = cur;
        TreeNode nextLevelEnd = null;
        int curLevelNodeCnt = 0;
        queue.offer(cur);
        while (!queue.isEmpty()) {
            // 出队列
            cur = queue.poll();

            // 如果左右不为空
            if (cur.left != null) {
                nextLevelEnd = cur.left;
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                nextLevelEnd = cur.right;
                queue.offer(cur.right);
            }


            // 处理
            // 如果是当前层最后一个
            if (cur == curLevelEnd) {
                curLevelNodeCnt++;
                // 结算
                max = Math.max(max, curLevelNodeCnt);
                // 换层
                curLevelEnd = nextLevelEnd;
                curLevelNodeCnt = 0;
            }
            // 如果不是最后一个
            else {
                curLevelNodeCnt++;
            }
        }
        return max;
    }

    private int solutionBFSIncludeNull(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        TreeNode curLevelEnd = cur;
        TreeNode nextLevelEnd = null;
        TreeNode curLevelStart = cur;
        int curLevelNodeCnt = 0;
        queue.offer(cur);
        while (!queue.isEmpty()) {
            // 出队列
            cur = queue.poll();
            // 如果左右不为空
            if (cur.left != null) {
                nextLevelEnd = cur.left;
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                nextLevelEnd = cur.right;
                queue.offer(cur.right);
            }
            // 处理
            // 如果是当前层最后一个
            if (cur == curLevelEnd) {
                curLevelNodeCnt++;
                // 结算
                max = Math.max(max, curLevelNodeCnt);
                // 换层
                curLevelEnd = nextLevelEnd;
                curLevelNodeCnt = 0;
            }
            // 如果不是最后一个
            else {
                curLevelNodeCnt++;
            }
        }
        return max;
    }

    private int solutionBFSHashMapExcludeNull(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int curLevel = 1;
        int levelWidth = 0;
        // 记录每个节点所在层数
        HashMap<TreeNode, Integer> levelMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        queue.offer(cur);
        levelMap.put(cur, 1);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            // 处理
            // 如果出栈的是同一行，节点数加一
            Integer curNodeLevel = levelMap.get(cur);
            if (curNodeLevel == curLevel) {
                levelWidth++;
            }
            // 如果出栈的换行了，层数加一，节点数置零，更新max
            else {
                // 注意不是在此处结算
                curLevel = curNodeLevel;
                levelWidth = 1;
            }
            max = Math.max(max, levelWidth);
            // 如果左右不为空
            if (cur.left != null) {
                // 更新哈希表
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.offer(cur.right);
            }

        }
        return max;
    }

    public static int solutionZS(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int maxWidth = 0;
        int curWidth = 0;
        int curLevel = 0;
        HashMap<TreeNode, Integer> levelMap = new HashMap<>();
        levelMap.put(head, 1);
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        TreeNode node = null;
        TreeNode left = null;
        TreeNode right = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            left = node.left;
            right = node.right;
            if (left != null) {
                levelMap.put(left, levelMap.get(node) + 1);
                queue.add(left);
            }
            if (right != null) {
                levelMap.put(right, levelMap.get(node) + 1);
                queue.add(right);
            }
            if (levelMap.get(node) > curLevel) {
                curWidth = 1;
                curLevel = levelMap.get(node);
            } else {
                curWidth++;
            }
            maxWidth = Math.max(maxWidth, curWidth);
        }
        return maxWidth;
    }
}
