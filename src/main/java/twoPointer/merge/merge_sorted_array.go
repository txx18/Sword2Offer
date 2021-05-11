package main

import (
	"fmt"
	"sort"
)

func main() {
	nums1 := []int{1, 2, 3, 0, 0, 0}
	nums2 := []int{2, 5, 6}
	mergeSlice(nums1, 3, nums2, 3)
	fmt.Println(nums1)
}

func merge1(nums1 []int, m int, nums2 []int, n int) {
	copy(nums1[m:], nums2)
	sort.Ints(nums1)
	//fmt.Println(nums1)
}

func mergeSlice(nums1 []int, m int, nums2 []int, n int) {
	//rst := make([]int, 0, m+n) // 长度必须设为0，容量设为m+n，因为用了append
	var rst []int
	p1, p2 := 0, 0
	for p1 < m && p2 < n {
		if nums1[p1] < nums2[p2] {
			rst = append(rst, nums1[p1])
			p1++
		} else {
			rst = append(rst, nums2[p2])
			p2++
		}
	}
	rst = append(rst, nums2[p2:]...) // 追加切片，需要解包
	rst = append(rst, nums1[p1:]...)
	copy(nums1, rst)
	//fmt.Println(nus1)
}

func mergeTwoPointer(nums1 []int, m int, nums2 []int, n int) {
	for p1, p2, tail := m-1, n-1, m+n-1; p1 >= 0 || p2 >= 0; tail-- {
		var cur int
		if p1 == -1 {
			cur = nums2[p2]
			p2--
		} else if p2 == -1 {
			cur = nums1[p1]
			p1--
		} else if nums1[p1] > nums2[p2] {
			cur = nums1[p1]
			p1--
		} else {
			cur = nums2[p2]
			p2--
		}
		nums1[tail] = cur
	}
}

func mergeArray(nums1 []int, m int, nums2 []int, n int) {
	p1, p2 := 0, 0
	rst := make([]int, m+n) // 不用append
	cur := 0
	for p1 < m && p2 < n {
		if nums1[p1] < nums2[p2] {
			rst[cur] = nums1[p1]
			p1++
			cur++
		} else {
			rst[cur] = nums2[p2]
			p2++
			cur++
		}
	}
	for i := p2; i < n; i++ {
		rst[cur] = nums2[i]
		cur++
	}
	for i := p1; i < m; i++ {
		rst[cur] = nums1[i]
		cur++
	}
	for i := 0; i < m+n; i++ {
		nums1[i] = rst[i]
	}
}

func mergeSlice2(nums1 []int, m int, nums2 []int, n int) {
	p1, p2 := 0, 0
	rst := make([]int, 0, m+n)
	for p1 < m && p2 < n {
		if nums1[p1] < nums2[p2] {
			rst = append(rst, nums1[p1])
			p1++
		} else {
			rst = append(rst, nums2[p2])
			p2++
		}
	}
	if p1 == m {
		for i := p2; i < n; i++ {
			rst = append(rst, nums2[i])
		}
	}
	if p2 == n {
		for i := p1; i < m; i++ {
			rst = append(rst, nums1[i])
		}
	}
	for i := 0; i < m+n; i++ {
		nums1[i] = rst[i]
	}
}
