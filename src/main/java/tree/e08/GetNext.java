package tree.e08;

import zhelper.TreeUtils.*;

/**
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-21 12:46
 */
public class GetNext {
    /**
     * FIXME
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        // 先找到头结点
        TreeLinkNode cur = pNode;
        while (cur.next != null) {
            cur = cur.next;
        }
        return cur;
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
