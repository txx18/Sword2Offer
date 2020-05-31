package sort;

import zhelper.ArrayUtils;

import java.util.Arrays;


/**
 * 对数器
 *
 * @author Shane Tang
 * @create 2019-09-16 20:31
 */
public class QuickSortV1 {

    // for test
    public static void main(String[] args) {
        int[] arr1 = {4,5,1,6,2,7,3,8, 4};
        int partition = simplePartition(arr1, 0, arr1.length - 1);
        System.out.println("partition = " + partition);
    }

    private static int quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }
        return sortProcess(arr, 0, arr.length - 1); // 初始的l和r是arr的左右
    }

    /**
     * 把最右边那个数当作num
     * @param arr
     * @param l
     * @param r
     * @return num该放的位置
     */
    private static int sortProcess(int[] arr, int l, int r) {
        int lessEqualIndex = -1;
        if (l < r) { // 【不是while】
            // 先partition
            // 快排1.0，利用两段划分，注意r取的都是最右边的数
            lessEqualIndex = simplePartition(arr, l, r);
            // 左边排序
            sortProcess(arr, l, lessEqualIndex - 1);
            // 右边排序
            sortProcess(arr, lessEqualIndex + 1, r);

        }
        return lessEqualIndex;
    }


    /**
     * 利用simplePartition
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int simplePartition(int[] arr, int l, int r){
        int lessEqualIdx = l - 1;
        for (; l <= r; l++){ //注意arr[r]也要判断
            if(arr[l] <= arr[r]){
                // 只靠小于等于区域右扩
                ArrayUtils.swap(arr, ++lessEqualIdx, l);
            }
        }
        return lessEqualIdx;
    }

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
