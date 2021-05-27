package main

func main() {

}

func maxProfit(prices []int) int {
	curMin := prices[0]
	res := 0
	for _, val := range prices {
		curMin = min(curMin, val)
		res = max(res, val-curMin)
	}
	return res
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
