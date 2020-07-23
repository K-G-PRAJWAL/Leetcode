# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeTwoLists(self, l1, l2):
        head = ListNode(0)
        ptr = head

        while True:
            if l1 is None and l2 is None:
                break
            elif l1 is None:
                ptr.next = l2
                break
            elif l2 is None:
                ptr.next = l1
                break
            else:
                small = 0
                if l1.val < l2.val:
                    small = l1.val
                    l1 = l1.next
                else:
                    small = l2.val
                    l2 = l2.next

                new = ListNode(small)
                ptr.next = new
                ptr = ptr.next
        return head.next
