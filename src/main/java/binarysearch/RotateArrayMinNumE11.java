package binarysearch;

/**
 * 旋转数组的最小数字
 *把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author Shane Tang
 * @create 2019-10-07 10:45
 */
public class RotateArrayMinNumE11 {

    public static void main(String[] args) {
        int[] rotateArr1 = {21, 23, 28, 30, 32, 50, 64, 78, 81, 95, 101, 3, 5, 11, 17};
        int[] rotateArr2 = {3, 5, 11, 17, 21, 23, 28, 30, 32, 50, 64, 78, 81, 95, 101, 2};
        // {0, 1, 1, 1, 1}
        int[] rotateArr3 = {1, 0, 1, 1, 1};
        int[] rotateArr4 = {1, 1, 1, 0, 1};
        int[] rotateArr5 = {1, 3, 5};
        int res = minArray(rotateArr1);
        System.out.println("res = " + res);
    }


    public static int BSLoop(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int l = 0, r = array.length - 1;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (array[l] == array[m] && array[m] == array[r]) {
                return findByTraverse(array, l, r);
            }
            // 右边是非递减数组，target在左边
            else if (array[m] <= array[r]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return array[l];
    }

    public static int BSLoop1(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int l = 0, r = array.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (array[l] == array[mid] && array[mid] == array[r]) {
                return findByTraverse(array, l, r);
            }
             else if (array[l] <= array[mid]){
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return array[l];
    }

    private static int findByTraverse(int[] array, int l, int r) {
        for (int i = l; i < r; i++) {
            if (array[i + 1] < array[i])
                return array[i + 1];
        }
        return array[l];
    }

    private static int findByTraverse2(int[] array, int l, int r) {
        int minIndex = l;
        for (int i = l + 1; i <= r; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }
        return array[minIndex];
    }

    /**
     * NK
     *
     * @param array
     * @return
     */
    public static int minNumberInRotateArray(int[] array) {
//        return solutionBSLoop(array);
//        return solutionBSRecur(array, 0, array.length - 1);
        return BSLoop(array);
    }

    /**
     * LC
     *
     * @param numbers
     * @return
     */
    public static int minArray(int[] numbers) {
//        return stoSolutionBSLoop(numbers);
        return solutionBSRecurME(numbers, 0, numbers.length - 1);
    }

    /**
     * 执行用时 :
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 51.78%
     * 的用户
     * 内存消耗 :
     * 39.3 MB
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * @param array
     * @param l
     * @param r
     * @return
     */
    public static int solutionBSRecurME(int[] array, int l, int r) {
        if (array == null || array.length == 0) {
            return 0;
        }
        if (array[l] < array[r]) {
            return array[l];
        }
        if (r - l == 1) {
            return array[r];
        }
        int mid = l + ((r - l) >> 1);
        // 如果一开始中间和两边的数相等，只能采用遍历的方式找最小值
        if (array[mid] == array[l] && array[mid] == array[r]) {
            return findByTraverse(array, l, r);
        }
        // 否则递归
        // 这里比较保守
        if (array[mid] >= array[l]) {
            return solutionBSRecurME(array, mid, r);
        } else if (array[mid] <= array[r]) {
            return solutionBSRecurME(array, l, mid);
        }
        return -1;
    }

    public static int solutionBSLoopSTO(int[] rotateArr) {
        if (rotateArr == null || rotateArr.length == 0) {
            return -1;
        }
        int l = 0, r = rotateArr.length - 1;
        // 移动0个数的特殊情况，返回l
        int mid = l;
        // 一般来说l值大于等于r值
        while (rotateArr[l] >= rotateArr[r]) {
            // 停在r指针处
            if (r - l == 1) {
                return rotateArr[r];
            }
            mid = l + ((r - l) >> 1);
            // 如果一开始中间和两边的数相等，只能采用遍历的方式找最小值
            if (rotateArr[mid] == rotateArr[l] && rotateArr[mid] == rotateArr[r]) {
                return findByTraverse(rotateArr, l, r);
            }
            // 一般情况
            if (rotateArr[mid] >= rotateArr[l]) {
                l = mid;
            } else if (rotateArr[mid] <= rotateArr[r]) {
                r = mid;
            }
        }
        return rotateArr[mid];
    }
}
