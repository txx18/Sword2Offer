package main

import "fmt"

func main() {
	fmt.Println(firstUniqChar("abaccdeff"))
}

func firstUniqChar(s string) byte {
	bytes := []byte(s)
	byteCount := make([]int, 128)
	for i := 0; i < len(bytes); i++ {
		byteCount[bytes[i]]++
	}
	for i := 0; i < len(bytes); i++ {
		if byteCount[bytes[i]] == 1 {
			return bytes[i]
		}
	}
	return ' '
}
