package recurforcetry.backtrack;

import java.util.Arrays;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 *  
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= s 的长度 <= 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-16 21:11
 */
public class StringsPermutationCount {

    /*
     * 回溯法
     *
     * 字符串的排列和数字的排列都属于回溯的经典问题
     *
     * 回溯算法框架：解决一个问题，实际上就是一个决策树的遍历过程：
     * 1. 路径：做出的选择
     * 2. 选择列表：当前可以做的选择
     * 3. 结束条件：到达决策树底层，无法再做选择的条件
     *
     * 伪代码：
     * result = []
     * def backtrack(路径，选择列表):
     *     if 满足结束条件：
     *         result.add(路径)
     *         return
     *     for 选择 in 选择列表:
     *         做选择
     *         backtrack(路径，选择列表)
     *         撤销选择
     *
     * 核心是for循环中的递归，在递归调用之前“做选择”，
     * 在递归调用之后“撤销选择”。
     *
     * 字符串的排列可以抽象为一棵决策树：
     *                       [ ]
     *          [a]          [b]         [c]
     *      [ab]   [ac]  [bc]   [ba]  [ca]  [cb]
     *     [abc]  [acb] [bca]  [bac]  [cab] [cba]
     *
     * 考虑字符重复情况：
     *                       [ ]
     *          [a]          [a]         [c]
     *      [aa]   [ac]  [ac]   [aa]  [ca]  [ca]
     *     [aac]  [aca] [aca]  [aac]  [caa] [caa]
     *
     * 字符串在做排列时，等于从a字符开始，对决策树进行遍历，
     * "a"就是路径，"b""c"是"a"的选择列表，"ab"和"ac"就是做出的选择，
     * “结束条件”是遍历到树的底层，此处为选择列表为空。
     *
     * 本题定义backtrack函数像一个指针，在树上遍历，
     * 同时维护每个点的属性，每当走到树的底层，其“路径”就是一个全排列。
     * 当字符出现重复，且重复位置不一定时，需要先对字符串进行排序，
     * 再对字符串进行“去重”处理，之后按照回溯框架即可。
     * */

    public static void main(String[] args) {

        String str = "abc";

        StringsPermutationCount obj = new StringsPermutationCount();

        int resCnt = obj.permutationCnt(str);
        System.out.println("resCnt = " + resCnt);
    }

    char[] chars;
    boolean[] hasUsed;

    public int permutationCnt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        this.chars = s.toCharArray();
        this.hasUsed = new boolean[chars.length];
        // 先对字符数组排序，使重复的相邻
        Arrays.sort(chars);
        // 从下标0开始尝试
        return recurCnt(0);

    }

    /**
     * 全排列有多少种
     *
     * @param i
     * @return
     */
    private int recurCnt(int i) {
        // 来到i位置
        // 结束条件：i来到最后一个位置。得到一种排列
        if (i == chars.length) {
            return 1;
        }
        int resCnt = 0;
        for (int j = 0; j < chars.length; j++) {
            // 为了对“aab”这种字符串的排列去重，进行剪枝（分支限界）
            if (hasUsed[j]) {
                continue;
            }
            if (j != 0 && !hasUsed[j - 1] && chars[j] == chars[j - 1]) {
                continue;
            }
            // 做选择
            hasUsed[j] = true;
            // 递归尝试下一个位置
            resCnt += recurCnt(i + 1);
            // 撤销选择
            hasUsed[j] = false;
        }
        return resCnt;
    }


}
