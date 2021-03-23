package tree.dfs.postorder;

import zhelper.TreeUtils;
import zhelper.TreeUtils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ShaneTang
 * @create 2021-01-14 11:24
 */
public class MinDepth {

    public static void main(String[] args) {
        TreeNode deserialize = TreeUtils.deserialize("[2,null,3,null,4,null,5,null,6]");
        TreeUtils.printTree(deserialize);
    }

    /**
     * 通过 LC
     * @param root
     * @return
     */
    public int minDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepthDFS(root.left);
        int rightDepth = minDepthDFS(root.right);
        // 左子树为空
        if (root.left == null && root.right != null) {
            return 1 + rightDepth;
        }
        // 右子树为空
        if (root.left != null && root.right == null) {
            return 1 + leftDepth;
        }
        // 都不为空
        return 1 + Math.min(leftDepth, rightDepth);
    }

    /**
     * 通过LC
     * @param root
     * @return
     */
    public int minDepthBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode cur;
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                if (cur == null) {
                    continue;
                } else if (cur.left == null && cur.right == null) {
                    return step;
                }
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            step++;
        }
        return step;
    }
}
