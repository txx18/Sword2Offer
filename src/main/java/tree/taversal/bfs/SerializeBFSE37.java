package tree.taversal.bfs;

import zhelper.TreeTest;
import zhelper.TreeUtils;
import zhelper.TreeUtils.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 示例: 
 * <p>
 * 你可以将以下二叉树：
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * 序列化为 "[1,2,3,null,null,4,5]"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-04 16:54
 */
public class SerializeBFSE37 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeTest.notCBTree2();
//        TreeNode treeNode = null;
//        TreeNode treeNode = new TreeNode(1);
//        treeNode.left = new TreeNode(2);

        SerializeBFSE37 obj = new SerializeBFSE37();
//        String serialize = obj.serialize(treeNode);


//        String serialize = "[1,2,3,null,null,4,5]";
        String serialize = "[5, 3, 8, 2, 4, 7, 10, 1, null, null, null, 6, null, 9, 11]";
        System.out.println("serialize = " + serialize);
        TreeNode deserialize = obj.deserialize(serialize);
        TreeUtils.printTree(deserialize);
    }

    /**
     * 层序序列化
     *
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur == null) {
                sb.append("null,");
            } else {
                sb.append(cur.val).append(",");
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        // removeEndNull版本不需要写出所有null的叶子节点
        return removeEndNull(sb.substring(0, sb.length() - 1) + "]");
    }

    /**
     * removeEndNull版本不需要写出所有null的叶子节点
     * @param data
     * @return
     */
    private String removeEndNull(String data) {
        // 取出元素
        String[] split = data.substring(1, data.length() - 1).split(",");
        int size = split.length;
        for (int i = split.length - 1; i >= 0; i--) {
            if ("null".equals(split[i])) {
                size--;
            } else {
                break;
            }
        }
        String[] res = new String[size];
        for (int i = 0; i < size; i++) {
            res[i] = split[i];
        }
        return Arrays.toString(res);
    }


    /**
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
     *
     * @param data
     * @return
     */
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "[]".equals(data)) {
            return null;
        }
        // 取出元素
        String[] split = data.substring(1, data.length() - 1).split(", ");
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

    public TreeNode generateTreeNode(String value) {
        if ("null".equals(value)) {
            return null;
        }
        return new TreeNode(Integer.valueOf(value));
    }
}
