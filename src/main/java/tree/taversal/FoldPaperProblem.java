package tree.taversal;

/**
 * 用1代表凸，用0代表凹
 * 打印一棵树
 * 所有子树，左孩子都是凹，右孩子都是凸；或者左孩子都是凸，右孩子都是凹
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-05 09:18
 */
public class FoldPaperProblem {

    public static void main(String[] args) {
        FoldPaperProblem obj = new FoldPaperProblem();

        obj.print(1, 3, true);
    }

    /**
     * 根据递归遍历
     * @param curLevel
     * @param totalLevel
     * @param down true==“凹”
     */
    public void print(int curLevel, int totalLevel, boolean down) {
        // base case
        if (curLevel > totalLevel) {
            return;
        }
        // 打印节点
        System.out.print(down == true ? "0 " : "1 ");
        // 调用 curLevel=下一层, totalLevel=不变， down=传入的值
        print(curLevel + 1, totalLevel, true);
        print(curLevel + 1, totalLevel, false);
    }
}
