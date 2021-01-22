package array.merge;

/**
 * @author ShaneTang
 * @create 2021-01-21 23:01
 */
public class Merge {

    public static void main(String[] args) {
        Merge obj = new Merge();
        int[] arr1 = {0, 2};
        int[] arr2 = {1, 3, 4};
        obj.merge(arr1, arr1.length, arr2, arr2.length);
    }

    public int[] merge(int A[], int m, int B[], int n) {
        int[] helpArray = new int[m + n];
        int i = 0, p1 = 0, p2 = 0;
        while (p1 < m && p2 < n) {
            // 大的按兵不动
            helpArray[i++] = A[p1] <= A[p2] ? A[p1++] : A[p2++];
        }
        while (p1 < m) {
            helpArray[i++] = A[p1++];
        }
        while (p2 < n) {
            helpArray[i++] = B[p2++];
        }
        A = helpArray;
        return A;
    }
}
