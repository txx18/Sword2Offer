package main

import "fmt"

func main() {
	s := "dkjasdkf"
	fmt.Println(s[3])
}

func testStruct() {
	s1 := Student{1, "tx"}
	s2 := Student{Id: 1, Name: "tx"}
	s3 := Student{Id: 1, Name: "zy"}
	fmt.Println(s1 == s2)
	fmt.Println(s1 == s3)
}

type Student struct {
	Id   int
	Name string
}

func arrSum(arr []int) (sum int) {
	/*sum := 0*/
	for _, val := range arr { // 必须用匿名变量
		sum += val
	}
	return sum
}

func testPrint() {
	a := 1
	b := 2
	fmt.Print(a, b)
	fmt.Println("-----------------")
	fmt.Println(a, b)
	fmt.Println("a=", a, "b=", b)
	fmt.Printf("a=%d\nb=%d", a, b)
}
