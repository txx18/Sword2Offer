package main

func main() {

}

/*type ListNode struct {
	Val int
	Next *ListNode
}*/

func reverseList(head *ListNode) *ListNode {
	var pre *ListNode
	for head != nil {
		nxt := head.Next
		head.Next = pre
		pre = head
		head = nxt
	}
	return pre
}
