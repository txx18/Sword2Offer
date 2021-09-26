package twoPointer.partition;

import zhelper.ArrayUtils;

import java.util.Arrays;


public class My3PartitionFlag {

	public static void main(String[] args) {
		int[] arr1 = {1, 1, 6, 6, 8, 8, 9, 3, 4, 5, 2, 1, 0, 5};
		int[] arr2 = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2};
		System.out.println(arr1.length);
//        int[] arr = {1,1, 7, 5, 8, 5};
		int[] equalInterval = partition(arr1, 7);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(equalInterval));
	}

    /**
     * 以num分界，分3个区域
     * @param arr
     * @param pivot
     * @return
     */
	public static int[] partition(int[] arr, int pivot) {
        int lessIndex = -1;
        int moreIndex = arr.length;
        int i = 0;
        while (i < moreIndex) {
            if(arr[i] < pivot){
                ArrayUtils.swap(arr, ++lessIndex, i++);
            }
            else if(arr[i] > pivot){
				// i不++因为换过来的arr[moreIndex-1]还没判断
                ArrayUtils.swap(arr, --moreIndex, i);
            }
            else { // == num
				i++;
            }
        }
        return new int[] {lessIndex + 1, moreIndex - 1};
	}
}
