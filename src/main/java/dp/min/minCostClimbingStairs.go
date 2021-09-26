package main

func main() {
	minCostClimbingStairs([]int{10, 15, 20})
}

func minCostClimbingStairs(cost []int) int {
	n := len(cost)
	// n级楼梯  0~n-1
	dp := make([]int, n)
	dp[0] = cost[0]
	dp[1] = cost[1]
	for i := 2; i < len(dp); i++ {
		dp[i] = min(dp[i-1], dp[i-2]) + cost[i]
	}
	//fmt.Println(dp)
	return min(dp[n-1], dp[n-2])
}

func min(x, y int) int {
	if x < y {
		return x
	}
	return y

}
