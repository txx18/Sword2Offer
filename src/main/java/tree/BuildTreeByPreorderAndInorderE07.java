package tree;

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
public class BuildTreeByPreorderAndInorderE07 {

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        BuildTreeByPreorderAndInorderE07 obj = new BuildTreeByPreorderAndInorderE07();
        TreeNode res = obj.buildTree(preorder, inorder);
        TreeUtils.printTree(res);
    }

    private Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();

    /**
     * 执行用时 :
     * 4 ms
     * , 在所有 Java 提交中击败了
     * 76.71%
     * 的用户
     * 内存消耗 :
     * 41.4 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        this.inorderMap = putIntoMap(inorder);
        return recur(preorder, inorder, 0, preorder.length - 1, 0);
    }

    private Map<Integer, Integer> putIntoMap(int[] inOrder) {
        for (int i = 0; i < inOrder.length; i++) {
            this.inorderMap.put(inOrder[i], i);
        }
        return this.inorderMap;
    }

    private TreeNode recur(int[] preorder, int[] inorder, int preL, int preR, int inL) {
        // base case
        if (preL == preR) {
            return null;
        }
        // 建根结点
        TreeNode root = new TreeNode(preorder[preL]);
        // 在inorder中找到根节点
        int rootIdxOfInorder = inorderMap.get(root.val);
        // 递归建左子树和右子树
        // inL的作用只是算出左子树的大小，inR没用
        root.left = recur(preorder, inorder, preL + 1, preL + (rootIdxOfInorder - inL), inL);
        root.right = recur(preorder, inorder, preL + (rootIdxOfInorder - inL) + 1, preR, rootIdxOfInorder + 1);
        // 最终返回根节点
        return root;
    }




    // 准备一个hashMap存inSeq的数据，键是inSeq的值，值是下标
    Map<Integer, Integer> inMap = new HashMap<>();


    private TreeNode buildProcess(int[] preSeq, int preL, int preR, int inL) {
        if(preL > preR){
            return null;
        }
        // 递归中头结点就是preSeq的第一个
        // 不断建立头结点和子树的头结点
        TreeNode head = new TreeNode(preSeq[preL]);
        // 查出头结点在InSeq中的下标
        int headIndexOfInSeq = inMap.get(head.val);
        // 计算左子树长度
        int leftChildTreeSize = headIndexOfInSeq - inL;
        // 在preSeq中
        // 左子树递归
        head.left = buildProcess(preSeq, preL + 1, preL + leftChildTreeSize, inL);
        // 右子树递归
        head.right = buildProcess(preSeq, preL + leftChildTreeSize + 1, preR, headIndexOfInSeq + 1);
        return head;
    }

}
