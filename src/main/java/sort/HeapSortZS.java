package sort;

import static zhelper.ArrayUtils.*;

/**
 * @author Shane Tang
 * @create 2019-09-24 19:25
 */
public class HeapSortZS {

    // index 为 i 的结点，
    // 左孩子2*i+1，
    // 右孩子2*i+2，
    // 父亲结点(i-1)/2

    /**
     * 主过程
     *
     * @param arr
     */
    public static void solution(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        // 设置堆结构的大小
        int heapSize = arr.length;
        // 调整成大根堆，两种方法
/*        // 【方法1】从左到右heapInsert 时间复杂度O(NlogN)
        for (int i = 0; i < heapSize; i++) {
            heapInsert(arr, i);
        }*/
        // 【方法二】从右到左heapify 时间复杂度O(N)
        // 1、从最后一个元素开始向前循环heapify，把数组变成大根堆，这是堆排序的前提
        for (int i = heapSize - 1; i >= 0; i--) {
            heapify(arr, i, heapSize);
        }
        // 交换堆顶和最后一个数，最大值从第一个数换到了最后一个数，弹出一个最大值，放在最右边
        // 注意--heapSize
        swap(arr, 0, --heapSize);
        // 当堆结构还存在时
        while (heapSize > 0) {
            // 让剩下的数调整成大根堆
            heapify(arr, 0, heapSize);
            // 交换堆顶和最后一个数，最大值从第一个数换到了最后一个数，弹出一个最大值，逐渐减小堆的大小，让最大值跟堆结构断联
            swap(arr, 0, --heapSize);
        }
    }

    /**
     * 【前提】本来是一个大根堆，任意index位置发生了改变，不是大根堆了
     * 堆化的前提是是完全二叉树并且只有一个地方不满足堆的条件，
     * 堆化是从上往下
     * 【应用】堆排序用到的就是index = 0位置以下建堆，返回最大值之后，让剩下的数调整成大根堆
     *
     * @param arr
     * @param index    发生改变破坏大根堆的位置
     * @param heapSize 堆结构的大小，不是整个数组的大小
     */
    private static void heapify(int[] arr, int index, int heapSize) {
        // 左孩子
        int left = 2 * index + 1;
        // 判断index有左孩子
        while (left < heapSize) {
            // 记录父子中的最大值
            // 在俩孩子中选一个最大的
            // 如果右孩子没越界且大于左孩子，右孩子给largest，否则左孩子给largest
            // 注意这个逻辑，一定是&&
            int largest = (left + 1 < heapSize) && (arr[left + 1] > arr[left]) ? left + 1 : left;
            // 再和老爸比一比，大的给largest.
            largest = arr[largest] > arr[index] ? largest : index;
            // 如果老爸就是包括他和孩子中的最大值
            if (largest == index) {
                // 停止循环
                break;
            }
            // 把最大值给index
            swap(arr, largest, index);
            // index往下走
            index = largest;
            // 如果一开始设置了左孩子指针，则也要移动
            left = index * 2 + 1;
        }
    }


    /**
     * 一个一个地给数的情况，形成大根堆
     * 要么往上走，要么停住
     *
     * @param arr
     * @param index 插入的index
     */
    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
}
