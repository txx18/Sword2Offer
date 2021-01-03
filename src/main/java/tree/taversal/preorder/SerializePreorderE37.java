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



    String SEP = ",";
    String NULL = "null";
    StringBuilder sb = new StringBuilder();



    public String serialize(TreeNode root) { // 默认自测测试用例是错的
        if (root == null) {
            return sb.append(NULL).append(SEP).toString();
        }
        sb.append(root.val).append(SEP);
        serialize(root.left);
        serialize(root.right);
        return sb.toString();
    }

    public TreeNode deserialize(String str) {
        if ((NULL + SEP).equals(str)) {
            return null;
        }
        String[] splits = str.split(SEP);
        Queue<String> q = putToQueue(splits);
        return build(q);

    }

    TreeNode build(Queue<String> q) {
        String poll = q.poll();
        if ((NULL).equals(poll)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(poll));
        root.left = build(q);
        root.right = build(q);
        return root;
    }

    Queue<String> putToQueue(String[] strs) {
        Queue<String> q = new LinkedList<>();
        for (String str: strs) {
            q.offer(str);
        }
        return q;
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
}
