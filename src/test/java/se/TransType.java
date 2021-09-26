package se;

import org.junit.Test;

/**
 * @author ShaneTang
 * @create 2021-05-27 14:27
 */
public class TransType {

    @Test
    public void charAddInt() {
        char c = 'A'; // 'A' 65
        int aInt = c; // 65
        char c1 = (char) (c + 1); // 'B' 66
        char i0 = 8 + '1'; // 'B' 66
        // char参与运算都自动变成ASCII码的int运算
        int i1 = '9' + '0'; // 105
        int sub = '9' - '0'; // 9  '9'的ASCII码为57，'0'的ASCII码为48
        char subChar = (char) 9; // '\t' '\t'的ASCII码为9
        int tmp2 = '9' + '0'; // 105  '0'的ASCII码为48
        // 相加就不是了
        System.out.println("c1 = " + c1);
    }

    @Test
    public void charToInt() {
        char c = 'A'; // 调试器显示：   c: 'A' 65
        int i = c;
        System.out.println("c = " + c); // c = A
        System.out.println("i = " + i); // i = 65
    }

    @Test
    public void intToChar() {
        int i = 65;
        char c = (char) i;
        System.out.println("c = " + c); // c = A
    }

    @Test
    public void otherToString() {
        int i = 65;
        boolean b = false;
        char c = 'A';
        double d = 3.14;
        float f = (float) 3.1;
//        String s = String.valueOf(i); // 65
//        String s = String.valueOf(b); // false
//        String s = String.valueOf(c); // A
        String s = String.valueOf(d); // A
        System.out.println("s = " + s);
    }
}
