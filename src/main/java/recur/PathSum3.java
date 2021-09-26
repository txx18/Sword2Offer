package recur;

import zhelper.TreeUtils;

/**
 * @author ShaneTang
 * @create 2021-01-21 22:33
 */
public class PathSum3 {


    /* 看不懂没关系，底下有更详细的分析版本，这里突出体现递归的简洁优美 */
    int pathSum2(TreeUtils.TreeNode root, int sum) {
        if (root == null) return 0;
        return count2(root, sum) + pathSum2(root.left, sum) + pathSum2(root.right, sum);
    }

    int count2(TreeUtils.TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0) + count2(node.left, sum - node.val) + count2(node.right, sum - node.val);
    }


    /* 有了以上铺垫，详细注释一下代码 */
    int pathSum3(TreeUtils.TreeNode root, int sum) {
        if (root == null) return 0;
        int pathImLeading = count(root, sum); // 自己为开头的路径数
        int leftPathSum = pathSum3(root.left, sum); // 左边路径总数（相信他能算出来）
        int rightPathSum = pathSum3(root.right, sum); // 右边路径总数（相信他能算出来）
        return leftPathSum + rightPathSum + pathImLeading;
    }

    int count(TreeUtils.TreeNode node, int sum) {
        if (node == null) return 0;
        // 我自己能不能独当一面，作为一条单独的路径呢？
        int isMe = (node.val == sum) ? 1 : 0;
        // 左边的小老弟，你那边能凑几个 sum - node.val 呀？
        int leftBrother = count(node.left, sum - node.val);
        // 右边的小老弟，你那边能凑几个 sum - node.val 呀？
        int rightBrother = count(node.right, sum - node.val);
        return isMe + leftBrother + rightBrother; // 我这能凑这么多个
    }
}
