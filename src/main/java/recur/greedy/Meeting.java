package recur.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。
 给你每一个项目开始的时间和结束的时间(给你一个数 组，里面是一个个具体
 的项目)，你来安排宣讲的日程，要求会议室进行的宣讲的场次最多。
 返回这个最多的宣讲场次。
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-06 11:43
 */
public class Meeting {

    public static void main(String[] args) {
//        events = [[1,2],[2,3],[3,4]]
        int[][] events = {{2, 5}, {0, 2}, {3, 4}, {1, 3}, {2, 3}};

        Meeting obj = new Meeting();
//        int maxCount = obj.maxCount(events, 0, 4);
//        System.out.println("maxCount = " + maxCount);

        List<int[]> res = obj.arrange(events, 0, 4);
        for (int[] event : res) {
            System.out.print(Arrays.toString(event) + " ");
        }
    }




    private int maxCount(int[][] events, int start, int end) {
        // 按照所有会议的结束时间升序排序
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int res = 0;
        // 遍历所有会议
        for (int i = 0; i < events.length; i++) {
            // 选择最早结束的先开
            // 结束后选择没有冲突的且最早结束的
            if (start <= events[i][0] && events[i][1] <= end) {
                res++;
                start = events[i][1];
            }

        }
        return res;
    }

    private List<int[]> arrange(int[][] events, int start, int end) {
        if (start >= end) {
            return new ArrayList<>();
        }
        // 按照所有会议的结束时间升序排序
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        ArrayList<int[]> res = new ArrayList<int[]>(events.length);
        // 遍历所有会议
        for (int i = 0; i < events.length; i++) {
            // 选择最早结束的先开
            // 结束后选择没有冲突的且最早结束的
            if (start <= events[i][0] && events[i][1] <= end) {
                res.add(events[i]);
                start = events[i][1];
            }

        }
        return res;
    }
}
