package main

import "fmt"

func main() {
	test := &ListNode{Val: 1}
	test.Next = &ListNode{Val: 3}
	test.Next.Next = &ListNode{Val: 2}
	res := reversePrint(test)

	fmt.Println(res)
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func reversePrint(head *ListNode) []int {
	res := make([]int, 0, 10)
	var recur func(*ListNode)
	recur = func(head *ListNode) {
		if head == nil {
			return
		}
		recur(head.Next)
		res = append(res, head.Val)
	}
	recur(head)
	return res
	/*	res = make([]int, 0, 10)
		recur(head)
		return res*/
}

var res []int

func recur(head *ListNode) {
	if head == nil {
		return
	}
	recur(head.Next)
	res = append(res, head.Val)
}
