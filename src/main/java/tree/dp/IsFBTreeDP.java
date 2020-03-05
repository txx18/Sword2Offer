package tree.dp;

import zhelper.TreeTest;
import zhelper.TreeUtils.*;
/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-23 17:07
 */
public class IsFBTreeDP {

    public static void main(String[] args) {
        TreeNode treeNode = TreeTest.FBTree();

        IsFBTreeDP obj = new IsFBTreeDP();
        boolean res = obj.isFBT(treeNode);
        System.out.println("res = " + res);
    }

    /**
     * 需要：isFBT, 节点个数
     * @param root
     * @return
     */
    private boolean isFBT(TreeNode root) {
        if (root == null) {
            return true;
        }
        Info data = recur(root);
        // 节点数是否 == 2^h -1
        return data.nodeCount == (1 << data.height) - 1;
    }

    private Info recur(TreeNode x) {
        if (x == null) {
            return new Info(0, 0);
        }
        // 要信息
        Info leftData = recur(x.left);
        Info rightData = recur(x.right);
        // 凑信息
        int height = Math.max(leftData.height, rightData.height) + 1;
        int nodeCount = leftData.nodeCount + rightData.nodeCount + 1;
        // 返信息
        return new Info(height, nodeCount);
    }

    private class Info {
        int height;
        int nodeCount;

        public Info(int height, int nodeCount) {
            this.height = height;
            this.nodeCount = nodeCount;
        }
    }
}
