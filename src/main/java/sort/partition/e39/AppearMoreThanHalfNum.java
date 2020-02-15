package sort.partition.e39;

/**
 * 找出现次数超过一半的数
 * 转化为：找中位数，而且确实得超过一半
 *
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-09 15:08
 */
public class AppearMoreThanHalfNum {

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] arr2 = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        int[] arr3 = {1};
        int[] arr4 = {2,2,2,2,2,1,3,4,5};
        int res = MoreThanHalfNum_Solution(arr4);
        System.out.println("res = " + res);
    }

    public static int MoreThanHalfNum_Solution(int[] array) {
        // 元素个数为1的时候可不是返回0
        if (array == null || array.length < 1) {
            return 0;
        }
//        return sortProcessRecur(array, 0, array.length - 1);
        return sortProcessLoop(array, 0, array.length - 1);
    }

    private static int sortProcessLoop(int[] arr, int l, int r) {
        int lessEqualIdx = partition(arr, l, r);
        for (; l <= r; ) {
            int pivot = l + (int) (Math.random() * (r - l + 1));
//            System.out.println("arr[pivot] = " + arr[pivot]);
            swap(arr, pivot, r);
//            System.out.println("equalLeftIdx = " + lessEqualIdx);
            if (lessEqualIdx < (arr.length >> 1)) {
                lessEqualIdx = partition(arr, lessEqualIdx + 1, r);
            } else if (lessEqualIdx > (arr.length >> 1)) {
                lessEqualIdx = partition(arr, l, lessEqualIdx - 1);
            } else {
                int candidate = arr[lessEqualIdx];
                boolean isMoreThanHalf = checkMoreThanHalf(arr, candidate);
                if (isMoreThanHalf) {
                    return candidate;
                }
                return 0;
            }
        }
        return 0;
    }

    /**
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static int sortProcessRecur(int[] arr, int l, int r) {
        if (l > r) {
            return 0;
        }
        int pivot = l + (int) (Math.random() * (r - l + 1));
        System.out.println("arr[pivot] = " + arr[pivot]);
        swap(arr, pivot, r);
        int lessEqualIdx = partition(arr, l, r);
        System.out.println("equalLeftIdx = " + lessEqualIdx);
        if (lessEqualIdx < (arr.length >> 1)) {
            return sortProcessRecur(arr, lessEqualIdx + 1, r);
        } else if (lessEqualIdx > (arr.length >> 1)) {
            return sortProcessRecur(arr, l, lessEqualIdx - 1);
        } else {
            int candidate = arr[lessEqualIdx];
            boolean isMoreThanHalf = checkMoreThanHalf(arr, candidate);
            if (isMoreThanHalf) {
                return candidate;
            }
        }
        return 0;
    }

    private static boolean checkMoreThanHalf(int[] arr, int candidate) {
        int times = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == candidate) {
                times++;
            }
        }
        return times > (arr.length >> 1);
    }

    private static int partition(int[] arr, int l, int r) {
        int lessEqualIdx = l - 1;
        for (; l <= r; l++) {
            if (arr[l] <= arr[r]) {
                // 只靠小于等于区域右扩
                swap(arr, ++lessEqualIdx, l);
            }
        }
        return lessEqualIdx;
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        // 异或方法i不能等于j
/*        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];*/
    }
}
