package tree.taversal.multiMethod;

import zhelper.TreeUtils;

/**
 * @author ShaneTang
 * @create 2021-01-03 9:49
 */
public class SeralizeBracket {

    StringBuilder sb = new StringBuilder();

    public String toSequence(TreeUtils.TreeNode root) {
        // write code here
        if (root == null) {
            return "";
        }
        sb.append("(");
        toSequence(root.left);
        toSequence(root.right);
        sb.append(")");
        return sb.toString();
    }
}
