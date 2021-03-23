package tree.dfs;

import zhelper.TreeUtils;
import zhelper.TreeUtils.*;

/**
 * @author ShaneTang
 * @create 2020-12-29 20:15
 */
public class ConstructMaximumBinaryTree {

    public static void main(String[] args) {
//        String data = "[5,4,8,11,null,13,4,7,2,null,null,5,1]";
//        TreeNode treeNode = TreeUtils.deserialize(data);
//        TreeUtils.printTree(treeNode);
        int[] data = {0, 1, 4, 3, 2};
        ConstructMaximumBinaryTree obj = new ConstructMaximumBinaryTree();
        TreeNode root = obj.constructMaximumBinaryTree(data);
        TreeUtils.printTree(root);
    }


    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);

    }

    private TreeNode constructMaximumBinaryTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int[] maxAndIndex = findMaxAndIndex(nums, l, r);
        int max = maxAndIndex[0];
        int index = maxAndIndex[1];
        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(nums, l, index - 1);
        root.right = constructMaximumBinaryTree(nums, index + 1, r);

        return root;
    }

    private int[] findMaxAndIndex(int[] nums, int l, int r) {
        int max = nums[l];
        int index = l;
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return new int[]{max, index};
    }
}
