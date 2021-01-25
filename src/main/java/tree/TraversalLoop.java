package tree;

import zhelper.TreeTest;
import zhelper.TreeUtils.*;

import java.util.*;

/**
 * 循环方法遍历二叉树
 *
 * @author Shane Tang
 * @create 2019-10-16 18:22
 */
public class TraversalLoop {

    public static void main(String[] args) {
        TreeNode tree = TreeTest.FBTree();
/*        System.out.println();
        preTraverse(head);
        System.out.println();
        inTraverse(head);
        System.out.println();
        posTraverse(head);
        System.out.println();
        BFSTraverse(head);
        System.out.println();*/

        TraversalLoop obj = new TraversalLoop();
//        obj.inTraversePrint(tree);

        List<Integer> res = obj.inorderLoop(tree);
        System.out.println(res.toString());
    }

    public static void preTraversePrint(TreeNode head) {
        if (head == null) {
            return;
        }
        // 准备一个栈
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = head;
        //  head先入栈  cur改成head复用没问题
        stack.push(cur);
        // 进入循环
        while (!stack.isEmpty()) {
            // 出栈，打印
            cur = stack.pop();
            System.out.print(cur.val + " ");
            // 入栈，先右后左
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            // 再循环，出栈
        }
    }


    public List<Integer> preorderLoop(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        //  head先入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur != null) {
                res.add(cur.val);
            } else {
                continue;
            }
            // 入栈，先右后左
            stack.push(cur.right);
            stack.push(cur.left);
        }
        return res;
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderLoop(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }

    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> postorderLoop(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        // root先入栈
        TreeNode cur = root;
        stack.push(cur);
        while (!stack.isEmpty()) {
            // 出栈，几种方法：1、前插LinkedList 2、正常后插LinkedList最后反转返回 3、放入收集栈
            cur = stack.pop();
            if (cur == null) {
                continue;
            }
            res.addFirst(cur.val);
            // 先左后右
            stack.push(cur.left);
            stack.push(cur.right);
        }
        return res;
    }

    public static void posTraversePrint(TreeNode head) {
        if (head == null) {
            return;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        //  head先入栈
        TreeNode cur = head;
        stack1.push(cur);
        while (!stack1.isEmpty()) {
            // 出栈，放入收集栈
            cur = stack1.pop();
//            stack2.push(cur);
            stack2.push(cur);
            // 先左后右
            if (cur.left != null) {
                stack1.push(cur.left);
            }
            if (cur.right != null) {
                stack1.push(cur.right);
            }
            // 再循环，出栈
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }


    /**
     * bfs
     *
     * @param head
     */
    public void BFSTraversePrint(TreeNode head) {
        if (head == null) {
            return;
        }
        // 准备一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            // 出队列，打印
            head = queue.poll();
            System.out.print(head.val + " ");
            // 入栈，先左后右
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
        }
    }

    /**
     * 另一个需要收集每一层的见bfs包
     * @param root
     * @return
     */
    public ArrayList<Integer> BFSorder(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 准备一个队列，不存在visited, target
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        queue.add(cur);
        while (!queue.isEmpty()) {
            // 出队列
            cur = queue.poll();
            res.add(cur.val);
            // 入栈，先左后右
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return res;

    }

    /**
     * 中序遍历
     *
     * @param head
     */
    public void inTraversePrint(TreeNode head) {
        if (head == null) {
            return;
        }
        // 准备一个栈
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = head;
        // 进入循环
        while (!stack.isEmpty() || cur != null) {
            // 左子树全部入栈
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // cur == null
            else {
                // 出栈，打印
                cur = stack.pop();
                System.out.print(cur.val + " ");
                // 切换到右子树
                cur = cur.right;
            }
        }
    }


}
