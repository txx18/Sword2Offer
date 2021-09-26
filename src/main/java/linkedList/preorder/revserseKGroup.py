class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


# ListNode a, b之间反转
def reverse(a, b):
    cur = a
    nxt = a
    pre = None
    while cur != b:
        nxt = cur.next
        cur.next = pre
        pre = cur
        cur = nxt
    return pre


def solution(str_list, k):
    # 装进链表
    head = ListNode(-1)
    cur = head
    for string in str_list:
        cur.next = ListNode(int(string))
        cur = cur.next
    newHead = recur(head.next, k)
    # 打印结果
    cur = newHead
    while cur is not None:
        print(str(cur.val) + " ", end='')
        cur = cur.next


def recur(head, k):
    if head is None:
        return None
    a = head
    b = head
    for i in range(k):
        # base case
        if b is None:
            return head
        b = b.next
    # 先序，.0
    newHead = reverse(a, b)
    a.next = recur(b, k)
    return newHead


if __name__ == "__main__":
    str_list = input().split()
    k = int(input())
    solution(str_list, k)
