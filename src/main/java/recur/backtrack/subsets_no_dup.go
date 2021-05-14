package main

import "fmt"

func main() {
	test := []int{1, 2, 3}
	res := subsetsAnonymousFunc(test)
	print_2d_slice(res)
}

func subsetsAnonymousFunc(nums []int) [][]int {
	var track []int
	var res [][]int
	var bt func(int)
	// 匿名函数实现闭包
	bt = func(startIndex int) {
		res = append(res, append([]int(nil), track...))
		for i := startIndex; i < len(nums); i++ {
			track = append(track, nums[i])
			bt(i + 1)
			track = track[:len(track)-1]
		}
	}
	bt(0)
	return res
}

// 用成员变量写，LC似乎会有缓存
var gNums []int
var res *[][]int = new([][]int)
var track []int

func subsets(A []int) [][]int {
	gNums = A
	btOuter(0)
	return *res
}

func btOuter(startIndex int) {
	*res = append(*res, append([]int(nil), track...))
	for i := startIndex; i < len(gNums); i++ {
		/*		if startIndex == len(gNums) {
				return
			}*/
		track = append(track, gNums[i])
		btOuter(i + 1)
		track = track[:len(track)-1]
	}
}

func subsetsParam(nums []int) [][]int {
	var res [][]int
	var track []int
	btParam(nums, 0, track, &res) // 传地址
	return res
}

func btParam(nums []int, startIndex int, track []int, res *[][]int) { // 不用地址接收递归res就会变
	*res = append(*res, append([]int(nil), track...))
	for i := startIndex; i < len(nums); i++ {
		track = append(track, nums[i])
		btParam(nums, i+1, track, res)
		track = track[:len(track)-1]
	}
}

func subsetsGF(nums []int) (ans [][]int) {
	var track []int
	var dfs func(int)
	dfs = func(cur int) {
		if cur == len(nums) {
			ans = append(ans, append([]int(nil), track...))
			return
		}
		track = append(track, nums[cur])
		dfs(cur + 1)
		track = track[:len(track)-1]
		dfs(cur + 1)
	}
	dfs(0)
	return
}

func print_2d_slice(slice [][]int) {
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
