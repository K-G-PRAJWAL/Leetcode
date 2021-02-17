package com.kgprajwal.leetcodejavasolutions;

public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        while (ptr2.next != null && ptr2.next.next != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
        }
        ListNode preMid = ptr1;
        ListNode preCurr = ptr1.next;
        while (preCurr.next != null) {
            ListNode current = preCurr.next;
            preCurr.next = current.next;
            current.next = preMid.next;
            preMid.next = current;
        }
        ptr1 = head;
        ptr2 = preMid.next;
        while (ptr1 != preMid) {
            preMid.next = ptr2.next;
            ptr2.next = ptr1.next;
            ptr1.next = ptr2;
            ptr1 = ptr2.next;
            ptr2 = preMid.next;
        }
    }

    public static void main(String[] args) {
        ReorderList o = new ReorderList();
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        o.reorderList(n1);
    }
}
