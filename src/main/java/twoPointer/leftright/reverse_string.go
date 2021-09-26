package main

import "fmt"

func main() {
	test := []byte{'h', 'e', 'l', 'l', 'o'}
	reverseString(test)
	fmt.Println(test)
}

func reverseString(s []byte) {
	for l, r := 0, len(s)-1; l < r; l, r = l+1, r-1 {
		swap(s, l, r)
	}
}

func swap(nums []byte, i int, j int) {
	nums[i], nums[j] = nums[j], nums[i]
}
