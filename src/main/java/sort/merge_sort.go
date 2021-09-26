package main

import "fmt"

func main() {
	test := []int{5, 2, 3, 1}
	fmt.Println(sortArrayMerge(test))
}

func sortArrayMerge(nums []int) []int {
	if nums == nil || len(nums) < 2 {
		return nums
	}
	return recurMerge(nums, 0, len(nums)-1)
}

func recurMerge(nums []int, l int, r int) []int {
	if l >= r {
		return nums
	}
	mid := l + ((r - l) >> 1)
	recurMerge(nums, l, mid)
	recurMerge(nums, mid+1, r)
	merge(nums, l, mid, r)
	return nums

}

func merge(nums []int, l int, mid int, r int) {
	//var help = make([]int, 0, r-l+1)
	var help []int
	i := 0
	p1 := l
	p2 := mid + 1
	for p1 <= mid && p2 <= r {
		if nums[p1] <= nums[p2] {
			help = append(help, nums[p1])
			p1++
		} else {
			help = append(help, nums[p2])
			p2++
		}
		i++
	}
	/*	for p1 <= mid {
			help[i] = nums[p1]
			i++
			p1++
		}
		for p2 <= r {
			help[i] = nums[p2]
			i++
			p2++
		}*/
	help = append(help, nums[p1:mid+1]...)
	help = append(help, nums[p2:r+1]...)
	for i := 0; i < len(help); i++ {
		nums[l+i] = help[i]
	}
}
