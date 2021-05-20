package main

func main() {

}

func solutionGreedy(nums []int) int {
	res := 1
	curLength := 1
	for i := 0; i < len(nums)-1; i++ {
		if nums[i] < nums[i+1] {
			curLength++
		} else {
			curLength = 1
		}
		res = max(res, curLength)
	}
	return res
}

func solutionDp(nums []int) int {
	res := 1
	// i: [0~n-1]
	dp := make([]int, len(nums))
	for i := 0; i < len(dp); i++ {
		dp[i] = 1
	}
	for i := 1; i < len(nums); i++ {
		if nums[i-1] < nums[i] {
			dp[i] = dp[i-1] + 1
		}
		res = max(res, dp[i])
	}
	return res
}
