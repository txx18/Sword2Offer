package twoPointer.merge;

import java.util.List;

/**
 * @author ShaneTang
 * @create 2021-08-25 19:22
 */
public class MergeTwoSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int tail = m + n - 1;
        int cur = 0;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
//        List<Integer> resList = new ArrayList<>();
        int[] res = new int[m + n];
        int p1 = 0;
        int p2 = 0;
        int i = 0;
        while (p1 < m && p2 < n) {
            res[i++] = nums1[p1] < nums2[p2] ? nums1[p1++] : nums2[p2++];
//            if (nums1[p1] < nums2[p2]) {
//                resList.add(nums1[p1++]);
//            } else {
//                resList.add(nums2[p2++]);
//            }
        }
        while (p1 < m) {
//            resList.add(nums1[p1++]);
            res[i++] = nums1[p1++];

        }
        while (p2 < n) {
//            resList.add(nums2[p2++]);
            res[i++] = nums2[p2++];
        }
        copyResToNums1(nums1, res);
//        transResLIstToNums1(nums1, resList);
    }

    private void transResLIstToNums1(int[] nums1, List<Integer> resList) {
        Integer[] integers = resList.toArray(new Integer[0]);
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = integers[i];
        }
    }

    private void copyResToNums1(int[] nums1, int[] res) {
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = res[i];
        }
    }
}
