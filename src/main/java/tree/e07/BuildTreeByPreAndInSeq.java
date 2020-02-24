package tree.e07;

import zhelper.TreeUtils.*;

import java.util.HashMap;

/**
 * 重建二叉树
 *
 * @author Shane Tang
 * @create 2019-10-21 21:47
 */
public class BuildTreeByPreAndInSeq {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
    }

    // 准备一个hashMap存inSeq的数据，键是inSeq的值，值是下标
    HashMap<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTreeByPreAndInSeq(int[] preSeq, int[] inSeq) {
        if (preSeq == null || inSeq == null || preSeq.length == 0 || inSeq.length == 0) {
            return null;
        }
        inMap = this.putIntoMap(inSeq);
        return buildProcess(preSeq, 0, preSeq.length - 1, 0);
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
