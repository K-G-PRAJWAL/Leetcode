# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# Solution 1
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        ptrA, ptrB = headA, headB
        lA, lB = 0, 0
        while ptrA:
            lA += 1
            ptrA = ptrA.next
        while ptrB:
            lB += 1
            ptrB = ptrB.next
        ptrA, ptrB = headA, headB
        if lA > lB:
            for i in range(lA-lB):
                ptrA = ptrA.next
        elif lB > lA:
            for i in range(lB-lA):
                ptrB = ptrB.next
        while ptrB != ptrA:
            ptrB = ptrB.next
            ptrA = ptrA.next
        return ptrA


# Solution 2
class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        ptrA, ptrB = headA, headB
        if not headA or not headB:
            return None
        while ptrA and ptrB and ptrA != ptrB:
            ptrA = ptrA.next
            ptrB = ptrB.next
            if ptrA == ptrB:
                return ptrA
            if not ptrA:
                ptrA = headB
            if not ptrB:
                ptrB = headA
        return ptrA
