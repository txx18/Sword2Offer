package main

func main() {

}

func search(nums []int, target int) int {
	if len(nums) == 0 {
		return -1
	}
	l := 0
	r := len(nums) - 1
	for l < r {
		mid := l + (r-l)>>1
		if target <= nums[mid] {
			r = mid
		} else {
			l = mid + 1
		}
	}
	if l == len(nums) {
		return -1
	}
	if nums[l] != target {
		return -1
	}
	return l
}
