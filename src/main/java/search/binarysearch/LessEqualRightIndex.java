package search.binarysearch;

public class LessEqualRightIndex {

	// 在arr上，找满足<=value的最右位置
	public static int nearestIndex(int[] arr, int value) {
		int L = 0;
		int R = arr.length - 1;
		int index = Integer.MIN_VALUE;
		while (L < R) {
			int mid = L + ((R - L) >> 1);
			if (value >= arr[mid]) {
				index = mid;
				L = mid + 1;
			} else {
				R = mid - 1;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[] arr = {1,1, 2, 2, 3,3,3,3,3 , 4,4,4,4,4, 5,5,5,5,5,5,5,5};
		int index = nearestIndex(arr, 3);
		System.out.println("index = " + index);
	}

}
