package array.merge;

/**
 * 逆序对
 * 与小和是姊妹题
 * <p>
 * FIXME 应该是没问题，对数器20000size都过了，但是NKOJ只过了50%
 *
 * @author Shane Tang
 * @create 2019-09-14 17:22
 */
public class MyInversePairs {

    public static void main(String[] args) {
        MyInversePairs obj = new MyInversePairs();
        int res = obj.InversePairs(new int[]{364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407, 416, 366, 315, 301,
                601, 650, 418, 355, 460, 505, 360, 965, 516, 648, 727});
        System.out.println("res = " + res);
    }

    long res;

    public int InversePairs(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        return getInversePairCount(array, 0, array.length - 1);
//        return solutionByTraverse(array);
    }


    private int getInversePairCount(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int m = l + ((r - l) >> 1);
        int leftCnt = getInversePairCount(arr, l, m);
        int rightCnt = getInversePairCount(arr, m + 1, r);
        int mergeCnt = mergeProcessCount(arr, l, m, r);
//        return leftCnt + rightCnt + mergeCnt;
        return (int)(res % 1000000007);
    }

    private int mergeProcessCount(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
//        int res = 0;
        while (p1 <= m && p2 <= r) {
            // merge变体2：左组有多少个比右组大
/*            res += arr[p1] > arr[p2] ? (m - p1 + 1)  : 0;
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];*/
/*            if (arr[p1] > arr[p2]) {
                res += m - p1 + 1;
                helpArray[i++] = arr[p2++];
            } else {
                helpArray[i++] = arr[p1++];
            }*/
            //如果前面的元素小于后面的不能构成逆序对
            if (arr[p1] <= arr[p2]) {
                help[i++] = arr[p1++];
            } else {
                //如果前面的元素大于后面的，那么在前面元素之后的元素都能和后面的元素构成逆序对
                help[i++] = arr[p2++];
                res = (res + (m - i + 1)) % 1000000007;
            }
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        // arr从l开始把helpArr拷贝回去
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return (int)(res % 1000000007);
    }

    /**
     * 超时
     *
     * @param array
     * @return
     */
    public int solutionByTraverse(int[] array) {
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

}
