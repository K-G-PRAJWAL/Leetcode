# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        x = y = head
        while x and x.next:
            x = x.next.next
            y = y.next
        rev = None
        while y:
            after = y.next
            y.next = rev
            rev = y
            y = after
        while rev:
            if rev.val != head.val:
                return False
            rev = rev.next
            head = head.next
        return True
