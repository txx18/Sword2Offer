package sort;

import zhelper.ArrayUtils;


/**
 * 对数器
 *
 * @author Shane Tang
 * @create 2019-09-16 20:31
 */
public class QuickSortV3 {


    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    private static void sortProcess(int[] arr, int l, int r) {
        int[] partitionIndexes = null;
        int pivot = 0;
        if (l < r) {
            // 先partition
            // 快排3.0，利用3段划分，而且从l~r-1随机选一个数
            pivot = l + (int) (Math.random() * (r - l + 1));
            // 把pivot交换到r
            ArrayUtils.swap(arr, pivot, r);
            // 返回 等于区左右边界
            partitionIndexes = partition(arr, l, r);
            // 左边排序，代入小于区域右边界
            sortProcess(arr, l, partitionIndexes[0] - 1);
            // 右边排序，代入大于区域左边界
            sortProcess(arr, partitionIndexes[1] + 1, r);

        }
    }


    /**
     * 荷兰国旗问题
     * 小于区】【待定区（假定等于区）】【大于区
     * 待定区l~(r-1)位置
     *
     * @param arr
     * @param l   待定区左边界
     * @param r   大于区左边界，放基准元，初始位置为arr.length-1
     * @return 等于区域左右边界
     */
    private static int[] partition(int[] arr, int l, int r) {
        // p1小于区右边界，代表小于区，初始为-1
        int p1 = l - 1;
        // p2大于区左边界，代表大于区，初始为arr.length-1
        int p2 = r;
        // 【注意】没有包括基准元
        while (l < p2) {
            if (arr[l] == arr[r]) {
                // 直接扩大等于区域
                l++;
            } else if (arr[l] < arr[r]) {
                // 小于区域右扩压缩等于区域
                ArrayUtils.swap(arr, l++, ++p1);
            } else if (arr[l] > arr[r]) {
                // 大于区域左扩压缩等于区域，注意还要继续判断从右边换来的要不要放到小于区域去，所以不l++
                ArrayUtils.swap(arr, l, --p2);
            }
        }
        // 把基准元换到大于区域左边界位置，这个左边界就变成了等于区域右边界
        ArrayUtils.swap(arr, r, p2);
        // p1 + 1 等于区域左边界，p2 等于区域右边界
        return new int[]{p1 + 1, p2};
    }
}
