package binarysearch.e53;

/**
 * 找元素为0~N-1，长度为n-1数组中未出现的那个数字
 * 转化为：找第1个下标不等于值的那个数
 * @author Shane Tang
 * @version V1.0
 * @create 2020-02-06 16:39
 */
public class NotAppearNum {

    /**
     * 通过stoTest
     * @param arr
     * @return
     */
    public static int solutionByBinarySearch(int[] arr) {
        if (arr == null){
            return -1;
        }
        int l = 0, r = arr.length - 1, mid = -1;
        for (; l <= r; ) {
            mid = l + ((r - l) >> 1);
            if (arr[mid] > mid) {
                if (mid == 0 || arr[mid - 1] == mid - 1){
                    return mid;
                }
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
            if (l == arr.length){
                return arr.length;
            }
        }
        return -1;
    }

    public static int solutionByTraverse(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i) {
                return arr[i] - 1;
            }
        }
        return -1;
    }
}
