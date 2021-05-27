package main

func main() {

}

func findLength(nums1 []int, nums2 []int) int {
	res := 0
	// dp[i][j]如果定义成以下标i和j结尾的结果，就涉及数组越界处理
	// i,j: [0, n-1]
	/*	dp := make([][]int, len(nums1))
		for i := 0; i < len(dp); i++ {
			dp[i] = make([]int, len(nums2))
		}
		for i := 0; i < len(nums1); i++ {
			for j := 0; j < len(nums2); j++ {
				if nums1[i] == nums2[j] {
					if i == 0 || j == 0 {
						dp[i][j] = 1
						continue
					}
					dp[i][j] = dp[i-1][j-1] + 1
				}
				res = max(res, dp[i][j])
			}
		}*/
	// dp[i][j]如果定义成以下标i-1和j-1结尾的结果
	// i,j: [0, n]
	// 取0的结果没有意义，从1开始遍历，但需要初始化，默认为0为两个空字符串的结果，符合题意
	dp := make([][]int, len(nums1)+1)
	for i := 0; i < len(dp); i++ {
		dp[i] = make([]int, len(nums2)+1)
	}
	// 从1开始遍历
	for i := 1; i < len(nums1)+1; i++ {
		for j := 1; j < len(nums2)+1; j++ {
			if nums1[i-1] == nums2[j-1] {
				dp[i][j] = dp[i-1][j-1] + 1
			}
			res = max(res, dp[i][j])
		}

	}
	return res
}
