package array.partition;

import zhelper.ArrayUtils;

import static zhelper.ArrayUtils.*;

import java.util.Arrays;

/**
 * 把小于等于num的数放在数组的左边
 *
 * @author Shane Tang
 * @create 2019-09-15 21:30
 */
public class My2Partition {

    public static void main(String[] args) {
        int[] arr = {1, 1, 7, 6, 6, 8, 8, 9, 3, 4, 5, 2, 1, 0, 5};
        System.out.println(arr.length);
//        int[] arr = {1,1, 7, 5, 8, 5};
        int lessEqualIndex = simplePartition(arr, 10);
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("lessEqualIndex = " + lessEqualIndex);
    }

    private static int simplePartition(int[] arr, int k) {
        // 从-1开始，因为<=区代表指针及以左的元素，一开始为0个元素
        int lessEqualIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            // 如果[i]<=num，就把它和<=区的下一个数交换，一定要先++lessIndex，然后i++
            if (arr[i] <= k) {
                ArrayUtils.swap(arr, ++lessEqualIndex, i);
            }
            // 否则只i++
        }
        return lessEqualIndex;
    }
/*        // 如果设这个Idx是不包括指针的，但是这样的话输出可能越界，不好看
        int lessEqualIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
                // 后++
                ArrayUtils.swap(arr, lessEqualIdx++, i);
            }
        }
        return lessEqualIdx;*/

}
