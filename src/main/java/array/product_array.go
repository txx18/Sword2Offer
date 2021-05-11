package main

func main() {

}

func constructArr(a []int) []int {
	rst := make([]int, len(a))
	product := 1
	for i := 0; i < len(a); i++ {
		rst[i] = product
		product *= a[i]
	}
	product = 1
	for i := len(a) - 1; i >= 0; i-- {
		rst[i] *= product
		product *= a[i]
	}
	return rst
}
