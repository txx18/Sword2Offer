package zhelper;

import java.sql.PreparedStatement;
import java.util.Objects;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-16 15:25
 */
public class TreeUtils {

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
        printTree(tree2);

        boolean res = hasChild(tree2.left.right);
        System.out.println("res = " + res);
    }

    public static boolean isLeaf(TreeNode cur) {
        if (cur == null) {
            return false;
        }
        return cur.left == null && cur.right == null;
    }

    public static boolean hasChild(TreeNode x) {
        if (x == null) {
            return false;
        }
        return x.left != null || x.right != null;
    }

    public static boolean hasNoChild(TreeNode x) {
        if (x == null) {
            return true;
        }
        return x.left == null && x.right == null;
    }

    public static boolean hasTwoChild(TreeNode x) {
        if (x == null) {
            return true;
        }
        return x.left != null && x.right != null;
    }

    public static boolean hasLeft(TreeNode x) {
        if (x == null) {
            return false;
        }
        return x.left != null;
    }

    public static boolean hasRight(TreeNode x) {
        if (x == null) {
            return false;
        }
        return x.right != null;
    }

    public static void printTree(TreeNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    private static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TreeNode treeNode = (TreeNode) o;
            return val == treeNode.val &&
                    Objects.equals(left, treeNode.left) &&
                    Objects.equals(right, treeNode.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }
    }
}
