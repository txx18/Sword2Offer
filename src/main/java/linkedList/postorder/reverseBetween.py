# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

#
# 
# @param head ListNode类 
# @param m int整型 
# @param n int整型 
# @return ListNode类
#


class Solution:

    def __init__(self):
        self.nxt = None

    def reverseBetween(self, head, m, n):
        # write code here
        if m == 1:
            return self.reverseN(head, n)
        head.next = self.reverseBetween(head.next, m - 1, n - 1)
        return head

    def reverseN(self, head, n):
        if n == 1:
            self.nxt = head.next
            return head
        newHead = self.reverseN(head.next, n - 1)
        head.next.next = head
        head.next = self.nxt
        return newHead
