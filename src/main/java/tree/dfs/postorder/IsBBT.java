package tree.dfs.postorder;


import zhelper.TestHelper;
import zhelper.TreeUtils;
import zhelper.TreeUtils.*;

/**
 * @author ShaneTang
 * @create 2021-02-06 10:57
 */
public class IsBBT {

    public static void main(String[] args) {
        IsBBT obj = new IsBBT();
        TreeNode deserialize = TreeUtils.deserialize("[1,2,2,3,null,null,null,4,4]");
//        TreeNode deserialize = TreeUtils.deserialize("[1,2,2,null,null,3,3,4,4]");
        boolean res = obj.IsBalanced_Solution(deserialize);
        System.out.println("res = " + res);
    }

    boolean res = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        return heightOpt(root) != -1;
    }


    private int heightOpt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hLeft = heightOpt(root.left);
        // 如果判断非法，提前返回剪枝
        if (hLeft == -1) {
            return -1;
        }
        int hRight = heightOpt(root.right);
        if (hRight == -1) {
            return -1;
        }
        if (Math.abs(hLeft - hRight) > 1) {
            return -1;
        }
        return 1 + Math.max(hLeft, hRight);
    }

    int recur;

    private int heightOptTest(TreeNode root) {
        TestHelper.printIndent(recur++);

        System.out.println(root == null ? null : root.val);

        if (root == null) {
            TestHelper.printIndent(recur--);
            System.out.println("null");
            return 0;
        }
        int hLeft = heightOptTest(root.left);
        if (hLeft == -1) {
            TestHelper.printIndent(recur--);
            System.out.println(root.val);
            return -1;
        }
        int hRight = heightOptTest(root.right);
        if (hRight == -1) {
            TestHelper.printIndent(recur--);
            System.out.println(root.val);
            return -1;
        }
        if (Math.abs(hLeft - hRight) > 1) {
            TestHelper.printIndent(recur--);
            System.out.println(root.val);
            return -1;
        }
        TestHelper.printIndent(recur--);
        System.out.println(root.val);
        return 1 + Math.max(hLeft, hRight);
    }


    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hLeft = height(root.left);
        int hRight = height(root.right);
        if (Math.abs(hLeft - hRight) > 1) {
            res = false;
        }
        return 1 + Math.max(hLeft, hRight);
    }

    private int heightTest(TreeNode root) {
        TestHelper.printIndent(recur++);
        System.out.println(root == null ? null : root.val);
        if (root == null) {
            TestHelper.printIndent(recur--);
            System.out.println("null");
            return 0;
        }
        int hLeft = heightTest(root.left);
        int hRight = heightTest(root.right);
        if (Math.abs(hLeft - hRight) > 1) {
            res = false;
        }
        TestHelper.printIndent(recur--);
        System.out.println(root.val);
        return 1 + Math.max(hLeft, hRight);
    }
}
