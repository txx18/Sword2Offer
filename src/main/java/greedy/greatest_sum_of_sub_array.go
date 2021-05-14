package main

func main() {
	println(dpTable([]int{-2, 1, -3, 4, -1, 2, 1, -5, 4}))
}

func maxSubArray(nums []int) int {
	rst := nums[0]
	curSum := 0
	for _, val := range nums {
		curSum += val
		if curSum > rst {
			rst = curSum
		}
		if curSum < 0 {
			curSum = 0
		}
	}
	return rst
}

func dpTable(nums []int) int {
	//当 dp[i - 1] > 0 dp[i−1]>0 时：执行 dp[i] = dp[i-1] + nums[i] ；
	//当 dp[i - 1] < 0 dp[i−1]≤0 时：执行 dp[i] = nums[i] ；
	dp := make([]int, len(nums))
	dp[0] = nums[0]
	for i := 1; i < len(dp); i++ {
		dp[i] = max(dp[i-1]+nums[i], nums[i])
	}
	return maxOfSlice(dp)

}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func maxOfSlice(slice []int) int {
	max := slice[0]
	for _, val := range slice {
		if val > max {
			max = val
		}
	}
	return max
}
