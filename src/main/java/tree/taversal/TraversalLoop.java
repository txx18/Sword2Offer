package tree.taversal;

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
        ArrayList<Integer> res = obj.BFSTraverse(tree);
        System.out.println(res.toString());
    }
    /**
     * 先序遍历
     *
     * @param head
     */
    public static void preTraverseZS(TreeNode head) {
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

    private ArrayList<Integer> res = new ArrayList<>();

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 61.16%
     * 的用户
     * 内存消耗 :
     * 37.9 MB
     * , 在所有 Java 提交中击败了
     * 5.05%
     * 的用户
     * @param root
     * @return
     */
    private List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        // 准备一个栈
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        //  head先入栈  cur改成head复用没问题
        stack.push(cur);
        // 进入循环
        while (!stack.isEmpty()) {
            // 出栈，打印
            cur = stack.pop();
            res.add(cur.val);
            // 入栈，先右后左
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }

        }
        return res;
    }

    /**
     * 后序遍历
     *
     * @param head
     */
    public static void posTraverseZS(TreeNode head) {
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
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 63.39%
     * 的用户
     * 内存消耗 :
     * 37.8 MB
     * , 在所有 Java 提交中击败了
     * 5.13%
     * 的用户
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        Stack<Integer> stack22 = new Stack<>();
        LinkedList<Integer> resLinkedList = new LinkedList<>();
        //  head先入栈
        TreeNode cur = root;
        stack1.push(cur);
        while (!stack1.isEmpty()) {
            // 出栈，放入收集栈，或者前插收集LinkedList
            cur = stack1.pop();
//            stack2.push(cur);
//            stack22.push(cur.val);
            resLinkedList.addFirst(cur.val);
            // 先左后右
            if (cur.left != null) {
                stack1.push(cur.left);
            }
            if (cur.right != null) {
                stack1.push(cur.right);
            }
            // 再循环，出栈
        }
/*        while (!stack2.isEmpty()) {
            res.add(stack2.pop().val);
        }*/
/*        while (!stack22.isEmpty()) {
            res.add(stack22.pop());
        }*/
//        return res;
        return resLinkedList;
    }

    /**
     * bfs
     * @param head
     */
    public void BFSTraverseZS(TreeNode head) {
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

    public ArrayList<Integer> BFSTraverse(TreeNode root) {
        if (root == null) {
            return res;
        }
        // 准备一个队列
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        queue.add(cur);
        while (!queue.isEmpty()) {
            // 出队列，打印
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
    public static void inTraverseZS(TreeNode head) {
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

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 67.61%
     * 的用户
     * 内存消耗 :
     * 37.7 MB
     * , 在所有 Java 提交中击败了
     * 5.10%
     * 的用户
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        // 准备一个栈
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        // 进入循环
        while (!stack.isEmpty() || cur != null) {
            // 左子树全部入栈
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // cur = null
            else {
                // 出栈，打印
                cur = stack.pop();
                res.add(cur.val);
                // 切换到右子树
                cur = cur.right;
            }
        }
        return res;
    }
}
