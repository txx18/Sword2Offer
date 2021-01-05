package tree.taversal;

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
        String serialize = obj.Serialize(test);
//        String serialize = obj.serializePost(treeNode);
        System.out.println("serialize = " + serialize);

        TreeNode deserialize = obj.Deserialize(serialize);
        TreeUtils.printTree(deserialize);
    }



    String SEP = ",";
    String NULL = "null";
    StringBuilder sb = new StringBuilder();
    String serialize = "";
    Queue<String> q = new LinkedList<>();
    Stack<String> stack = new Stack<>();


    String Serialize(TreeNode root) {
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
    }


/*    public String Serialize(TreeNode root) {
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
        return Serialize(root.left) + Serialize(root.right) + root.val + SEP;
    }

    public TreeNode Deserialize(String str) {
        String[] splits = str.split(SEP);
        putToStack(splits);
        return buildPost();
    }*/

    private TreeNode buildPost() {
        String pop = stack.pop();
        if(NULL.equals(pop)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(pop));
        root.right = buildPost();
        root.left = buildPost();
        return root;
    }

    private void putToStack(String[] strs) {
        for (String str: strs) {
            stack.push(str);
        }
    }

/*    public String Serialize(TreeNode root) { // 默认自测测试用例是错的
//        if (root == null) {
//            serialize += NULL + SEP;
//            return serialize;
//        }
//        serialize += root.val + SEP;
//        Serialize(root.left);
//        Serialize(root.right);
//        return serialize;
        if (root == null) {
            return NULL + SEP;
        }
        return root.val + SEP + Serialize(root.left) + Serialize(root.right);
    }

    public TreeNode Desialize(String str) {
        if ((NULL + SEP).equals(str)) {
            return null;
        }
        String[] splits = str.split(SEP);
        putToQueue(splits);
        return buildPre();
    }*/

    private TreeNode buildPre() {
        String poll = q.poll();
        if ((NULL).equals(poll)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(poll));
        root.left = buildPre();
        root.right = buildPre();
        return root;
    }

    private void putToQueue(String[] strs) {
        for (String str: strs) {
            q.offer(str);
        }
    }


    public String serializeBracket(TreeNode root) {
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
