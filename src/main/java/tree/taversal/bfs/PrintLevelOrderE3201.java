package tree.taversal.bfs;

import zhelper.ArrayUtils;
import zhelper.ListUtils;
import zhelper.TreeUtils;
import zhelper.TreeUtils.*;

import java.util.*;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-21 16:37
 */
public class PrintLevelOrderE3201 {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        int[] res = levelOrder(head);
        System.out.println("res = " + Arrays.toString(res));

    }

    public static int[] levelOrder(TreeNode root) {
        return solutionQueue(root);
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 94.36%
     * 的用户
     * 内存消耗 :
     * 38.6 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param root
     * @return
     */
    private static int[] solutionQueue(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> resList = new ArrayList<>();
        // 准备一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        // 头结点进队列
        TreeNode cur = root;
        queue.offer(cur);
        // 迭代
        while (!queue.isEmpty()) {
            // 出队列
            cur = queue.poll();
            // 处理
            resList.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur. right);
            }
        }
        // 返回数组;
        return ListUtils.convertToArray(resList);
    }
}
