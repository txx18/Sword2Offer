package string;

/**
 * @author ShaneTang
 * @create 2021-02-04 22:18
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        ReplaceSpace obj = new ReplaceSpace();
        String res = obj.twoPointer(new StringBuffer(" We Are Happy "));
//        String res = obj.twoPointer(new StringBuffer("hello  world"));
        System.out.println("res = " + res);
    }

    public String twoPointer(StringBuffer str) {
        int p1 = str.length() - 1;
        for (int i = 0; i <= p1; i++) {
            if (str.charAt(i) == ' ') {
                str.append(" ");
            }
        }
        int p2 = str.length() - 1;
        while (p1 >= 0 && p1 < p2) {
            char c = str.charAt(p1--);
            if (c == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, c);
            }
        }
        return str.toString();
    }


    public String replaceStringAPI(StringBuffer str) {
        return str.toString().replaceAll(" ", "%20");
    }

    public String replaceStringBufferAPI(StringBuffer str) {
        if (str.length() == 0) {
            return "";
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                str.replace(i, i + 1, "%20");
                i += 2;
            }
        }
        return str.toString();
    }


}
