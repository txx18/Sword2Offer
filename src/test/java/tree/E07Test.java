package tree;

import tree.e07.BuildTreeByPreAndInSeq;
import org.junit.Before;
import org.junit.Test;
import section05.myclass05.BTNode;
import section05.myclass05.BtreeTraversalByRecur;

/**
 * 重建二叉树
 *
 * @author Shane Tang
 * @create 2019-10-21 21:40
 */
public class E07Test {

    BuildTreeByPreAndInSeq obj = new BuildTreeByPreAndInSeq();
    BtreeTraversalByRecur btreeTraversalByRecur = new BtreeTraversalByRecur();

    BTNode head;

    @Before
    public void init(){
        head = new BTNode(1);
        head.leftChild = new BTNode(2);
        head.rightChild = new BTNode(3);
        head.leftChild.leftChild = new BTNode(4);
        head.leftChild.rightChild = new BTNode(5);
        head.rightChild.leftChild = new BTNode(6);
        head.rightChild.rightChild = new BTNode(7);
    }

    int[] preSeq = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
    int[] inSeq = new int[]{4, 7, 2, 1, 5, 3, 8, 6};

    @Test
    public void testBuildTreeByPreAndInSeq(){
        BTNode head = obj.buildTreeByPreAndInSeq(preSeq, inSeq);
        System.out.println("先序遍历：");
        btreeTraversalByRecur.preTraverse(head);
        System.out.println();
        System.out.println("中序遍历：");
        btreeTraversalByRecur.inTraverse(head);
        System.out.println();
        System.out.println("后序遍历：");
        btreeTraversalByRecur.posTraverse(head);

    }


}
