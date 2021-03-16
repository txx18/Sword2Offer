package tree.dfs.inorder;

import zhelper.TreeTest;
import zhelper.TreeUtils.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 *  
 * <p>
 * 限制：
 * <p>
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-12 22:08
 */
public class kthLargest {

    public static void main(String[] args) {
        TreeNode treeNode = TreeTest.BSTree();
        kthLargest obj = new kthLargest();
        TreeNode res = obj.KthMinNK(treeNode, 1);
        System.out.println("res = " + res.val);
    }

    int rank;
    TreeNode res = null;

    /**
     * 通过LC
     *
     * @param root
     * @return
     */
    public int kthLargestLC(TreeNode root, int k) {
        rank = k;
        return process(root);
    }


    private int process(TreeNode root) {
        if (root == null) {
            return -1;
        }
        // 先右后左
        process(root.right);
        if (rank == 1) {
            res = root;
            rank--; // 注意
            return res.val;
        }
        rank--;
        process(root.left);
        return res == null ? -1 : res.val;
    }


    TreeNode KthMinNK(TreeNode pRoot, int k) {
        if (pRoot == null) {
            return null;
        }
        KthMinNK(pRoot.left, k);
        rank++;
        if (rank == k) {
            res = pRoot;
            return res;
        }
        KthMinNK(pRoot.right, k);
        // 这个必须返回外部变量，不然递归返回的就是根结点了
        return res;
    }


    List<Integer> inorderList = new ArrayList<>();

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 67.44%
     * 的用户
     * 内存消耗 :
     * 41.4 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param root
     * @param k
     * @return
     */
    private int solutionList(TreeNode root, int k) {
        List<Integer> inorderList = inorderTraversal(root);
        return inorderList.get(inorderList.size() - k);
    }

    private List<Integer> inorderTraversal(TreeNode root) {
        // 递归
        if (root == null) {
            return inorderList;
        }
        inorderTraversal(root.left);
        inorderList.add(root.val);
        inorderTraversal(root.right);
        return inorderList;
    }


    int resInorder;
    int count;

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 40.7 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     *
     * @param root
     * @param k
     * @return
     */
    private int solution(TreeNode root, int k) {
        count = k;
        getTargetByInorder(root);
        return resInorder;

    }

    private void getTargetByInorder(TreeNode root) {
        // 中序框架
        if (root == null) {
            return;
        }
        getTargetByInorder(root.right);
        // 减到1返回
        if (count == 1) {
            resInorder = root.val;
            count--;
            return;
        }
        count--;
        getTargetByInorder(root.left);
    }
}
