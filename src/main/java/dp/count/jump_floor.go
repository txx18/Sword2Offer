package main

func main() {

}

func numWays(n int) int {
	if n <= 1 {
		return 1
	}
	// n级台阶， 下标设为1~n，在数组中还是要n+1的空间
	dp := make([]int, n+1)
	dp[1] = 1
	dp[2] = 2
	for i := 3; i < len(dp); i++ {
		dp[i] = dp[i-1] + dp[i-2]
		dp[i] %= 1000000007
	}
	return dp[n]
}
