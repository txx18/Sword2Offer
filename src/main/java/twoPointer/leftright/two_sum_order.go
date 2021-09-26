package main

func main() {

}

func twoSum(numbers []int, target int) []int {
	for l, r := 0, len(numbers)-1; l < r; {
		sum := numbers[l] + numbers[r]
		if sum < target {
			l++
		} else if sum > target {
			r--
		} else {
			return []int{l, r}
		}
	}
	return nil
}
