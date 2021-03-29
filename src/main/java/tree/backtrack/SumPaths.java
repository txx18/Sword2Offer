package tree.backtrack;

import zhelper.TreeUtils;
import zhelper.TreeUtils.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 *  注意是到叶节点才叫路径
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 *  
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 10000
 * 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-14 16:21
 */
public class SumPaths {

    public static void main(String[] args) {
        String data = "[5,4,8,11,null,13,4,7,2,null,null,5,1]";
        TreeNode treeNode = TreeUtils.deserialize(data);
//        TreeUtils.printTree(treeNode);

        SumPaths obj = new SumPaths();
        List<List<Integer>> res = obj.pathSum(treeNode, 22);
        for (List<Integer> path : res) {
            System.out.println(path.toString());
        }
    }

    List<List<Integer>> res = new ArrayList<>();
    ArrayList<Integer> track = new ArrayList<>();
    int sum;
    int curSum;
    boolean resBool;

    /**
     * 通过LC
     * @param root
     * @param target
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        // write code here
        if (root == null) {
            return res;
        }
        curSum += root.val;
        track.add(root.val);
        if (root.left == null && root.right == null) {
            if (curSum == target) {
                res.add(new ArrayList<>(track));
            }
        }
        pathSum(root.left, target);
        pathSum(root.right, target);
        curSum -= root.val;
        track.remove(track.size() - 1);
        return res;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        // write code here
        if (root == null) {
            return resBool;
        }
        curSum += root.val;
        if (root.left == null && root.right == null) {
            if (curSum == sum) {
                resBool = true;
            }
        }
        hasPathSum(root.left, sum);
        hasPathSum(root.right, sum);
        curSum -= root.val;
        return resBool;
    }

    private void recur(TreeNode cur) {
        if (cur == null) {
            return;
        }
        // 到叶子之前，把每个节点加到path里，同时计入路径和
        track.add(cur.val);
        curSum += cur.val;
        // 做选择
        // 来到叶子节点，检查路径和是否=sum
        if (cur.left == null && cur.right == null) {
//            int curSum = calSum(path);
            // 如果符合条件，把这条path加进去
            if (curSum == sum) {
                // 一定要new一个ArrayList加进去，不能直接加，不然加的是同一个
                res.add(new ArrayList<>(track));
            }
        }
        // backTrack
        recur(cur.left);
        recur(cur.right);
        // 撤销选择
        // 【关键】返回父节点之前弹出节点，同时减路径和
        curSum -= track.get(track.size() - 1);
        track.remove(track.size() - 1);
    }


    public List<List<Integer>> pathSum4(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        track.add(root.val);
        // 【关键】 复用sum
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            res.add(new ArrayList<>(track));
        }
        pathSum4(root.left, sum);
        pathSum4(root.right, sum);
        track.remove(track.size() - 1);
        return res;
    }

}
