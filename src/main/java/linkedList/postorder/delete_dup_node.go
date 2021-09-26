package main

func main() {

}

func deleteDuplicates(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	nxt := head.Next
	if head.Val == nxt.Val {
		for nxt != nil && head.Val == nxt.Val {
			nxt = nxt.Next
		}
		return deleteDuplicates(nxt)
	}
	head.Next = deleteDuplicates(nxt)
	return head
}
