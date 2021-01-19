package tree.dfs;

import zhelper.TreeUtils;
import zhelper.TreeUtils.*;

/**
 * @author ShaneTang
 * @create 2021-01-06 20:34
 */
public class CBTNodeNum {

    public static void main(String[] args) {
        TreeNode test = TreeUtils.deserialize("[1,2,null]");
        CBTNodeNum obj = new CBTNodeNum();
        int count = obj.nodeNum(test);
        System.out.println("count = " + count);

    }

    public int nodeNum(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int hl = 0;
        int hr = 0;
        TreeNode pl = head;
        TreeNode pr = head;
        while (pl != null) {
            pl = pl.left;
            hl++;
        }
        while(pr != null) {
            pr = pr.right;
            hr++;
        }
        if (hl == hr) {
            return (int) (Math.pow(2, hl) - 1);
        }
        return 1 + nodeNum(head.left) + nodeNum(head.right);
    }

    public int nodeNum1(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return nodeNum(head.left) + nodeNum(head.right) + 1;
    }
}
