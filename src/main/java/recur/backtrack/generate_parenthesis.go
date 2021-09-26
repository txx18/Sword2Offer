package main

import "fmt"

func main() {
	res := generateParenthesis(3)
	fmt.Println(res)
}

func generateParenthesis(n int) []string {
	var res []string
	var track string
	var bt func(lCount int, rCount int)
	bt = func(lCount int, rCount int) {
		if lCount == n && rCount == n {
			res = append(res, track)
		}
		if lCount > n || rCount > n {
			return
		}
		if lCount < rCount {
			return
		}
		track += "("
		bt(lCount+1, rCount)
		track = track[:len(track)-1]
		track += ")"
		bt(lCount, rCount+1)
		track = track[:len(track)-1]

	}
	bt(0, 0)
	return res
}
