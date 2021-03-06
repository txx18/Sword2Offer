package sort;

import java.util.Arrays;


/**
 * TO DO
 *
 * @author Shane Tang
 * @create 2019-09-16 20:31
 */
public class MyQuickSortV3 {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(Arrays.toString(arr1));
        MyQuickSortV3 obj = new MyQuickSortV3();
        obj.MySort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public int[] MySort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        return recurProcess(arr, 0, arr.length - 1);
    }


    private int[] recurProcess(int[] arr, int l, int r) {
        if (l >= r) {
            return arr;
        }
        // 先partition
        // 快排3.0，利用3段划分，而且从l~r-1随机选一个数
        int pivotIdx = l + (int) (Math.random() * (r - l + 1));
        // 把pivot交换到r
        swap(arr, pivotIdx, r);
        // 返回 等于区左右边界
        int[] partitionIdxes = threePartition(arr, l, r);
        // 递归调用  左边排序，代入小于区域右边界
        recurProcess(arr, l, partitionIdxes[0] - 1);
        // 递归调用 右边排序，代入大于区域左边界
        recurProcess(arr, partitionIdxes[1] + 1, r);
        return arr;
    }

    private int[] threePartition(int[] arr, int l, int r) {
        int pivotVal = arr[r];
        // 小于区右边界
        int lessRight = l - 1;
        // 大于区左边界
        int greatLeft = r;
        // 指针
        for (int i = l; i < greatLeft; ) { // < 大于区左边界
            if (arr[i] < pivotVal) {
                swap(arr, i++, ++lessRight);
            } else if (arr[i] > pivotVal) {
                // i不++因为换过来的arr[greatLeft-1]还没判断
                swap(arr, i, --greatLeft);
            } else { // == num
                i++;
            }
        }
        // 交换 大于区域左边界 和 r位置，大于区域左边界变成了等于区域右边界
        swap(arr, greatLeft, r);
        return new int[]{lessRight + 1, greatLeft};
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        // 异或方法i不能等于j
/*        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];*/
    }

}
