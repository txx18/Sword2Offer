package tree.dfs.postorder;

import zhelper.TreeUtils;
import zhelper.TreeUtils.*;

/**
 * @author ShaneTang
 * @create 2021-01-06 20:34
 */
public class CBTNodeCount {

    public static void main(String[] args) {
        TreeNode test = TreeUtils.deserialize("[1,2,null]");
        CBTNodeCount obj = new CBTNodeCount();
        int count = obj.countNodes(null);
        System.out.println("count = " + count);

    }

    /**
     * 通过LC
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        // 计算最左和最右叶子节点的深度
        int dl, dr;
        dl = dr = 0;
        TreeNode pl, pr;
        pl = pr = root;
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
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return 1 + left + right;
    }

    public int nodeNum1(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return countNodes(head.left) + countNodes(head.right) + 1;
    }
}
