package tree.dfs;

import zhelper.TreeTest;
import zhelper.TreeUtils;
import zhelper.TreeUtils.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author ShaneTang
 * @create 2021-01-03 9:49
 */
public class Serialize {


    public static void main(String[] args) {
        TreeNode treeNode = TreeTest.FBTree();
        TreeNode test = TreeUtils.deserialize("[8,6,10,5,7,9,11]");
//        TreeNode treeNode = null;

        Serialize obj = new Serialize();
//        StringBuilder sbPost = new StringBuilder();
        String serialize = obj.serializePre(test);
//        String serialize = obj.serializePost(treeNode);
        System.out.println("serialize = " + serialize);

        TreeNode deserialize = obj.deserializePre(serialize);
        TreeUtils.printTree(deserialize);
    }


    String SEP = ",";
    String NULL = "null";
    StringBuilder sb = new StringBuilder();
    Queue<String> q = new LinkedList<>();
    Stack<String> stack = new Stack<>();

    public String serializePre(TreeNode root) { // 默认自测测试用例是错的
        if (root == null) {
            return NULL + SEP;
        }
        return root.val + SEP + serializePre(root.left) + serializePre(root.right);
    }

    public TreeNode deserializePre(String str) {
        // 多一步验证NULL+SEP
        if ((NULL + SEP).equals(str)) {
            return null;
        }
        String[] splits = str.split(SEP);
        for (String split : splits) {
            q.offer(split);
        }
        return preorder();
    }

    private TreeNode preorder() {
        String poll = q.poll();
        // 从队列出来的自然没有+SEP
        if ((NULL).equals(poll)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(poll));
        root.left = preorder();
        root.right = preorder();
        return root;
    }


    private void putToQueue(String[] strs) {

    }

    /**
     * 层序
     */
/*    String Serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(cur.val).append(SEP);
            q.offer(cur.left);
            q.offer(cur.right);
        }
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        if(str.isEmpty()) {
            return null;
        }
        String[] splits = str.split(SEP);
        TreeNode root = new TreeNode(Integer.parseInt(splits[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for (int i = 1; i < splits.length;) {
            TreeNode cur = q.poll();
            String left = splits[i++];
            if (!left.equals(NULL)) {
                cur.left = new TreeNode(Integer.parseInt(left));
                q.offer(cur.left);
            }else {
                // 这里要把非空的结点加入队列，所以对于NULL要单独拎出来
                cur.left = null;
            }
            String right = splits[i++];
            if (!right.equals(NULL)) {
                cur.right = new TreeNode(Integer.parseInt(right));
                q.offer(cur.right);
            }else {
                cur.right = null;
            }
        }
        return root;
    }*/
    public String serializePost(TreeNode root) {
//        if (root == null) {
//            sb.append(NULL).append(SEP);
//            return sb.toString();
//        }
//        Serialize(root.left);
//        Serialize(root.right);
//        sb.append(root.val).append(SEP);
//        return sb.toString();
        // return字符串的写法
        if (root == null) {
            return NULL + SEP;
        }
        // 左右子树加上自己，就是以自己为根的二叉树序列化结果
        return serializePost(root.left) + serializePost(root.right) + root.val + SEP;
    }

    public TreeNode deserializePost(String str) {
        String[] splits = str.split(SEP);
        Stack<String> stack = new Stack<>();
        putToStack(splits, stack);
        return buildPost(stack);
    }

    private TreeNode buildPost(Stack<String> stack) {
        String pop = stack.pop();
        if (NULL.equals(pop)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(pop));
        // 先右后左
        root.right = buildPost(stack);
        root.left = buildPost(stack);
        return root;
    }

    private void putToStack(String[] strs, Stack<String> stack) {
        for (String str : strs) {
            stack.push(str);
        }
    }


    public String serializeBracket(TreeNode root) {
        // write code here
        if (root == null) {
            return "";
        }
        return "(" + serializeBracket(root.left) + serializeBracket(root.right) + ")";
    }
}
