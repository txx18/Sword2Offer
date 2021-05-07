package main

func main() {

}

type ListNode struct {
	Val  int
	Next *ListNode
}

/**
LC 逆序存储
*/
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	var rst *ListNode
	var cur *ListNode
	carry := 0
	for l1 != nil || l2 != nil {
		x, y := 0, 0
		if l1 != nil {
			x = l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			y = l2.Val
			l2 = l2.Next
		}
		sum := x + y + carry
		noCarrySum := sum % 10
		carry = sum / 10
		if rst == nil {
			rst = &ListNode{Val: noCarrySum}
			cur = rst
		} else {
			cur.Next = &ListNode{Val: noCarrySum}
			cur = cur.Next
		}
	}
	if carry != 0 {
		cur.Next = &ListNode{Val: carry}
	}
	return rst
}

/**
NK 顺序存储
*/
func addInList(head1 *ListNode, head2 *ListNode) *ListNode {
	// write code here
	head1 = reverseList(head1)
	head2 = reverseList(head2)
	var rst *ListNode
	var cur *ListNode
	carry := 0
	for head1 != nil || head2 != nil {
		x, y := 0, 0
		if head1 != nil {
			x = head1.Val
			head1 = head1.Next
		}
		if head2 != nil {
			y = head2.Val
			head2 = head2.Next
		}
		sum := x + y + carry
		noCarrySum := sum % 10
		carry = sum / 10
		if rst == nil {
			rst = &ListNode{Val: noCarrySum} // 指针变量 = 地址
			cur = rst
		} else {
			cur.Next = &ListNode{Val: noCarrySum}
			cur = cur.Next
		}
	}
	if carry != 0 {
		cur.Next = &ListNode{Val: carry}
	}
	return reverseList(rst)
}

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
