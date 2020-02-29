package tree;

import zhelper.TreeUtils.TreeNode;

import java.util.HashMap;

/**
 * 重建二叉树 先序+中序
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 *  
 *
 * 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Shane Tang
 * @create 2019-10-21 21:47
 */
public class BuildTreeByPreAndInSeq {

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        tree1.left.left = new TreeNode(4);
        tree1.left.right = new TreeNode(5);
        tree1.right.left = new TreeNode(6);
        tree1.right.right = new TreeNode(7);
    }

    // 准备一个hashMap存inSeq的数据，键是inSeq的值，值是下标
    HashMap<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (preOrder == null || inOrder == null || preOrder.length == 0 || inOrder.length == 0) {
            return null;
        }
        inMap = this.putIntoMap(inOrder);
        return buildProcess(preOrder, 0, preOrder.length - 1, 0);
    }

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

    private HashMap<Integer, Integer> putIntoMap(int[] inSeq){
        for (int i = 0; i < inSeq.length; i++) {
            inMap.put(inSeq[i], i);
        }
        return inMap;
    }



//    public BTNode buildTreeByPreAndInSeq(int[] preSeq, int[] inSeq) {
//        if (preSeq == null || inSeq == null || preSeq.length == 0 || inSeq.length == 0) {
//            return null;
//        }
//        return buildProcess(preSeq, inSeq,0, preSeq.length - 1, 0, inSeq.length - 1);
//    }
//
//    private BTNode buildProcess(int[] preSeq, int[] inSeq, int preL, int preR, int inL, int inR) {
//        if(preL > preR){
//            return null;
//        }
//        // 递归中头结点就是preSeq的第一个
//        // 不断建立头结点和子树的头结点
//        BTNode head = new BTNode(preSeq[preL]);
//        int headIndexInInSeq = getHeadIndexOfInSeq(inSeq, inL, inR, head);
//        // 在preSeq中
//        // 左子树递归
//        head.leftChild = buildProcess(preSeq, inSeq,preL + 1, preL + (headIndexInInSeq - inL), inL, headIndexInInSeq - 1);
//        // 右子树递归
//        head.rightChild = buildProcess(preSeq, inSeq,preL + (headIndexInInSeq - inL) + 1, preR, headIndexInInSeq + 1, inR);
//        return head;
//    }
//
//    int getHeadIndexOfInSeq(int[] inSeq, int inL, int inR, BTNode head){
//        int headIndexInInSeq = Integer.MIN_VALUE;
//        // 不用哈希表，用遍历的方法查出头结点在InSeq中的下标
//        for (int i = inL; i <= inR; i++) {
//            headIndexInInSeq = inSeq[i] == head.data ? i: headIndexInInSeq;
//        }
//        return headIndexInInSeq;
//    }



}
