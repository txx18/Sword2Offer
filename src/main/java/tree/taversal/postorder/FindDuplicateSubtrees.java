package tree.taversal.postorder;

import zhelper.TreeTest;
import zhelper.TreeUtils;
import zhelper.TreeUtils.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author ShaneTang
 * @create 2021-01-04 11:12
 */
public class FindDuplicateSubtrees {

    public static void main(String[] args) {

        FindDuplicateSubtrees ob = new FindDuplicateSubtrees();
        TreeNode deserialize = TreeUtils.deserialize("[1,2,3,4,null,2,4,null,null,4]");
        TreeUtils.printTree(deserialize);
        ob.findDuplicateSubtrees(deserialize);
    }

    Map<String, Integer> memo = new HashMap<>();
    List<TreeNode> res = new LinkedList<>();
    String SEP = ",";
    String NULL = "null";
    StringBuilder sb = new StringBuilder();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traversePost(root);
        return res;
    }

    private String traversePost(TreeNode root) {
        if (root == null) {
            return NULL;
        }
        String leftStr = traversePost(root.left);
        String rightStr = traversePost(root.right);
        // 这里好像不能用sb.append写法，会累加
        String subTree = leftStr + "," + rightStr + "," + root.val;
        int count = memo.getOrDefault(subTree, 0);
        if (count == 1) {
            res.add(root);
        }
        memo.put(subTree, count + 1);
        sb = new StringBuilder();
        return subTree;
    }

//    private putToMemo()
}
