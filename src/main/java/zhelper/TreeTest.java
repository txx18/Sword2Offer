package zhelper;

import zhelper.TreeUtils.TreeNode;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-20 17:39
 */
public class TreeTest {

    public static void main(String[] args) {
        TreeNode treeNode = notCBT();
        TreeUtils.printTree(treeNode);
    }

    public static TreeNode fbt() {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        return tree;
    }

    public static TreeNode cbt() {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        return tree;
    }

    /**
     * Binary Tree:
     *                                                          v11v
     *                                         v10v
     *                                                           ^9^
     *                         v8v
     *                                          ^7^
     *                                                           ^6^
     *        H5H
     *                                          v4v
     *                         ^3^
     *                                          ^2^
     *                                                           ^1^
     * @return
     */
    public static TreeNode notCBT() {
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(8);
        tree.left.left = new TreeNode(2);
        tree.left.right = new TreeNode(4);
        tree.left.left.left = new TreeNode(1);
        tree.right.left = new TreeNode(7);
        tree.right.left.left = new TreeNode(6);
        tree.right.right = new TreeNode(10);
        tree.right.right.left = new TreeNode(9);
        tree.right.right.right = new TreeNode(11);
        return tree;
    }
}
