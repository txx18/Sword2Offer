package recur.dp.methodcount;


/**
 * 象棋中马的跳法
 * 【题目】
 * 请同学们自行搜索或者想象一个象棋的棋盘，然后把整个棋盘放入第一象限，棋盘的最左下
 * 角是(0,0)位置。那么整个棋盘就是横坐标上9条线、纵坐标上10条线的一个区域。给你三个
 * 参数，x，y，k，返回如果“马”从(0,0)位置出发，必须走k步，最后落在(x,y)上的方法数
 * 有多少种？
 *
 * @author ShaneTang
 * @create 2021-03-11 21:07
 */
public class HorseJump {

    public static void main(String[] args) {
        HorseJump obj = new HorseJump();
        int res = obj.dp(5, 5, 5);
        System.out.println("res = " + res);
    }

    int ROW = 9;
    int COL = 10;

    private int dp(int x, int y, int rest) {
        if (x < 0 || x >= ROW || y < 0 || y >= COL || rest < 0) {
            return 0;
        }
        if (rest == 0) {
            return x == 0 && y == 0 ? 1 : 0;
        }
        // 倒着推递归，或者考虑这个和从(x, y)跳到(0, 0)就是等价的
        return dp(x - 1, y + 2, rest - 1) +
                dp(x - 2, y + 1, rest - 1) +
                dp(x - 2, y - 1, rest - 1) +
                dp(x - 1, y - 2, rest - 1) +
                dp(x + 1, y - 2, rest - 1) +
                dp(x + 2, y - 1, rest - 1) +
                dp(x + 2, y + 1, rest - 1) +
                dp(x + 1, y + 2, rest - 1);

    }
}
