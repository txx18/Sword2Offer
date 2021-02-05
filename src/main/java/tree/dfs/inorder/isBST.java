package tree.dfs.inorder;

/**
 * @author ShaneTang
 * @create 2021-01-04 22:52
 */

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
        return isBST(root) ? 1 : 0;
    }

    private boolean isBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 限制最大最小的第1种写法 73.33%
//        return isBST(root, null, null);
        // 中序遍历 递归写法 73.33%
//        return inorderRecur(root);
        // 中序遍历 压栈写法 通过
        return inorderLoop(root);
    }

    TreeNode pre = null;

    /**
     * 中序循环方法
     *
     * @param root
     * @return
     */
    private boolean inorderLoop(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                // 操作
                if (pre != null && root.val <= pre.val) {
                    return false;
                }
                pre = root;
                root = root.right;
            }
        }
        return true;
    }

    /**
     * 中序递归方法
     * 在NK有错误
     *
     * @param root
     * @return
     */
    boolean inorderRecur(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = inorderRecur(root.left);
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        // 记录前一个节点
        pre = root;
        boolean right = inorderRecur(root.right);
        return left && right;
    }


    private double preVal = -Double.MAX_VALUE;

    private boolean solutionInTraverseRecur(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 递归左子树
        boolean isLeftBST = solutionInTraverseRecur(root.left);
        // 处理
        if (!isLeftBST) {
            return false;
        }
        // 判断如果当前值<=preVal，则不成立
        if (root.val <= this.preVal) {
            return false;
        }
        // cur.val > preVal
        else {
            this.preVal = root.val;
        }
        boolean isRightBST = solutionInTraverseRecur(root.right);
        return isRightBST;
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
