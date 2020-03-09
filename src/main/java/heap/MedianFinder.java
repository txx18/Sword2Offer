package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 * <p>
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 * <p>
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 *  
 * <p>
 * 限制：
 * <p>
 * 最多会对 addNum、findMedia进行 50000 次调用。
 * 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-stream/
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 执行用时 :
 * 73 ms
 * , 在所有 Java 提交中击败了
 * 94.61%
 * 的用户
 * 内存消耗 :
 * 55.8 MB
 * , 在所有 Java 提交中击败了
 * 100.00%
 * 的用户
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-03-09 16:10
 */
public class MedianFinder {

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();

        obj.addNum(6);
        obj.addNum(10);
        obj.addNum(2);
//        obj.addNum(4);

        double res = obj.findMedian();
        System.out.println("res = " + res);
    }

    /**
     * 小根堆维护一半大数
     */
    PriorityQueue<Integer> SPQ;
    /**
     * 大根堆维护一半小数
     */
    PriorityQueue<Integer> BPQ;


    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        SPQ = new PriorityQueue<>();
        BPQ = new PriorityQueue<>(new DESCComparator<Integer>());
    }

    public void addNum(int num) {
        if (SPQ.isEmpty()) {
            // 放进小根堆
            SPQ.offer(num);
            return;
        }
        // 如果num >= SPQ堆顶（是大数），入SPQ，否则入BPQ
        if (num >= SPQ.peek()) {
            SPQ.offer(num);
        } else {
            BPQ.offer(num);
        }
        // 如果小根堆里的数Count 和 大根堆里的数Count 相差 > 1，就把堆顶放进大根堆
        if (SPQ.size() - BPQ.size() > 1) {
            BPQ.add(SPQ.poll());
        }
        if (BPQ.size() - SPQ.size() > 1) {
            SPQ.add(BPQ.poll());
        }
    }

    public double findMedian() {
        int totalSize = SPQ.size() + BPQ.size();
        if (totalSize == 0) {
            return 0;
        }
        // 偶数个
        if (totalSize % 2 == 0) {
            double SPQMin = SPQ.peek();
            double BPQMax = BPQ.peek();
            return ((SPQMin + BPQMax) / 2);
        }
        // 奇数个
        return SPQ.size() > BPQ.size() ? SPQ.peek() : BPQ.peek();
    }

    private class DESCComparator<T> implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */

