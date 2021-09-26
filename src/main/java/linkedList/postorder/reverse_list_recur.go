package main

func main() {
	test := &ListNode{Val: 1}
	test.Next = &ListNode{Val: 3}
	test.Next.Next = &ListNode{Val: 2}
}

func reverseList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	newHead := reverseList(head.Next)
	head.Next.Next = head
	head.Next = nil
	return newHead
}
