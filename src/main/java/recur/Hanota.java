package recur;

import java.util.*;

/**
 * 在经典汉诺塔问题中，有 3 根柱子及 N 个不同大小的穿孔圆盘，盘子可以滑入任意一根柱子。一开始，所有盘子自上而下按升序依次套在第一根柱子上(即每一个盘子只能放在更大的盘子上面)。移动圆盘时受到以下限制:
 * (1) 每次只能移动一个盘子;
 * (2) 盘子只能从柱子顶端滑出移到下一根柱子;
 * (3) 盘子只能叠在比它大的盘子上。
 * <p>
 * 请编写程序，用栈将所有盘子从第一根柱子移到最后一根柱子。
 * <p>
 * 你需要原地修改栈。
 * <p>
 * 示例1:
 * <p>
 * 输入：A = [2, 1, 0], B = [], C = []
 * 输出：C = [2, 1, 0]
 * 示例2:
 * <p>
 * 输入：A = [1, 0], B = [], C = []
 * 输出：C = [1, 0]
 * 提示:
 * <p>
 * A中盘子的数目不大于14个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hanota-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-10 22:23
 */
public class Hanota {

    public static void main(String[] args) {
        int[] arr = {2, 1, 0};
        ArrayList<Integer> listA = new ArrayList<>();
        listA.addAll(Arrays.asList(2, 1, 0));
        List<Integer> listB = new ArrayList<>();
        List<Integer> listC = new ArrayList<>();

        Hanota obj = new Hanota();
        obj.solutionRecurLC(listA, listB, listC);
        System.out.println(listA.toString());
        System.out.println(listB.toString());
        System.out.println(listC.toString());
    }

    ArrayList<String> res = new ArrayList<>();

    public ArrayList<String> getSolution(int n) {
        // write code here
        recur(n, "left", "right", "mid");
        return res;
    }

    private void recur(int i, String from, String to, String other) {
        if (i == 1) {
            res.add("move from " + from + " to " + to);
            return;
        }
        recur(i - 1, from, other, to);
        res.add("move from " + from + " to " + to);
        recur(i - 1, other, to, from);
    }


    public void solutionRecurLC(List<Integer> A, List<Integer> B, List<Integer> C) {
        recur(A, B, C, A.size());
//        honoi(3, "左", "右", "中");
//        move(A.size(), A, B, C);
    }

    private void recur(List<Integer> from, List<Integer> other, List<Integer> to, int rest) {
        if (rest == 1) {
            Integer one = from.remove(from.size() - 1);
            to.add(one);
            return;
        }
        // 分解子问题
        // 子问题 0~i-1从from移到other
        recur(from, to, other, rest - 1);
        // 移动底元素到to
        Integer one = from.remove(from.size() - 1);
        to.add(one);
        // 子问题 把0~i-1从other移到to
        recur(other, from, to, rest - 1);
    }


    private static void honoi(int i, String from, String to, String other) {
        if (i == 1) {
            System.out.println("1: " + from + "-->" + to);
            return;
        }
        // from --> other
        honoi(i - 1, from, other, to);
        // 正式移动 from --> to
        System.out.println(i + ": " + from + "-->" + to);
        // other --> to
        honoi(i - 1, other, to, from);
    }

}
