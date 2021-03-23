package tree.dfs.postorder;


import zhelper.TestHelper;
import zhelper.TreeUtils;
import zhelper.TreeUtils.*;

/**
 * 关于根节点的深度究竟是1 还是 0，不同的地方有不一样的标准，leetcode的题目中都是以节点为一度，即根节点深度是1。但维基百科上定义用边为一度，即根节点的深度是0，我们暂时以leetcode为准（毕竟要在这上面刷题）。
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


    public boolean IsBalanced_Solution(TreeNode root) {
        return postorder(root) != -1;
    }


    private int postorder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hLeft = postorder(root.left);
        // 用h判断的话，必须有提前判断（为啥呢？） 如果判断非法，提前返回 -1
        if (hLeft == -1) {
            return -1;
        }
        int hRight = postorder(root.right);
        if (hRight == -1) {
            return -1;
        }
        if (Math.abs(hLeft - hRight) > 1) {
            return -1;
        }
        return 1 + Math.max(hLeft, hRight);
    }

    boolean res = true;

    private int postorderBool(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hLeft = postorderBool(root.left);
        int hRight = postorderBool(root.right);
        if (Math.abs(hLeft - hRight) > 1) {
            res = false;
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
