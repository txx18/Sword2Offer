package tree.taversal.preorder;

/**
 * @author ShaneTang
 * @create 2021-01-04 22:52
 */

import zhelper.TreeUtils;
import zhelper.TreeUtils.*;

import java.util.*;

public class isBST {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        isBST obj = new isBST();
        TreeNode root = obj.buildBST2();
//        System.out.print(obj.isBST(root));
        System.out.println(obj.isBST2(root));
    }

    private int isBST2(TreeNode root) {
        if (root == null) {
            return 1;
        }
        // 限制最大最小的第1种写法 73.33%
        return isBST(root, null, null) ? 1: 0;
    }

    int preVal = Integer.MIN_VALUE;

    private boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 限制最大最小的第1种写法 73.33%
        return isBST(root, null, null);
        // 限制最大最小的第2种写法 86.67%
/*        TreeNode leftMax = findMax(root.left);
        TreeNode rightMin = findMin(root.right);
        if (leftMax != null && leftMax.val >= root.val) {
            return false;
        }else if (rightMin != null && rightMin.val <= root.val) {
            return false;
        }
        return isBST(root.left) && isBST(root.right);*/
        // 中序遍历 递归写法 46.67%
/*        isBST(root.left);
        if (root.val <= preVal) {
            return false;
        }
        preVal = root.val;
        isBST(root.right);
        return true;*/
        // 中序遍历 压栈写法 通过
        /*return inorder(root);*/
    }

    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 准备一个栈
        Stack<TreeNode> stack = new Stack();
        // 进入循环
        while (!stack.isEmpty() || root != null) {
            // 左子树全部入栈
            if (root != null) {
                stack.push(root);
                root = root.left;
            }
            else {
                // 出栈
                root = stack.pop();
                if (root.val <= preVal) {
                    return false;
                }
                preVal = root.val;
                // 切换到右子树
                root = root.right;
            }
        }
        return true;
    }

    private boolean isBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && min.val >= root.val) {
            return false;
        }
        if (max != null && max.val <= root.val) {
            return false;
        }
        return isBST(root.left, min, root) && isBST(root.right, root, max);
    }

    private TreeNode findMax(TreeNode root) {
/*        if (root == null || root.right == null) {
            return root;
        }
        return findMax(root.right);*/
        while (root != null && root.right != null) {
            root = root.right;
        }
        return root;
    }

    private TreeNode findMin(TreeNode root) {
/*        if (root == null || root.left == null) {
            return root;
        }
        return findMin(root.left);*/
        while (root != null && root.left != null) {
            root = root.left;
        }
        return root;
    }

    private TreeNode buildBST() {
        String[] firstLineSplits = sc.nextLine().split(" ");
        int nodeCount = Integer.parseInt(firstLineSplits[0]);
        int rootLineNum = Integer.parseInt(firstLineSplits[1]);
        TreeNode[] treeNodes = new TreeNode[nodeCount];
        int[][] data = new int[nodeCount][3];
        // 遍历两次，第一次建节点，把指针映射存入二维数组，第二次建指针
        for (int i = 0; i < nodeCount; i++) {
            String[] splits = sc.nextLine().split(" ");
            data[i][0] = Integer.parseInt(splits[0]);
            data[i][1] = Integer.parseInt(splits[1]);
            data[i][2] = Integer.parseInt(splits[2]);
            treeNodes[i] = new TreeNode(data[i][0]);
        }
        for (int i = 0; i < nodeCount; i++) {
            if (data[i][1] != 0) {
                treeNodes[i].left = treeNodes[data[i][1] - 1];
            }
            if (data[i][2] != 0) {
                treeNodes[i].right = treeNodes[data[i][2] - 1];
            }
        }
        TreeNode root = treeNodes[rootLineNum - 1];
        return root;
    }

    private TreeNode buildBST2() {
        int nodeCount = Integer.parseInt(sc.nextLine());
        Map<Integer, TreeNode> treeNodeMap = new HashMap<>(nodeCount);
        int[][] data = new int[nodeCount][3];
        // 遍历两次，第一次建节点，把指针映射存入HashMap，第二次建指针
        for (int i = 0; i < nodeCount; i++) {
            String[] rootSplit = sc.nextLine().split(":");
            data[i][0] = Integer.parseInt(rootSplit[0]);
            String[] leftRightSplit = rootSplit[1].split("\\|");
            data[i][1] = Integer.parseInt(leftRightSplit[0]);
            data[i][2] = Integer.parseInt(leftRightSplit[1]);
            treeNodeMap.put(data[i][0], new TreeNode(data[i][0]));
        }
        for (int i = 0; i < nodeCount; i++) {
            if (data[i][1] != -1) {
                treeNodeMap.get(data[i][0]).left = treeNodeMap.get(data[i][1]);
            }
            if (data[i][2] != -1) {
                treeNodeMap.get(data[i][0]).right = treeNodeMap.get(data[i][2]);
            }
        }
        TreeNode root = treeNodeMap.get(data[0][0]);
        return root;
    }
}
