package tree.taversal;

import zhelper.TreeUtils;
import zhelper.TreeUtils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树 先序+中序
 * 举一反三 中序+后序 先序+后序
 *
 *
 * @author Shane Tang
 * @create 2019-10-21 21:47
 */
public class BuildTreeByPostAndIn {

    public static void main(String[] args) {
//        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        BuildTreeByPostAndIn obj = new BuildTreeByPostAndIn();
        TreeNode res = obj.buildTree(postorder, inorder);
        TreeUtils.printTree(res);
    }

    private Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] postorder, int[] inorder) {
        if (postorder == null || inorder == null) {
            return null;
        }
        this.inorderMap = putIntoMap(inorder);
        return recur(postorder, 0, postorder.length - 1, 0);
    }

    private Map<Integer, Integer> putIntoMap(int[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            this.inorderMap.put(inOrder[i], i);
        }
        return this.inorderMap;
    }

    private TreeNode recur(int[] postorder, int postL, int postR, int inL) {
        // 后续框架
        // base case
        if (postL > postR) {
            return null;
        }
        // 通过preorder的preL建根结点
        TreeNode root = new TreeNode(postorder[postL]);
        // 在inorder中找到根节点
        int rootIdxOfInorder = inorderMap.get(root.val);
        // 递归建左子树和右子树
        // inL的作用只是算出左子树的大小，inR没用
        root.left = recur(postorder, postL + 1, postL + (rootIdxOfInorder - inL), inL);
        root.right = recur(postorder,postL + (rootIdxOfInorder - inL) + 1, postR, rootIdxOfInorder + 1);
        // 自己返回自己的根节点
        return root;
    }


}
