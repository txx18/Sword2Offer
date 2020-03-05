package tree;

import zhelper.TreeUtils.*;

/**
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-21 12:46
 */
public class GetNextE08 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        return solution3Condition(pNode);
    }

    /**
     * 运行时间：25ms
     * <p>
     * 占用内存：9648k
     */
    private TreeLinkNode solution3Condition(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        // 如果有右子树，返回右子树的最左结点
        if (hasRight(pNode)) {
            TreeLinkNode cur = pNode.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }
        // 如果没有右子树
        // 如果没有右子树，尝试他的父是不是target的左孩子，如果是，返回target
        // 如果没有右子树，而且找到root也不是target的左孩子，说明是最后一个节点，返回null
        else {
            TreeLinkNode cur = pNode;
            TreeLinkNode parent = cur.next;
            while (parent != null && parent.left != cur) {
                cur = cur.next;
                parent = parent.next;
            }
            return parent;
        }

    }

    public static boolean hasRight(TreeLinkNode x) {
        if (x == null) {
            return false;
        }
        return x.right != null;
    }

    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
}
