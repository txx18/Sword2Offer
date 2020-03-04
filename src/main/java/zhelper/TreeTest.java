package zhelper;

import zhelper.TreeUtils.TreeNode;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-20 17:39
 */
public class TreeTest {

    public static void main(String[] args) {
        TreeNode treeNode = CBTree();
        TreeUtils.printTree(treeNode);
    }

    public static TreeNode FBTree() {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5);
        tree.right.left = new TreeNode(6);
        tree.right.right = new TreeNode(7);
        return tree;
    }

    /**
     * Binary Tree:
     *                         v3v
     *                                          ^6^
     *        H1H
     *                                          v5v
     *                         ^2^
     *                                          ^4^
     * @return
     */
    public static TreeNode CBTree() {
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
    public static TreeNode notCBTree() {
/*        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(3);
        tree.right = new TreeNode(8);
        tree.left.left = new TreeNode(2);
        tree.left.right = new TreeNode(4);
        tree.left.left.left = new TreeNode(1);
        tree.right.left = new TreeNode(7);
        tree.right.left.left = new TreeNode(6);
        tree.right.right = new TreeNode(10);
        tree.right.right.left = new TreeNode(9);
        tree.right.right.right = new TreeNode(11);*/

        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(5);
        tree.left.right = null;
        tree.right.left = new TreeNode(7);
        return tree;
    }

    public static TreeNode integerMinTree(){
        TreeNode tree = new TreeNode(Integer.MIN_VALUE);
        tree.left = new TreeNode(Integer.MIN_VALUE);
        return tree;
    }

    public static TreeNode BSTree() {
        TreeNode treeNode = new TreeNode(2);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(3);
        return treeNode;
    }
}
