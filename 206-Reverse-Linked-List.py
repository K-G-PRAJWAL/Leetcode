# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

# Iterative Solution
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        before = None
        ptr = head
        while ptr:
            after = ptr.next
            ptr.next = before
            before = ptr
            ptr = after
        return before


# Recursive Solution
class Solution:
    def reverseList(self, head: ListNode, before=None) -> ListNode:
        if not head:
            return before
        after = head.next
        head.next = before
        return self.reverseList(after, head)
