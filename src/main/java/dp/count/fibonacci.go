package main

import "fmt"

func fib(n int) int {
	if n <= 1 {
		return n
	}
	// 3、如何初始化
	// 下标0~n  n+1个数
	dp := make([]int, n+1)
	/*	var dp []int
		dp = make([]int, n+1)*/
	/*var dp []int = make([]int, n + 1)*/
	dp[0] = 0
	dp[1] = 1
	// 4、遍历顺序
	for i := 2; i < len(dp); i++ {
		// 1、含义
		// 2、递推公式
		dp[i] = dp[i-1] + dp[i-2]
	}
	fmt.Println(dp)
	// 求f(n) 下标 n
	return dp[n]
}

func main() {
	fib(10)
}
