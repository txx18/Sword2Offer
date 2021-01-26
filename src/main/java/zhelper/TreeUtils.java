package zhelper;

import java.util.*;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-16 15:25
 */
public class TreeUtils {

    public static void main(String[] args) {
        TreeNode tree1 = new TreeNode(1);
        tree1.left = new TreeNode(2);
        tree1.right = new TreeNode(3);
        tree1.left.left = new TreeNode(4);
        tree1.left.right = new TreeNode(5);
        tree1.right.left = new TreeNode(6);
        tree1.right.right = new TreeNode(7);

        TreeNode tree2 = new TreeNode(5);
        tree2.left = new TreeNode(3);
        tree2.right = new TreeNode(8);
        tree2.left.left = new TreeNode(2);
        tree2.left.right = new TreeNode(4);
        tree2.left.left.left = new TreeNode(1);
        tree2.right.left = new TreeNode(7);
        tree2.right.left.left = new TreeNode(6);
        tree2.right.right = new TreeNode(10);
        tree2.right.right.left = new TreeNode(9);
        tree2.right.right.right = new TreeNode(11);
        printTree(tree2);

        boolean res = hasChild(tree2.left.right);
        System.out.println("res = " + res);
    }

    public static boolean isLeaf(TreeNode cur) {
        if (cur == null) {
            return false;
        }
        return cur.left == null && cur.right == null;
    }

    public static boolean hasChild(TreeNode x) {
        if (x == null) {
            return false;
        }
        return x.left != null || x.right != null;
    }

    public static boolean hasNoChild(TreeNode x) {
        if (x == null) {
            return true;
        }
        return x.left == null && x.right == null;
    }

    public static boolean hasTwoChild(TreeNode x) {
        if (x == null) {
            return true;
        }
        return x.left != null && x.right != null;
    }

    public static boolean hasLeft(TreeNode x) {
        if (x == null) {
            return false;
        }
        return x.left != null;
    }

    public static boolean hasRight(TreeNode x) {
        if (x == null) {
            return false;
        }
        return x.right != null;
    }

    public static void printTree(TreeNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    private static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    /**
     * 【关键】 这个版本不需要写出所有null的叶子节点
     *
     * 执行用时 :
     * 36 ms
     * , 在所有 Java 提交中击败了
     * 34.92%
     * 的用户
     * 内存消耗 :
     * 42.3 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param data
     * @return
     */
    public static TreeNode deserialize(String data) {
        if (data == null || "[]".equals(data)) {
            return null;
        }
        // 取出元素，这里设置分隔符
        String[] split = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        // 构造一个节点队列，和一个下标指针
        int idx = 0;
        TreeNode root = generateTreeNode(split[idx++]);
        // 配合removeEndNull，idx到头也就是剩下的全是null，就不手动设置null孩子了，而是默认null孩子
        if (idx == split.length) {
            return root;
        }
        queue.offer(root);
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            cur.left = generateTreeNode(split[idx++]);
            // 配合removeEndNull，idx到头也就是剩下的全是null，就不手动设置null孩子了，而是默认null孩子
            if (idx == split.length) {
                break;
            }
            cur.right = generateTreeNode(split[idx++]);
            // 配合removeEndNull，idx到头也就是剩下的全是null，就不手动设置null孩子了，而是默认null孩子
            if (idx == split.length) {
                break;
            }
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
        return root;
    }

    private static TreeNode generateTreeNode(String value) {
        if ("null".equals(value)) {
            return null;
        }
        return new TreeNode(Integer.valueOf(value));
    }

    public static class TreeNode {

        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class NTreeNode {
        public int val;
        public NTreeNode[] children;

        public NTreeNode(int x) {
           val = x;
        }

        public NTreeNode(int val, NTreeNode[] children) {
            this.val = val;
            this.children = children;
        }

        public NTreeNode(int val, int[] children) {
            this.val = val;
            this.children = new NTreeNode[children.length];
            for (int i = 0; i < children.length; i++) {
                this.children[i] = new NTreeNode(children[i]);
            }
        }

        public NTreeNode[] adj() {
            return children;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NTreeNode nTreeNode = (NTreeNode) o;
            return val == nTreeNode.val && Arrays.equals(children, nTreeNode.children);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(val);
            result = 31 * result + Arrays.hashCode(children);
            return result;
        }

        @Override
        public String toString() {
            return "NTreeNode{" +
                    "val=" + val +
                    ", children=" + Arrays.toString(children) +
                    '}';
        }
    }

    static List<Integer> nTreeNodes = new ArrayList<>();

    public static List<Integer> preorderNTree(NTreeNode root) {
        if (root == null) {
            return nTreeNodes;
        }
        nTreeNodes.add(root.val);
        NTreeNode[] children = root.adj();
        if (children == null) {
            return nTreeNodes;
        }
        for (NTreeNode cur: root.adj()) {
            preorderNTree(cur);
        }
        return nTreeNodes;
    }
}
