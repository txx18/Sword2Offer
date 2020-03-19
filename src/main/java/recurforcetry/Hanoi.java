package recurforcetry;

/**
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-10 22:50
 */
public class Hanoi {

    public static void main(String[] args) {
        honoi(3, "左", "右", "中");
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
