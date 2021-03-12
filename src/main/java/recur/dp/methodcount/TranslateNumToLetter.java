package recur.dp.methodcount;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= num < 231
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-18 21:26
 */
public class TranslateNumToLetter {

    public static void main(String[] args) {
//        double pow = Math.pow(10, 2);
//        System.out.println("pow = " + pow);
        TranslateNumToLetter obj = new TranslateNumToLetter();
        int res = obj.solutionRecurLC(506);
        System.out.println("res = " + res);
    }

    char[] chars;

    /**
     * 通过NK
     *
     * @param nums
     * @return
     */
    public int solutionRecur(String nums) {
        // write code here
        if (nums == null || nums.length() == 0) {
            return 0;
        }
        chars = nums.toCharArray();
        return dpNK(0);
//        cache = new int[nums.length() + 1];
//        return recurCache(0);
    }

    public int solutionRecurLC(int num) {
        // write code here
        chars = String.valueOf(num).toCharArray();
        return dpLC(0);
    }

    /**
     * 通过LC
     *
     * @param index
     * @return
     */
    private int dpLC(int index) {
        if (index == chars.length) {
            return 1;
        }
        int res = dpLC(index + 1);
        if (index == chars.length - 1) {
            return res;
        }
        int tmp = (chars[index] - '0') * 10 + chars[index + 1] - '0';
        if (tmp >= 10 && tmp <= 25) {
            res += dpLC(index + 2);
        }
        return res;
    }


    /**
     * 从 index 位置出发，有多少种方式
     * 之前的位置不管！
     *
     * @param index
     * @return
     */
    private int dpNK(int index) {
        // 试到最后一个，找到一个解
        if (index == chars.length) {
            return 1;
        }
        int res = dpNK(index + 1);
        if (index == chars.length - 1) {
            return res;
        }
        int tmp = (chars[index] - '0') * 10 + chars[index + 1] - '0';
        if (tmp <= 26) {
            res += dpNK(index + 2);
        }
        return res;
/*        // 遇到0，整体接下来 i位置 之后不会产生新的结果
        if (chars[index] == '0') {
            return 0;
        }
        if (chars[index] == '1') {
            // 单个数字的选择
            int res = dp(index + 1);
            // 两个数字结合的选择
            if (index + 1 < chars.length) {
                res += dp(index + 2);
            }
            return res;
        }
        if (chars[index] == '2') {
            // 单个数字的选择
            int res = dp(index + 1);
            // 两个数字结合的选择
            if (index + 1 < chars.length && (chars[index] >= '0' && chars[index + 1] <= '6')) { // 注意
                res += dp(index + 2);
            }
            return res;
        }
        // '3' ~ '9'，单个数字的选择
        return dp(index + 1);*/
/*        res = recur(index + 1);
        return res;*/
    }

    int[] cache;

    /**
     * 通过NK
     *
     * @param i
     * @return
     */
    private int recurCache(int i) {
        if (i == chars.length) {
            cache[i] = 1;
            return cache[i];
        }
        if (chars[i] == '0') {
            cache[i] = 0;
            return cache[i];
        }
        if (chars[i] == '1') {
            cache[i] = recurCache(i + 1);
            if (i + 1 < chars.length) {
                cache[i] += dpNK(i + 2);
            }
            return cache[i];
        }
        if (chars[i] == '2') {
            cache[i] = recurCache(i + 1);
            if (i + 1 < chars.length && (chars[i] >= '0' && chars[i + 1] <= '6')) { // 注意
                cache[i] += recurCache(i + 2);
            }
            return cache[i];
        }
        cache[i] = recurCache(i + 1);
        return cache[i];
    }

    /**
     * 通过NK
     *
     * @param nums
     * @return
     */
    public int solutionDpTable(String nums) {
        // write code here
        if (nums == null || nums.length() == 0) {
            return 0;
        }
        int N = nums.length();
        // recur.dp: [0..index]的解的个数
        int[] dp = new int[N + 1];
        dp[N] = 1;
        // 注意遍历顺序，已知 下标N，要推下标0，应该逆序遍历
        for (int i = N - 1; i >= 0; i--) { // 从N-1开始，不能越界
            if (nums.charAt(i) == '0') {
                dp[i] = 0;
            } else if (nums.charAt(i) == '1') {
                dp[i] = dp[i + 1];
                if (i + 1 < N) {
                    dp[i] += dp[i + 2];
                }
            } else if (nums.charAt(i) == '2') {
                dp[i] = dp[i + 1];
                if (i + 1 < N && (nums.charAt(i) >= '0' && nums.charAt(i + 1) <= '6')) { // 注意
                    dp[i] += dp[i + 2];
                }
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }


    int digitCount;
    int num;


    public int translateNum(int num) {
        // 从尾到头尝试 i从头开始
        this.digitCount = getDigitCount(num);
        this.num = num;
        return recurNum(0);
    }

    /**
     * 获取数字的位数
     *
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

    private int recurNum(int i) {
        // base case
        if (i == digitCount) {
            return 1;
        }
        int res = 0;
        // 取第i位的值
        int curVal = num / (int) Math.pow(10, digitCount - i - 1) % 10;
        // 如果当前位是1
        if (curVal == 1) {
            // 第一种情况 i自己翻译成一个字母，后面有多少种
            res = recurNum(i + 1);
            // 第二种情况 i和i+1凑一对，后面有多少种
            if (i + 1 < digitCount) {
                res += recurNum(i + 2);
            }
        }
        // 如果当前位是2
        else if (curVal == 2) {
            // 第一种情况 i自己翻译成一个字母，后面有多少种
            res = recurNum(i + 1);
            // 第二种情况 i和i+1凑一对，而且没有超过25，后面有多少种
            if (i + 1 < digitCount) {
                int nextVal = num / (int) Math.pow(10, digitCount - i - 2) % 10;
                if (nextVal <= 5) {
                    res += recurNum(i + 2);
                }
            }
        } else {
            // 如果当前位是3~9
            res = recurNum(i + 1);
        }
        return res;
    }
}
