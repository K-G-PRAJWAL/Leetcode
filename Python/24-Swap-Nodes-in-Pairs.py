# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def swapPairs(self, head):
        # Solution 1
        temp = prev = ListNode(0)
        prev.next = head
        while prev.next and prev.next.next:
            x = prev.next
            y = x.next
            prev.next, x.next, y.next = y, y.next, x
            prev = x
        return temp.next

        # Solution 2
        if not head or not head.next:
            return head
        temp = ListNode(0)
        temp.next = head
        curr = temp
        while curr.next and curr.next.next:
            first = curr.next
            second = curr.next.next
            curr.next = second
            first.next = second.next
            second.next = first
            curr = curr.next.next
        return temp.next

        # Soluton 3 - Recursion
        if not head or not head.next:
            return head
        start = head.next.next
        head, head.next = head.next, head
        head.next.next = self.swapPairs(start)
        return head
