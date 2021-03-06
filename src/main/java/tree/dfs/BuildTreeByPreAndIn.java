package tree.dfs;

import zhelper.TreeUtils;
import zhelper.TreeUtils.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 重建二叉树 先序+中序
 * TODO 举一反三 中序+后序 先序+后序
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 *  
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 *  
 * <p>
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shane Tang
 * @create 2019-10-21 21:47
 */
public class BuildTreeByPreAndIn {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        BuildTreeByPreAndIn obj = new BuildTreeByPreAndIn();
        TreeNode res = obj.reConstructBinaryTree(preorder, inorder);
        TreeUtils.printTree(res);
    }


    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        putToMap(in);
        return build(pre, 0, pre.length - 1, in, 0);
    }

    private TreeNode build(int[] pre, int preL, int preR, int[] in, int inL) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        int rootIndexOfIn = map.get(root.val);
        int leftSize = rootIndexOfIn - inL;
        root.left = build(pre, preL + 1, preL + leftSize, in, inL);
        root.right = build(pre, preL + leftSize + 1, preR, in, rootIndexOfIn + 1);
        return root;
    }

    private void putToMap(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            map.put(ints[i], i);
        }
    }

    private Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();

    /**
     * 执行用时 :
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 99.23%
     * 的用户
     * 内存消耗 :
     * 41.7 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        this.inorderMap = putIntoMap(inorder);
        return recur(preorder, 0, preorder.length - 1, 0);
    }

    private TreeNode recur(int[] preorder, int preL, int preR, int inL) {
        // 先序框架
        // base case
        // 递归方法的基准情形有两个：
        // 判断前序遍历的下标范围的开始和结束，若开始大于结束，则当前的二叉树中没有节点，返回空值 null。
        // 若开始等于结束，则当前的二叉树中恰好有一个节点，根据节点值创建该节点作为根节点并返回。
        if (preL > preR) {
            return null;
        }
        // 通过preorder的preL建根结点
        TreeNode root = new TreeNode(preorder[preL]);
/*        // 可以不用
        if (preL == preR) {
            return root;
        }*/
        // 在inorder中找到根节点
        int rootIdxOfInorder = inorderMap.get(root.val);
        // 递归建左子树和右子树
        // inL的作用是算出左子树的大小，inR没用
        int leftSize = rootIdxOfInorder - inL;
        root.left = recur(preorder, preL + 1, preL + leftSize, inL);
        root.right = recur(preorder, preL + leftSize + 1, preR, rootIdxOfInorder + 1);
        // 自己返回自己的根节点
        return root;
    }


    private Map<Integer, Integer> putIntoMap(int[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            this.inorderMap.put(inOrder[i], i);
        }
        return this.inorderMap;
    }
}
