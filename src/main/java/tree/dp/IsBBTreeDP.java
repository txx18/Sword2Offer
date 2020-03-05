package tree.dp;

import zhelper.TreeUtils.TreeNode;

/**
 * LC面试题 04.04. 检查平衡性
 *
 * 实现一个函数，检查二叉树是否平衡。在这个问题中，平衡树的定义如下：任意一个节点，其两棵子树的高度差不超过 1。
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 * 示例 2:
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *       1
 *      / \
 *     2   2
 *    / \
 *   3   3
 *  / \
 * 4   4
 * 返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-balance-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author GFS
 */
public class IsBBTreeDP {

	public static void main(String[] args) {
		TreeNode tree1 = new TreeNode(3);
//		tree1.left = new TreeNode(9);
		tree1.right = new TreeNode(20);
		tree1.right.left = new TreeNode(15);
		tree1.right.right = new TreeNode(7);
		boolean res = new IsBBTreeDP().isBalanced(tree1);
		System.out.println("res = " + res);
	}

	/**
	 * 执行用时 :
	 * 1 ms
	 * , 在所有 Java 提交中击败了
	 * 100.00%
	 * 的用户
	 * 内存消耗 :
	 * 41.1 MB
	 * , 在所有 Java 提交中击败了
	 * 100.00%
	 * 的用户
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
		return recur(root).isBBTree;
	}

	/**
	 * 需要左右子树信息：isBBT, height
	 *
	 * @param x
	 * @return
	 */
	private Info recur(TreeNode x) {
		// base case
		if (x == null) {
			return new Info(true, 0);
		}
		// 假设能获取左右子树的信息（黑盒）
		Info leftData = recur(x.left);
		Info rightData = recur(x.right);
		// x也得返回信息，递归才能连起来（用黑盒，还能把黑盒拆掉）
		// 计算x的信息
		int height = Math.max(leftData.height, rightData.height) + 1;
		boolean isBBTree = leftData.isBBTree &&
				rightData.isBBTree &&
				Math.abs(leftData.height - rightData.height) < 2;
		// 返回x的信息
		return new Info(isBBTree, height);
	}

	private class Info {
		boolean isBBTree;
		int height;

		public Info(boolean isBBTree, int height) {
			this.isBBTree = isBBTree;
			this.height = height;
		}
	}
}
