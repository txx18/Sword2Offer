package main

func main() {
	//vw := [][]int{{1, 3}, {10, 4}}
	vw := [][]int{{1, 3}, {10, 4}}
	println(knapsack(10, 2, vw))
}

func knapsack(V int, n int, vw [][]int) int {
	// dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少
	dp := make([][]int, n)
	for i := 0; i < n; i++ {
		dp[i] = make([]int, V+1)
	}
	// 体积为0，当然最大重量为0，已经初始化了
	// 下标为0，在容量范围内最大重量是第0件物品的重量，容量不够最大重量也是0
	// 正序初始化的思路
	/*	for j := vw[0][0]; j < V+1; j++ {
		dp[0][j] = vw[0][1]
	}*/
	// 逆序初始化的思路
	for j := V; j >= vw[0][0]; j-- {
		dp[0][j] = dp[0][j-vw[0][0]] + vw[0][1]
	}
	for i := 1; i < n; i++ {
		for j := 0; j < V+1; j++ {
			// 容量不足，只能继承上个状态
			if j-vw[i][0] < 0 {
				dp[i][j] = dp[i-1][j]
				continue
			}
			dp[i][j] = max(dp[i-1][j], dp[i-1][j-vw[i][0]]+vw[i][1])
		}
	}
	return dp[n-1][V]
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
