package bfs;

import java.util.*;

import zhelper.TreeUtils.*;

/**、
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-21 21:09
 */
public class PrintLevelOrderZigZag {

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
        return solutionDeque(root);
    }

    public List<List<Integer>> zigzagLevelOrder (TreeNode pRoot) {
        // write code here
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int step = 0;
        queue.offer(pRoot);
        while(!queue.isEmpty()) {
            int size = queue.size();
            // 双向链表
            Deque<Integer> level = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                }else {
                    // 偶数层往后加，奇数层往前加
                    if (step % 2 == 0) {
                        level.add(cur.val);
                    }else {
                        level.addFirst(cur.val);
                    }

                }
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
            if (level.size() != 0) {
                // 因为level是deque，所以有个转换
                res.add(new ArrayList<>(level));
            }
            step++;
        }
        return res;
    }

    /**
     * 执行用时 :
     * 2 ms
     * , 在所有 Java 提交中击败了
     * 87.16%
     * 的用户
     * 内存消耗 :
     * 39 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param root
     * @return
     */
    private static List<List<Integer>> solutionDeque(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> resList = new ArrayList<>();
        List<Integer> levelList = new ArrayList<>();
        // 定义一个双端队列
        Deque<TreeNode> dq = new LinkedList<>();
        TreeNode cur = root;
        // 头结点从尾进 offerFirst方法
        dq.offerFirst(cur);
        // 设置两个变量，一个表示当前行的最后一个节点，一个表示下一行的最后一个节点
        TreeNode curLevelLast = cur;
        TreeNode nextLevelLast = null;
        // 判断是从左到右还是从右到左的过程，初始从左到右
        boolean lr = true;
        // 迭代
        while (!dq.isEmpty()) {
            // 如果是从左到右的过程
            if (lr) {
                // 从头出dq
                cur = dq.pollFirst();
                // 处理
                levelList.add(cur.val);
                // 子节点从尾进dq，先左后右
                if (cur.left != null) {
                    dq.offerLast(cur.left);
                    // 更新nextLevelLast为最下一层最先进deque的子节点
                    nextLevelLast = nextLevelLast == null ? cur.left : nextLevelLast;
                }
                if (cur.right != null) {
                    dq.offerLast(cur. right);
                    nextLevelLast = nextLevelLast == null ? cur.right : nextLevelLast;
                }
            }
            // 如果是从右向左的过程
            else {
                // 从尾出dq
                cur = dq.pollLast();
                // 处理
                levelList.add(cur.val);
                // 子节点从头进dq，先右后左
                if (cur.right != null) {
                    dq.offerFirst(cur.right);
                    nextLevelLast = nextLevelLast == null ? cur.right : nextLevelLast;
                }
                if (cur.left != null) {
                    dq.offerFirst(cur.left);
                    nextLevelLast = nextLevelLast == null ? cur.left : nextLevelLast;
                }
            }
            // 当cur到这一层的最后一个节点时，换行
            if (cur == curLevelLast) {
                // 这3步都是必须的
                curLevelLast = nextLevelLast;
                lr = !lr;
                nextLevelLast = null;
                //处理
                resList.add(levelList);
                // 清空一层的list
                levelList = new ArrayList<>();
            }
        }
        return resList;
    }
}
