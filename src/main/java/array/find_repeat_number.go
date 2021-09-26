package main

func main() {

}

func findRepeatNumber(nums []int) int {
	for i := 0; i < len(nums); i++ {
		if nums[i] == i {
			continue
		}
		if nums[i] == nums[nums[i]] {
			return nums[i]
		}
		swap(nums, nums[i], i)
	}
	return -1
}

func swap(nums []int, i int, j int) {
	tmp := nums[i]
	nums[i] = nums[j]
	nums[j] = tmp
}
