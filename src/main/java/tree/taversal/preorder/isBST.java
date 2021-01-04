package tree.taversal.preorder;

/**
 * @author ShaneTang
 * @create 2021-01-04 22:52
 */

import java.util.*;

public class isBST {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        isBST obj = new isBST();
        TreeNode root = obj.buildBST();
        System.out.print(obj.isBST(root));
    }

    private boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        TreeNode leftMax = findMax(root.left);
        TreeNode rightMin = findMin(root.right);
        if (leftMax.val >= root.val) {
            return false;
        }else if (rightMin.val <= root.val) {
            return false;
        }
        return isBST(root.left) && isBST(root.right);
    }

    private TreeNode findMax(TreeNode root) {
        if (root.right == null) {
            return root;
        }
        return findMax(root.right);
    }

    private TreeNode findMin(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return findMin(root.left);
    }

    private TreeNode buildBST() {
        String[] firstLineSplits = sc.nextLine().split(" ");
        int nodeCount = Integer.parseInt(firstLineSplits[0]);
        int rootLineNum = Integer.parseInt(firstLineSplits[1]);
        TreeNode root = null;
        for (int i = 0; i < nodeCount; i++) {
            String[] splits = sc.nextLine().split(" ");
            if (i + 1 == rootLineNum) {
                root = new TreeNode(Integer.parseInt(splits[0]));
            }
            TreeNode cur = find(root, Integer.parseInt(splits[0]));
            if (cur == null) {
                continue;
            }
            if (!"0".equals(splits[1])) {
                cur.left = new TreeNode(Integer.parseInt(splits[1]));
            }
            if (!"0".equals(splits[2])) {
                cur.right = new TreeNode(Integer.parseInt(splits[2]));
            }
        }
        return root;
    }

    private TreeNode find(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            return root;
        }else if (root.val < target) {
            return find(root.left, target);
        }else if (root.val > target) {
            return find(root.right, target);
        }else {
            return root;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
