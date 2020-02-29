package tree.e32;

import java.time.temporal.Temporal;
import java.util.*;

import zhelper.ArrayUtils;
import zhelper.TreeUtils.*;
/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-21 17:21
 */
public class PrintLevelOrderInLevel {

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        tree1.left.left = new TreeNode(4);
        tree1.left.right = new TreeNode(5);
        tree1.right.left = new TreeNode(6);
        tree1.right.right = new TreeNode(7);

        TreeNode tree2 = null;
        List<List<Integer>> res = levelOrder(tree1);
        for (List<Integer> level : res) {
            System.out.println(level.toString());
            System.out.println();
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        return solutionQueue(root);

    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 38.8 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param root
     * @return
     */
    private static List<List<Integer>> solutionQueue(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        // 头结点从尾进
        queue.offer(cur);
        // 设置两个变量，一个表示当前行的最后一个节点，一个表示下一行的最后一个节点
        TreeNode curLevelLast = cur;
        TreeNode nextLevelLast = null;
        while (!queue.isEmpty()) {
            // 出队列
            cur = queue.poll();
            // 处理
            levelList.add(cur.val);
            if (cur.left != null) {
                // 子节点从尾进
                queue.offer(cur.left);
                // 更新nextLevelLast
                nextLevelLast = cur.left;
            }
            if (cur.right != null) {
                queue.offer(cur. right);
                nextLevelLast = cur.right;
            }
            // 当cur到这一层的最后一个节点时，换行
            if (cur == curLevelLast) {
                curLevelLast = nextLevelLast;
                resList.add(levelList);
                // 清空行list
                levelList = new ArrayList<>();
            }
        }
        return resList;
    }
}