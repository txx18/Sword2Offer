package tree.dp;

import zhelper.TreeUtils;
import zhelper.TreeUtils.*;

import java.util.LinkedList;

/**
 * 给定一个二叉树，确定它是否是一个完全二叉树。
 * <p>
 * 百度百科中对完全二叉树的定义如下：
 * <p>
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-completeness-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyIsCBT {
    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        tree1.left.left = new TreeNode(4);
        tree1.left.right = new TreeNode(5);
        tree1.right.left = new TreeNode(6);
        MyIsCBT obj = new MyIsCBT();
        boolean res = obj.isCBTZS(tree1);
        System.out.println("res = " + res);
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 98.44%
     * 的用户
     * 内存消耗 :
     * 37.9 MB
     * , 在所有 Java 提交中击败了
     * 5.48%
     * 的用户
     * @param head
     * @return
     */
    public boolean isCBTZS(TreeNode head) {
        if (head == null) {
            return true;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean shouldLeaf = false;
        TreeNode cur = head;
        queue.offer(cur);
        while (!queue.isEmpty()) {
            cur = queue.poll();
            // 违规1 是不双全的节点，但有孩子
            // 违规2 有右孩子没左孩子
            if ((TreeUtils.hasRight(cur) && !TreeUtils.hasLeft(cur)) ||
                    (shouldLeaf && TreeUtils.hasChild(cur))) {
                return false;
            }
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
            // l == null || r == null 不双全的节点
            else {
                shouldLeaf = true;
            }
        }
        return true;
    }

//	/**
//	 *
//	 * @param root
//	 * @return
//	 */
//    public boolean isCompleteTree(TreeNode root) {
//    	if (root == null) {
//    		return true;
//		}
//        return recurProcess(root).isCBT;
//    }
//
//	/**
//	 * 需要信息：isCBT,
//	 * @param x
//	 * @return
//	 */
//	private Data recurProcess(TreeNode x) {
//        if (x == null) {
//            return null;
//        }
//        Data leftData = recurProcess(x.left);
//        Data rightData = recurProcess(x.right);
//        boolean isCBT = true;
//        if (leftData != null) {
//			if (!leftData.isCBT || !isValidNode(x)) {
//				isCBT = false;
//			}
//		}
//		if (rightData != null) {
//			if (!rightData.isCBT || !isValidNode(x)) {
//				isCBT = false;
//			}
//		}
//		return new Data(isCBT);
//    }
//
//    private boolean isValidNode(TreeNode x) {
//    	if ((x.left == null && x.right != null) || (TreeUtils.isLeaf(x) && TreeUtils.hasChild(x))) {
//    		return false;
//		}
//    	return true;
//	}
//
//    private class Data {
//        boolean isCBT;
//
//		public Data(boolean isCBT) {
//			this.isCBT = isCBT;
//		}
//	}





}
