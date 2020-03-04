package array.merge;

/**
 * 逆序对
 * 与小和是姊妹题
 *
 * FIXME 应该是没问题，对数器20000size都过了，但是NKOJ只过了50%
 * @author Shane Tang
 * @create 2019-09-14 17:22
 */
public class MyInversePairsE51 {

    private static int[] helpArray;


    public static int InversePairs(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        return getInversePairCount(array, 0, array.length - 1);
//        return solutionByTraverse(array);
    }

    public int reversePairs(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        return getInversePairCount(array, 0, array.length - 1);
//        return solutionByTraverse(array);
    }

    /**
     * 超时
     * @param array
     * @return
     */
    public static int solutionByTraverse(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        int smallSumCnt = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[i]) {
                    smallSumCnt += 1;
                }
            }
        }
        return smallSumCnt;
    }

    private static int getInversePairCount(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = l + ((r - l) >> 1);
        int leftCnt =  getInversePairCount(arr, l, m);
        int rightCnt = getInversePairCount(arr, m + 1, r);
        int mergeCnt = mergeProcessCount(arr, l, m, r);
        return leftCnt + rightCnt + mergeCnt;
    }

    private static int mergeProcessCount(int[] arr, int l, int m, int r) {
        helpArray = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int reverseOrderCount = 0;
        while (p1 <= m && p2 <= r) {
            // merge变体2：左组有多少个比右组大
            reverseOrderCount += arr[p1] > arr[p2] ? (m - p1 + 1): 0;
            // 等于时
            helpArray[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
/*            if (arr[p1] > arr[p2]) {
                reverseOrderCount += m - p1 + 1;
                helpArray[i++] = arr[p2++];
            } else {
                helpArray[i++] = arr[p1++];
            }*/
/*//如果前面的元素小于后面的不能构成逆序对
            if(arr[p1] <= arr[p2]) {
                helpArray[i++] = arr[p1++];
            } else{
//如果前面的元素大于后面的，那么在前面元素之后的元素都能和后面的元素构成逆序对
                helpArray[i++] = arr[p2++];
                reverseOrderCount = (reverseOrderCount + (m-i+1))%1000000007;
            }*/
        }
        while (p1 <= m) {
            helpArray[i++] = arr[p1++];
        }
        while (p2 <= r) {
            helpArray[i++] = arr[p2++];
        }
        // arr从l开始把helpArr拷贝回去
        for (i = 0; i < helpArray.length; i++) {
            arr[l + i] = helpArray[i];
        }
        return reverseOrderCount;
    }

}
