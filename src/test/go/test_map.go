package main

import "fmt"

func main() {
	testMap()
}

func testMap() {
	//hashMap := map[string]int{}
	hashMap := make(map[string]int)
	//var hashMap map[string]int
	hashMap["tx"] = 100
	val, ok := hashMap["zy"]
	fmt.Println(hashMap["tx"])
	fmt.Println(val, ok)
}
