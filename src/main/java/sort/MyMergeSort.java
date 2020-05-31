package sort;

/**
 * @author GFS
 */
public class MyMergeSort {

    public static void solution(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    private static void sortProcess(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        sortProcess(arr, l, mid);
        sortProcess(arr, mid + 1, r);
        mergeProcess(arr, l, mid, r);
    }

    private static void mergeProcess(int[] arr, int l, int m, int r) {
        // 每次merge都会新建一个小help辅助数组
        int[] helpArray = new int[r - l + 1];
        int i = 0, p1 = l, p2 = m + 1;
        for (; p1 <= m && p2 <= r; ) {
            // 此处相等时拷贝左边保证稳定性，可以先拷贝左边也可以先拷贝右边
            helpArray[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
/*			等价于：
			if(arr[p1] < arr[p2]){
				helpArray[i++] = arr[p1++];
			}else {
				helpArray[i++] = arr[p2++];
			}*/
        }
        for (;p1 <= m;) {
            helpArray[i++] = arr[p1++];
        }
        for (;p2 <= r;) {
            helpArray[i++] = arr[p2++];
        }
        // 将help拷贝回arr
        for (i = 0; i < helpArray.length; i++) {
            arr[l + i] = helpArray[i];
        }
    }

}
