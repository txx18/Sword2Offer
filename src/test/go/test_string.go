package main

import (
	"fmt"
	"strconv"
)

func main() {
	//fmt.Println(reflect.TypeOf(testAtoI("342135")))
	fmt.Println(testByte("342135"))
}

func testAtoI(s string) int {
	atoi, _ := strconv.Atoi(s)
	fmt.Println(atoi)
	return atoi

}

func testByte(s string) (int, error) {
	return strconv.Atoi(string(s[0]))
}
