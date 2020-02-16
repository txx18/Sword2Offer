package tree.e07;

import zhelper.TreeUtils.*;
import zhelper.TreeUtils;
import java.util.HashMap;

/**
 * 重建二叉树
 *
 * @author Shane Tang
 * @create 2019-10-21 21:47
 */
public class BuildTreeByPreAndInSeq {

    public static void main(String[] args) {
        BTNode head = new BTNode(1);
        head.leftChild = new BTNode(2);
        head.rightChild = new BTNode(3);
        head.leftChild.leftChild = new BTNode(4);
        head.leftChild.rightChild = new BTNode(5);
        head.rightChild.leftChild = new BTNode(6);
        head.rightChild.rightChild = new BTNode(7);
    }

    // 准备一个hashMap存inSeq的数据，键是inSeq的值，值是下标
    HashMap<Integer, Integer> inMap = new HashMap<>();

    public BTNode buildTreeByPreAndInSeq(int[] preSeq, int[] inSeq) {
        if (preSeq == null || inSeq == null || preSeq.length == 0 || inSeq.length == 0) {
            return null;
        }
        inMap = this.putIntoMap(inSeq);
        return buildProcess(preSeq, 0, preSeq.length - 1, 0);
    }

    private BTNode buildProcess(int[] preSeq, int preL, int preR, int inL) {
        if(preL > preR){
            return null;
        }
        // 递归中头结点就是preSeq的第一个
        // 不断建立头结点和子树的头结点
        BTNode head = new BTNode(preSeq[preL]);
        // 查出头结点在InSeq中的下标
        int headIndexOfInSeq = inMap.get(head.data);
        // 计算左子树长度
        int leftChildTreeSize = headIndexOfInSeq - inL;
        // 在preSeq中
        // 左子树递归
        head.leftChild = buildProcess(preSeq, preL + 1, preL + leftChildTreeSize, inL);
        // 右子树递归
        head.rightChild = buildProcess(preSeq, preL + leftChildTreeSize + 1, preR, headIndexOfInSeq + 1);
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
