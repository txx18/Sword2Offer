package main

import "fmt"

func main() {
	slice := []int{1, 2, 3}
	fmt.Println(slice)
	fmt.Println(slice[0:3])
	return
}

func testSlice(slice []int) []int {
	a := []int{}
	a[0] = 1
	var b []int
	b[0] = 2
	fmt.Println(a)
	fmt.Println(b)
	return slice[:len(slice)-1]
}

func testArraySlice() {
	arr := [3]int{1, 2, 3}
	slice := []int{1, 2, 3}
	testArrayParam(arr) //
	//arr = testArrayParam(arr)
	testSliceParam(slice)
	for _, val := range arr {
		fmt.Printf("%d, ", val)
	}
	fmt.Println("-----------------------")
	for _, val := range slice {
		fmt.Printf("%d, ", val)
	}
}

func testSliceParam(arr []int) []int {
	arr[0] = 444
	return arr
}

func testArrayParam(arr [3]int) [3]int {
	arr[0] = 444
	return arr
}
