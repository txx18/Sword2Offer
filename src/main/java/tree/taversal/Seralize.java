package tree.taversal;

import zhelper.TreeTest;
import zhelper.TreeUtils;
import zhelper.TreeUtils.*;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ShaneTang
 * @create 2021-01-03 9:49
 */
public class Seralize {


    public static void main(String[] args) {
        TreeUtils.TreeNode treeNode = TreeTest.FBTree();
        TreeNode test = TreeUtils.deserialize("[1,2,3,4,null,2,4,null,null,4]");
//        TreeNode treeNode = null;

        Seralize obj = new Seralize();
//        StringBuilder sbPost = new StringBuilder();
        String serialize = obj.serializePre(test);
//        String serialize = obj.serializePost(treeNode);
        System.out.println("serialize = " + serialize);

        TreeUtils.TreeNode deserialize = obj.deserializePre(serialize);
        TreeUtils.printTree(deserialize);
    }



    String SEP = ",";
    String NULL = "null";
    StringBuilder sb = new StringBuilder();
    String serialize = "";


    private String serializePost(TreeNode root) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return sb.toString();
        }
        serializePost(root.left);
        serializePost(root.right);
        sb.append(root.val).append(SEP);
        return sb.toString();

/*        // return字符串的写法
        // 对于空节点，可以用一个特殊字符表示
        if (root == null) {
            return "#";
        }
        // 将左右子树序列化成字符串
        String left = serializePost(root.left);
        String right = serializePost(root.right);
        *//* 后序遍历代码位置 *//*
        // 左右子树加上自己，就是以自己为根的二叉树序列化结果
        String subTree = left + "," + right + "," + root.val;
        return subTree;*/
    }

    public String serializePre(TreeNode root) { // 默认自测测试用例是错的
        if (root == null) {
            serialize += NULL + SEP;
            return serialize;
        }
        serialize += root.val + SEP;
        serializePre(root.left);
        serializePre(root.right);
        return serialize;
    }

    public TreeUtils.TreeNode deserializePre(String str) {
        if ((NULL + SEP).equals(str)) {
            return null;
        }
        String[] splits = str.split(SEP);
        Queue<String> q = putToQueue(splits);
        return build(q);

    }

    TreeUtils.TreeNode build(Queue<String> q) {
        String poll = q.poll();
        if ((NULL).equals(poll)) {
            return null;
        }
        TreeUtils.TreeNode root = new TreeUtils.TreeNode(Integer.parseInt(poll));
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


    private String recurSerialize(TreeUtils.TreeNode root, StringBuilder sb) {
        if (root == null) {
            return "null,";
        }
        sb.append(root.val).append(",");
        // 递归
        sb.append(serializePre(root.left));
        sb.append(serializePre(root.right));
        return sb.toString();
    }

    public String serializeBracket(TreeUtils.TreeNode root) {
        // write code here
        if (root == null) {
            return "";
        }
        sb.append("(");
        serializeBracket(root.left);
        serializeBracket(root.right);
        sb.append(")");
        return sb.toString();
    }
}
