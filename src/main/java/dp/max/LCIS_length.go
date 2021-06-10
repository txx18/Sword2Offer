package main

/*
最长连续递增子序列
*/

func main() {

}

func solutionDp(nums []int) int {
	res := 1
	// i: [0~n-1]
	n := len(nums)
	// dp[i] 定义为 下标[0,i-1]的最长连续递增子序列长度
	dp := make([]int, n)
	for i := 0; i < n; i++ {
		dp[i] = 1
	}
	for i := 1; i < n; i++ {
		if nums[i-1] < nums[i] { // if
			dp[i] = dp[i-1] + 1
		}
		res = max(res, dp[i])
	}
	return res
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
