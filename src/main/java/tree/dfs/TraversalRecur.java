package tree.dfs;

import zhelper.TreeTest;
import zhelper.TreeUtils;
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
        TreeNode treeNode = TreeTest.FBTree();
        TreeUtils.printTree(treeNode);

        TraversalRecur obj = new TraversalRecur();
//        List<Integer> traversal = obj.recurorderTraversal(treeNode);
//        System.out.println(traversal.toString());

        obj.threeOrders(treeNode);

    }

    int[][] resThreeOrders = null;
    List<Integer> preorder = new ArrayList<>();
    List<Integer> inorder = new ArrayList<>();
    List<Integer> postorder = new ArrayList<>();

    public int[][] threeOrders(TreeNode root) {
        // write code here
        traverse(root);
        resThreeOrders = new int[3][preorder.size()];
        resThreeOrders[0] = convertToIntArr(preorder);
        resThreeOrders[1] = convertToIntArr(inorder);
        resThreeOrders[2] = convertToIntArr(postorder);
        return resThreeOrders;
    }

    private int[] convertToIntArr(List<Integer> list) {
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        preorder.add(root.val);
        traverse(root.left);
        inorder.add(root.val);
        traverse(root.right);
        postorder.add(root.val);
    }

    public void recurTraverse(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print("前" + head.val + " ");
        recurTraverse(head.left);
        System.out.print("中" + head.val + " ");
        recurTraverse(head.right);
        System.out.print("后" + head.val + " ");
    }

    /**
     * 【注意】OJ不能用static
     */
    private ArrayList<Integer> res = new ArrayList<>();


    public List<Integer> recurorderTraversal(TreeNode head) {
        if (head == null) {
            return res;
        }
        res.add(head.val);
        recurorderTraversal(head.left);
        res.add(head.val);
        recurorderTraversal(head.right);
        res.add(head.val);
        return res;
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
     *
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
     *
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
     *
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
