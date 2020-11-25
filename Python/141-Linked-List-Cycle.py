# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def hasCycle(self, head):
        # Solution 1
        slow = fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return True
        return False

        # Solution 2
        try:
            slow = head
            fast = head.next
            while slow is not fast:
                slow = slow.next
                fast = fast.next.next
            return True
        except:
            return False

        # Solution 3
        while head:
            if head.val == None:
                return True
            head.val = None
            head = head.next
        return False
