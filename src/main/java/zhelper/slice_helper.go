package main

import (
	"fmt"
	"math"
)

func main() {
	arr := [][]int{{1, 2}, {3, 4}}
	print2dSlice(arr)
}

func print2dSlice(slice [][]int) {
	fmt.Println("[")
	for i := 0; i < len(slice); i++ {
		fmt.Print("[")
		for j := 0; j < len(slice[i]); j++ {
			fmt.Printf("%d ", slice[i][j])
		}
		fmt.Print("]")
		fmt.Println()
	}
	fmt.Print("]")
}

func swap(nums []int, i int, j int) {
	tmp := nums[i]
	nums[i] = nums[j]
	nums[j] = tmp
}

func maxOfSlice(slice []int) int {
	max := math.MinInt64
	for _, val := range slice {
		if val > max {
			max = val
		}
	}
	return max
}

func minOfSlice(slice []int) int {
	min := math.MaxInt64
	for _, val := range slice {
		if val < min {
			min = val
		}
	}
	return min
}
