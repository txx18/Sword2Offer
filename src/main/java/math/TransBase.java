package math;

/**
 * 描述
 * 给定一个十进制数M，以及需要转换的进制数N。将十进制数M转化为N进制数
 *
 * @author ShaneTang
 * @create 2021-05-27 13:43
 */
public class TransBase {

    public static void main(String[] args) {
        TransBase obj = new TransBase();
//        String res = obj.solve(7, 2);
//        String res = obj.solve(23, 12);
        String res = obj.solve(-4, 3);
        System.out.println("res = " + res);
    }

    public TransBase() {

    }

    public String solve(int M, int N) {
        // write code here
        int cur = M;
        if (M < 0) {
            cur = -M;
        }
        StringBuilder sb = new StringBuilder();
        while (cur != 0) {
            int mod = cur % N;
//            String trans;
            char trans;
            if (mod > 10) {
                trans = toLetterChar(mod);
                sb.append(trans);
            } else {
                sb.append(mod);
            }
            cur /= N;
        }
        StringBuilder tmp = sb.reverse();
        if (M < 0) {
            tmp.insert(0, '-');
        }
        return tmp.toString();
    }

    private String toLetterString(int num) {
        int offset = num - 10;
        return String.valueOf((char) ('A' + offset));
    }

    private char toLetterChar(int num) {
        int offset = num - 10;
        return (char) ('A' + offset);
    }
}
