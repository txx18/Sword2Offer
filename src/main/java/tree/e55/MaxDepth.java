package tree.e55;

import zhelper.TreeUtils.*;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-23 09:17
 */
public class MaxDepth {

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        tree1.left.left = new TreeNode(4);
        tree1.left.right = new TreeNode(5);
        tree1.right.left = new TreeNode(6);
        tree1.right.right = new TreeNode(7);

        TreeNode tree2 = new TreeNode(5);
        tree2.left = new TreeNode(3);
        tree2.right = new TreeNode(8);
        tree2.left.left = new TreeNode(2);
        tree2.left.right = new TreeNode(4);
        tree2.left.left.left = new TreeNode(1);
        tree2.right.left = new TreeNode(7);
        tree2.right.left.left = new TreeNode(6);
        tree2.right.right = new TreeNode(10);
        tree2.right.right.left = new TreeNode(9);
        tree2.right.right.right = new TreeNode(11);

        MaxDepth obj = new MaxDepth();
        int res = obj.maxDepth(tree2);
        System.out.println("res = " + res);
    }

    public int maxDepth(TreeNode root) {
        return solutionRecur(root);
    }

    private int depth = 1;
    private int maxDepth = 0;

    /**
     * FIXME
     * @param root
     * @return
     */
    private int solutionRecur(TreeNode root) {
        return 0;
    }


}
