package main

func main() {
	test := &ListNode{Val: 1}
	test.Next = &ListNode{Val: 3}
	test.Next.Next = &ListNode{Val: 2}
}

func reverseBetween(head *ListNode, left int, right int) *ListNode {
	if left == 1 {
		return reverseN(head, right)
	}
	head.Next = reverseBetween(head.Next, left-1, right-1)
	return head
}

var nxt *ListNode

func reverseN(head *ListNode, right int) *ListNode {
	if right == 1 {
		nxt = head.Next
		return head
	}
	newHead := reverseN(head.Next, right-1)
	head.Next.Next = head
	head.Next = nxt
	return newHead
}
