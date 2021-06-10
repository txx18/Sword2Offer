package main

import "strconv"

func main() {
	rst := addStrings("11", "123")
	println(rst)
}

func addStrings(num1 string, num2 string) string {
	carry := 0
	res := ""
	// 倒着循环，判断3个条件
	for i, j := len(num1)-1, len(num2)-1; i >= 0 || j >= 0 || carry != 0; i, j = i-1, j-1 {
		/*x, y := 0, 0*/
		// 用两个变量取得低位数值
		var x, y int
		if i >= 0 {
			x = int(num1[i] - '0')
		}
		if j >= 0 {
			y = int(num2[j] - '0')
		}
		// 算进位的总和
		sum := x + y + carry
		// 无进位和
		noCarrySum := sum % 10
		// 进位值carry
		carry = sum / 10
		// 把无进位和拼在前面
		res = strconv.Itoa(noCarrySum) + res
		//res = strconv.FormatInt(int64(noCarrySum), 10) + res
	}
	return res
}
