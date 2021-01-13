package recurforcetry.backtrack;

import java.util.ArrayList;

/**
 * @author ShaneTang
 * @create 2021-01-13 22:12
 */
public class GenerateParam {

    public static void main(String[] args) {
        GenerateParam obj = new GenerateParam();
        obj.generateParenthesis(0);
        System.out.println(obj.res);
    }

    ArrayList<String> res = new ArrayList<>();
    StringBuilder track = new StringBuilder("(");
    int n;
    String[] choose = new String[]{"(", ")"};
    /**
     *
     * @param n int整型
     * @return string字符串ArrayList
     */
    public ArrayList<String> generateParenthesis (int n) {
        // write code here
        if (n == 0) {
            return res;
        }
        this.n = n;
        bt(1, 0);
        return res;
    }

    private void bt(int leftCount, int rightCount) {
        // 如果leftCount < n，有两种选择；=3之后只能全右括号结束
        // 子序列的leftCount必须 >= rightCount
        if (leftCount == n) {
            StringBuilder copy = new StringBuilder(track);
            for (int i = 0; i < n - rightCount; i++) {
                copy.append(")");
            }
            res.add(copy.toString());
            return;
        }
        if (leftCount < rightCount) {
            return;
        }
        for (int i = 0; i < choose.length; i++) {
            // 放这里也可以，continue也可以
/*            if (leftCount < rightCount) {
                return;
            }*/
            track.append(choose[i]);
            if ("(".equals(choose[i])) {
                bt(leftCount + 1, rightCount);
            }else {
                bt(leftCount, rightCount + 1);
            }
            // 删除StringBuilder的最后一个元素
            track.deleteCharAt(track.length() - 1);
        }
    }
}
