# # Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        ptrA = l1
        ptrB = l2
        carry = 0
        temp = ListNode(0)
        curr = temp
        while ptrA or ptrB or carry:
            if ptrA:
                carry += ptrA.val
                ptrA = ptrA.next
            if ptrB:
                carry += ptrB.val
                ptrB = ptrB.next
            curr.next = ListNode(carry % 10)
            curr = curr.next
            carry //= 10
        return temp.next
