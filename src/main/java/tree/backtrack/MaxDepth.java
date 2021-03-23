package tree.backtrack;


import zhelper.TreeUtils.TreeNode;

/**
 * @author ShaneTang
 * @create 2021-02-05 23:18
 */
public class MaxDepth {

    int res;
    int curDepth;

    /**
     * 正儿八经求深度，应该是前序，自顶向下
     * 通过LC
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return res;
        }
        curDepth++;
        if (root.left == null && root.right == null) {
            res = Math.max(res, curDepth);
        }
        maxDepth(root.left);
        maxDepth(root.right);
        // 回溯
        curDepth--;
        return res;
    }

    /**
     * 回溯写法
     * 通过LC
     *
     * @param root
     * @return
     */
    public int maxDepthCarl(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getDepthCarl1(root, 1);
        return res;
    }

    private void getDepthCarl1(TreeNode root, int depth) {
        res = Math.max(res, depth);
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
/*            depth++;
            getDepthCarl(root.left, depth);
            depth--;*/
        getDepthCarl1(root.left, depth + 1);
/*            depth++;
            getDepthCarl(root.right, depth);
            depth--;*/
        getDepthCarl1(root.right, depth + 1);
    }

//    /**
//     * 这种写法是错误的！！！
//     * @param root
//     */
//    private void getDepthCarl2(TreeNode root) {
//        res = Math.max(res, curDepth);
//        if (root == null) {
//            return;
//        }
//        if (root.left == null && root.right == null) {
//            return;
//        }
//        curDepth++;
//        getDepthCarl2(root.left);
//        curDepth--;
//        curDepth++;
//        getDepthCarl2(root.right);
//        curDepth--;
//    }


}
