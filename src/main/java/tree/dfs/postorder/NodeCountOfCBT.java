package tree.dfs.postorder;

import zhelper.TreeUtils;
import zhelper.TreeUtils.*;

/**
 * @author ShaneTang
 * @create 2021-01-06 20:34
 */
public class NodeCountOfCBT {

    public static void main(String[] args) {
        TreeNode test = TreeUtils.deserialize("[1,2,null]");
        NodeCountOfCBT obj = new NodeCountOfCBT();
        int count = obj.nodeNum(null);
        System.out.println("count = " + count);

    }

    public int nodeNum(TreeNode head) {
        // 计算最左和最右叶子节点的深度
        int dl, dr;
        dl = dr = 0;
        TreeNode pl, pr;
        pl = pr = head;
        while (pl != null) {
            pl = pl.left;
            dl++;
        }
        while (pr != null) {
            pr = pr.right;
            dr++;
        }
        if (dl == dr) {
            return (int) (Math.pow(2, dl) - 1);
        }
        int left = nodeNum(head.left);
        int right = nodeNum(head.right);
        return 1 + left + right;
    }

    public int nodeNum1(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return nodeNum(head.left) + nodeNum(head.right) + 1;
    }
}
