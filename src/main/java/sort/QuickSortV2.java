package sort;

import java.util.Arrays;


/**
 * 对数器
 *
 * @author Shane Tang
 * @create 2019-09-16 20:31
 */
public class QuickSortV2 {

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            quickSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);

        System.out.print("生成：");
        printArray(arr);
        int[] partitionIndexes = quickSort(arr);
        System.out.print("测试：");
        printArray(arr);
        System.out.println("separationIndexes = " + Arrays.toString(partitionIndexes));

    }

    private static int[] quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }

        return sortProcess(arr, 0, arr.length - 1); // 初始的l和r是arr的左右
    }

    private static int[] sortProcess(int[] arr, int l, int r) {
        int[] partitionIndexes = null;
        if(l < r) {
            // 先partition
            // 快排2.0，利用3段划分
            partitionIndexes = partition(arr, l, r);
            // 左边排序
            sortProcess(arr, l, partitionIndexes[0]);
            // 右边排序
            sortProcess(arr, partitionIndexes[1], r);

        }
        return partitionIndexes;
    }


    private static int[] partition(int[] arr, int l, int r){
        int lessIndex = l - 1;
        int moreIndex = r;
        int i = l;
        while (i < moreIndex){ // 【注意】没有包括基准元
            if(arr[i] == arr[r]){
                // 直接扩大等于区域
                i++;
            }else if(arr[i] < arr[r]){
                // 小于区域右扩压缩待定区域
                swap(arr, ++lessIndex, i++);
            }else { // > arr[r]
                // 大于区域左扩压缩待定区域，注意还要继续判断从右边换来的要不要放到小于区域去，所以不i++
                swap(arr, --moreIndex, i);
            }
        }
        // 把基准元换到moreIndex位置
        swap(arr, moreIndex, r);
        return new int[] {lessIndex, moreIndex}; // 【一定】
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
