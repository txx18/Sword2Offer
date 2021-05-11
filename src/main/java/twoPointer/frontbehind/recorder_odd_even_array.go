package main

func main() {

}

func exchange(nums []int) []int {
	cutIndex := -1
	for i := 0; i < len(nums); i++ {
		if isOdd(nums[i]) {
			cutIndex++
			swap(nums, i, cutIndex)
		}
	}
	return nums
}

func isOdd(num int) bool {
	return (num & 1) != 0
}

func swap(nums []int, i int, j int) {
	tmp := nums[i]
	nums[i] = nums[j]
	nums[j] = tmp
}
