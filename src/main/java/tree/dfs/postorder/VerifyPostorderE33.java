package tree.dfs.postorder;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-13 21:55
 */
public class VerifyPostorderE33 {

    public static void main(String[] args) {
        int[] arr1 = {5, 4, 3, 2, 1};
        VerifyPostorderE33 obj = new VerifyPostorderE33();
//        boolean res = obj.verifyPostorder(arr1);
//        System.out.println("res = " + res);

        boolean res = obj.VerifySquenceOfBST(arr1);
        System.out.println("res = " + res);
    }

    // 数组的最后一个元素是头结点的值
    // 如果是BST，以头结点可以二分数组，而且左边都是小于，右边都是大于
    // 递归判断
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null) {
            return false;
        }
        recur(postorder, 0, postorder.length - 1);
        return isValid;
        // return verify(postorder, 0, postorder.length - 1);
    }

    boolean isValid = true;

    private void recur(int[] postorder, int l, int r) {
        // base case
        if (r - l < 2) {
            return;
        }
        // pivotIdx代表在排序数组中的下标，遍历左边获得
        int pivotIdx = getIdxOfPostorder(postorder, l, r, postorder[r]);
        // 检查pivotIdx~r-1下标（左边不用比较），跟postorder[r]比较
        judge(postorder, pivotIdx, r);
        recur(postorder, l, pivotIdx - 1);
        recur(postorder, pivotIdx, r - 1);

    }

    private int getIdxOfPostorder(int[] arr, int l, int r, int pivot) {
        int i = l;
        while (i < r && arr[i] <= pivot) {
            i++;
        }
        return i;
    }

    private void judge(int[] postorder, int pivotIdx, int r) {
        for (int j = pivotIdx; j < r; j++) {
            // arr[r]就是pivot
            if (postorder[j] < postorder[r]) {
                isValid = false;
                return;
            }
        }
    }


    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        return verify(sequence, 0, sequence.length - 1);
    }

    private boolean verify(int[] sequence, int first, int last) {
        if (last - first <= 1)
            return true;
        int rootVal = sequence[last];
        int cutIndex = first;
        while (cutIndex < last && sequence[cutIndex] <= rootVal)
            cutIndex++;
        for (int i = cutIndex; i < last; i++)
            if (sequence[i] < rootVal)
                return false;
        return verify(sequence, first, cutIndex - 1) && verify(sequence, cutIndex, last - 1);
    }
}
