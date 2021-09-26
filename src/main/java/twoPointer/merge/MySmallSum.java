package twoPointer.merge;

/**
 * 小和问题
 *
 * @author Shane Tang
 * @create 2019-09-14 10:54
 */
public class MySmallSum {

    public static int solution(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return getSmallSum(arr, 0, arr.length - 1);

    }

    public static int solutionByTraverse(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        int smallSum = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    smallSum += array[j];
                }
            }
        }
        return smallSum;
    }

    private static int getSmallSum(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = l + ((r - l) >> 1);
        return getSmallSum(arr, l, m) + getSmallSum(arr, m + 1, r) + mergeProcessSum(arr, l, m, r);
    }


    private static int mergeProcessSum(int[] arr, int l, int m, int r) {
        int[] helpArray = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int smallSum = 0;
        while (p1 <= m && p2 <= r) {
            // 转化为merge时右组比左组大的个数
            smallSum += arr[p1] < arr[p2] ? arr[p1] * (r - p2 + 1) : 0;
            // 必须严格小于，等于时先拷贝右组，移动指针，到时候拷贝左组时不产生小和
            // 如果等于时先拷贝左组的话，那右组的还在，是不应该被计入个数产生小和的
            helpArray[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            helpArray[i++] = arr[p1++];
        }
        while (p2 <= r) {
            helpArray[i++] = arr[p2++];
        }
        for (i = 0; i < helpArray.length; i++) {
            arr[l + i] = helpArray[i];
        }
        return smallSum;
    }
}
