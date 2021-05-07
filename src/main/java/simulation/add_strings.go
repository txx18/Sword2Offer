package main

import "strconv"

func main() {
	rst := addStrings("11", "123")
	println(rst)
}

func addStrings(num1 string, num2 string) string {
	carry := 0
	rst := ""
	for i, j := len(num1)-1, len(num2)-1; i >= 0 || j >= 0 || carry != 0; i, j = i-1, j-1 {
		/*x, y := 0, 0*/
		var x, y int
		if i >= 0 {
			x = int(num1[i] - '0')
		}
		if j >= 0 {
			y = int(num2[j] - '0')
		}
		// 算进位的总和
		sum := x + y + carry
		// 去掉进位把高位加上去
		noCarrySum := sum % 10
		// 进位
		carry = sum / 10
		rst = strconv.Itoa(noCarrySum) + rst
		//rst = strconv.FormatInt(int64(noCarrySum), 10) + rst
	}
	return rst
}
