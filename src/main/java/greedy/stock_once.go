package main

func main() {

}

func maxProfit(prices []int) int {
	curMin := prices[0]
	rst := 0
	for _, val := range prices {
		if val < curMin {
			curMin = val
		}
		if val-curMin > rst {
			rst = val - curMin
		}
	}
	return rst
}

func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
