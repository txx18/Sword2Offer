package sort;

/**
 * @author GFS
 */
public class MyMergeSort {

    int[] helpMember;

    /**
     * 通过LC NK
     * @param arr
     * @return
     */
    public int[] MySort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        helpMember = new int[arr.length];
        return recur(arr, 0, arr.length - 1);
    }

    private int[] recur(int[] arr, int l, int r) {
        if (l >= r) { // l > r不行
            return arr;
        }
        int mid = l + ((r - l) >> 1);
        recur(arr, l, mid);
        recur(arr, mid + 1, r);
        merge1(arr, l, mid, r);
//        merge2(arr, l, mid, r);
        return arr;
    }

    private void merge1(int[] arr, int l, int m, int r) {
        // 每次merge都会新建一个小help辅助数组
        int i = l;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            // 此处相等时拷贝左边保证稳定性，可以先拷贝左边也可以先拷贝右边
            helpMember[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            helpMember[i++] = arr[p1++];
        }
        while (p2 <= r) {
            helpMember[i++] = arr[p2++];
        }
        // 将help拷贝回arr
        for (i = l; i <= r; i++) {
            arr[i] = helpMember[i];
        }
    }

    private void merge2(int[] arr, int l, int m, int r) {
        // 每次merge都会新建一个小help辅助数组
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            // 此处相等时拷贝左边保证稳定性，可以先拷贝左边也可以先拷贝右边
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        // 将help拷贝回arr
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    /*			等价于：
			if(arr[p1] < arr[p2]){
				helpArray[i++] = arr[p1++];
			}else {
				helpArray[i++] = arr[p2++];
			}*/
}
