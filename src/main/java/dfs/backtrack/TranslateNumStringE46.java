package dfs.backtrack;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 *
 * 提示：
 *
 * 0 <= num < 231
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-18 21:26
 */
public class TranslateNumStringE46 {

    public static void main(String[] args) {
//        double pow = Math.pow(10, 2);
//        System.out.println("pow = " + pow);
        TranslateNumStringE46 obj = new TranslateNumStringE46();
        int res = obj.translateNum(18580222);
        System.out.println("res = " + res);
    }

    int digitCount;
    int num;

    /**
     * 执行用时 :
     * 0 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗 :
     * 36.3 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param num
     * @return
     */
    public int translateNum(int num) {
        // 从尾到头尝试 i从头开始
        this.digitCount = getDigitCount(num);
        this.num = num;
        return recur( 0);
    }

    /**
     * 获取数字的位数
     * @param num
     * @return
     */
    private int getDigitCount(int num) {
        int res = 0;
        while (num != 0) {
            res++;
            num /= 10;
        }
        return res;
    }

    private int recur(int i) {
        // base case
        if (i == digitCount) {
            return 1;
        }
        int res = 0;
        // 取第i位的值
        int curVal = num / (int)Math.pow(10, digitCount - i - 1) % 10;
        // 如果当前位是1
        if(curVal == 1) {
            // 第一种情况 i自己翻译成一个字母，后面有多少种
            res = recur(i + 1);
            // 第二种情况 i和i+1凑一对，后面有多少种
            if (i + 1 < digitCount) {
                res += recur(i + 2);
            }
        }
        // 如果当前位是2
        else if (curVal == 2) {
            // 第一种情况 i自己翻译成一个字母，后面有多少种
            res = recur(i + 1);
            // 第二种情况 i和i+1凑一对，而且没有超过25，后面有多少种
            if (i + 1 < digitCount){
                int nextVal = num / (int)Math.pow(10, digitCount - i - 2) % 10;
                if (nextVal <= 5) {
                    res += recur(i + 2);
                }
            }
        }
        else {
            // 如果当前位是3~9
            res = recur(i + 1);
        }
        return res;
    }
}
