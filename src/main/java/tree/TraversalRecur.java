package tree;

import zhelper.TreeUtils.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归遍历二叉树
 *
 * @author Shane Tang
 * @create 2019-10-15 17:25
 */
public class TraversalRecur {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
/*        recurTraverse(head);
        System.out.println();
        preTraverse(head);
        System.out.println();
        inTraverse(head);
        System.out.println();
        posTraverse(head);
        System.out.println();*/
        TraversalRecur obj = new TraversalRecur();
        List<Integer> preorderTraversal = obj.preorderTraversal(head);
        System.out.println(preorderTraversal.toString());

    }

    public static void recurTraverse(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        recurTraverse(head.left);
        System.out.print(head.val + " ");
        recurTraverse(head.right);
        System.out.print(head.val + " ");
    }



    public static void preTraverse(TreeNode head) {
        if (head == null) {
            return;
        }
        // 在递归序的基础上
        // 遍历到头结点的时候打印
        System.out.print(head.val + " ");
        preTraverse(head.left);
        preTraverse(head.right);
    }

    /**
     * 【注意】OJ不能用static
     */
    private ArrayList<Integer> res = new ArrayList<>();

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 38.3 MB
     * , 在所有 Java 提交中击败了
     * 5.05%
     * 的用户
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        TreeNode cur = root;
        res.add(cur.val);
        preorderTraversal(cur.left);
        preorderTraversal(cur.right);
        return res;
    }

    public static void inTraverse(TreeNode head) {
        if (head == null) {
            return;
        }
        inTraverse(head.left);
        System.out.print(head.val + " ");
        inTraverse(head.right);
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 38.4 MB
     * , 在所有 Java 提交中击败了
     * 5.10%
     * 的用户
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // 递归
        if (root == null) {
            return res;
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }

    public static void posTraverse(TreeNode head) {
        if (head == null) {
            return;
        }
        posTraverse(head.left);
        posTraverse(head.right);
        System.out.print(head.val + " ");
    }

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 38.4 MB
     * , 在所有 Java 提交中击败了
     * 5.13%
     * 的用户
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        res.add(root.val);
        return res;
    }
}
