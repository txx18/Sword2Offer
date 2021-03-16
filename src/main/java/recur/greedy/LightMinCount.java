package recur.greedy;

/**
 * @author ShaneTang
 * @create 2021-03-13 11:07
 */
public class LightMinCount {

    public static void main(String[] args) {
        LightMinCount obj = new LightMinCount();
        int res = obj.solutionGreedy("...XX....XX");
        System.out.println("res = " + res);
    }

    public int solutionGreedy(String str) {
        char[] chars = str.toCharArray();
        int res = 0;
        int i = 0;
        while (i < chars.length) {
            if (chars[i] == 'X') {
                i++;
            } else { // str[i] == '.'
                res++;
                if (i + 1 == chars.length) {
                    break;
                } else {
                    if (chars[i + 1] == 'X') {
                        i += 2;
                    } else if (chars[i + 1] == '.') {
                        i += 3;
                    }
                }
            }

        }
        return res;
    }
}
