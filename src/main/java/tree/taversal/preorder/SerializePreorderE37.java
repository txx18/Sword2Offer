package tree.taversal.preorder;

import zhelper.TreeTest;
import zhelper.TreeUtils;
import zhelper.TreeUtils.*;

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
public class SerializePreorderE37 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeTest.FBTree();
//        TreeNode treeNode = null;

        SerializePreorderE37 obj = new SerializePreorderE37();
        String serialize = obj.serialize(treeNode);
        System.out.println("serialize = " + serialize);

        TreeNode deserialize = obj.deserialize(serialize);
        TreeUtils.printTree(deserialize);
    }

    /**
     * 执行用时 :
     * 13 ms
     * , 在所有 Java 提交中击败了
     * 85.20%
     * 的用户
     * 内存消耗 :
     * 42.7 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null,";
        }
        // 按照先序序列化
        StringBuilder sb = new StringBuilder();
        return recurSerialize(root, sb);

    }

    private String recurSerialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return "null,";
        }
        sb.append(root.val).append(",");
        // 递归
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if ("null,".equals(data)) {
            return null;
        }
        // 把元素装进队列
        Queue<String> queue = new LinkedList<>();
        String[] split = data.split(",");
        for (String s : split) {
            queue.offer(s);
        }
        // 消费队列
        return recurDeserialize(queue);

    }

    private TreeNode recurDeserialize(Queue<String> queue) {
        String poll = queue.poll();
        if ("null".equals(poll)) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(poll));
        treeNode.left = recurDeserialize(queue);
        treeNode.right = recurDeserialize(queue);
        return treeNode;
    }
}
