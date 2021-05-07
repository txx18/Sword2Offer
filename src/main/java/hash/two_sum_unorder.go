package main

func main() {

}

func twoSum(nums []int, target int) []int {
	dic := make(map[int]int, len(nums))
	for i := 0; i < len(nums); i++ {
		dic[nums[i]] = i
	}
	for i := 0; i < len(nums); i++ {
		other := target - nums[i]
		j, ok := dic[other]
		if ok == true && j != i {
			return []int{i, j}
		}
	}
	return nil
}
