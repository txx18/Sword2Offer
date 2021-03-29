package tree.backtrack;

import java.util.ArrayList;
import java.util.List;

import zhelper.TreeUtils.TreeNode;

/**
 * @author ShaneTang
 * @create 2021-03-26 18:24
 */
public class AllPaths {

    List<String> res = new ArrayList<>();

    ArrayList<Integer> track = new ArrayList<>();

    StringBuilder sb = new StringBuilder();

    /**
     * 通过LC
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        bt(root);
        return res;
    }

    private void bt(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            StringBuilder path = new StringBuilder();
            for (int i = 0; i < track.size(); i++) {
                path.append(track.get(i)).append("->");
            }
            path.append(root.val);
            res.add(path.toString());
            return;
        }
        track.add(root.val);
        bt(root.left);
        track.remove(track.size() - 1);
        track.add(root.val);
        bt(root.right);
        track.remove(track.size() - 1);
    }

    public List<String> binaryTreePathsLCGF(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root == null) {
            return;
        }
        StringBuffer pathSB = new StringBuffer(path);
        pathSB.append(Integer.toString(root.val));
        if (root.left == null && root.right == null) {  // 当前节点是叶子节点
            paths.add(pathSB.toString());  // 把路径加入到答案中
            return;
        }
        pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
        constructPaths(root.left, pathSB.toString(), paths);
        constructPaths(root.right, pathSB.toString(), paths);
    }





/*    public List<String> binaryTreePaths(TreeNode root) {
        track.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder path = new StringBuilder();
            for (int i = 0; i < track.size() - 1; i++) { //
                path.append(track.get(i)).append("->");
            }
            path.append(root.val);
            res.add(path.toString());
            return res;
        }
        if (root.left != null) {
            binaryTreePaths(root.left);
            track.remove(track.size() - 1);
        }
        if (root.right != null) {
            binaryTreePaths(root.right);
            track.remove(track.size() - 1);
        }
        return res;
    }*/
}
