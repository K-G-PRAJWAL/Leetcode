package com.kgprajwal.leetcodejavasolutions;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode oddHead = head, even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            oddHead.next = even.next;
            oddHead = oddHead.next;
            even.next = oddHead.next;
            even = even.next;
        }
        oddHead.next = evenHead;
        return head;
    }
}
