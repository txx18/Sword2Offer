package main

func main() {
	//test := []int{0,1,0,3,2,3}
	//test := []int{10,9,2,5,3,7,101,18}
	test := []int{1, 3, 6, 7, 9, 4, 10, 5, 6}
	lengthOfLIS(test)
}

func lengthOfLIS(nums []int) int {
	res := 1
	// i: [0~n-1]
	// dp[i] 到下标i元素为止的LIS长度（显然不是越到后面越大，因为中间可能被大数截断）
	dp := make([]int, len(nums))
	for i := 0; i < len(dp); i++ {
		dp[i] = 1
	}
	for i := 0; i < len(dp); i++ {
		for j := 0; j < i; j++ {
			if nums[j] < nums[i] {
				dp[i] = max(dp[i], dp[j]+1)
			}
		}
		res = max(res, dp[i])
	}
	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
