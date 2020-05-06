package search.binarysearch;

public class JuBuMin {

	public static int getLessIndexZS(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1; // no exist
		}
		if (arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}
		if (arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr.length - 1;
		}
		int left = 1;
		int right = arr.length - 2;
		int mid = 0;
		while (left < right) {
			mid = (left + right) / 2;
			if (arr[mid] > arr[mid - 1]) {
				right = mid - 1;
			} else if (arr[mid] > arr[mid + 1]) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return left;
	}

	public static int solutionME(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		if (arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}
		if (arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr.length - 1;
		}
		int resIdx = -1;
		for (int l = 1, r = arr.length - 2; l < r; ) {
			int mid = l + ((r - l) >> 1);
			if (arr[mid] < arr[mid + 1]){
				r = mid;
				resIdx = r;
			}else {
				l = mid + 1;
				resIdx = l;
			}
		}
		return resIdx;
	}

}
