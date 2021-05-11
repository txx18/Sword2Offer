package main

import (
	"math/rand"
)

func main() {

}

func sortArray(nums []int) []int {
	if nums == nil || len(nums) < 2 {
		return nums
	}
	return sort(nums, 0, len(nums)-1)
}

func sort(nums []int, l int, r int) []int {
	if l >= r {
		return nums
	}
	pivotIndex := l + rand.Intn(r-l+1)
	swap(nums, pivotIndex, r)
	/*	lessEqualRight := twoPartition(nums, l, r)
		sort(nums, l, lessEqualRight-1)
		sort(nums, lessEqualRight+1, r)*/
	equalLeft, equalRight := threePartition(nums, l, r)
	sort(nums, l, equalLeft-1)
	sort(nums, equalRight+1, r)
	return nums
}

func threePartition(nums []int, l int, r int) (int, int) {
	pivotVal := nums[r]
	lessRight := l - 1
	greatLeft := r
	for i := l; i < greatLeft; {
		if nums[i] < pivotVal {
			lessRight++
			swap(nums, i, lessRight)
			i++
		} else if nums[i] > pivotVal {
			greatLeft--
			swap(nums, i, greatLeft)
		} else {
			i++
		}
	}
	swap(nums, greatLeft, r)
	return lessRight + 1, greatLeft
}

func swap(nums []int, i int, j int) {
	tmp := nums[i]
	nums[i] = nums[j]
	nums[j] = tmp
}

func twoPartition(nums []int, l int, r int) int {
	pivotVal := nums[r]
	cutIndex := l - 1
	for i := l; i <= r; i++ {
		if nums[i] <= pivotVal {
			cutIndex++
			swap(nums, i, cutIndex)
		}
	}
	return cutIndex
}
