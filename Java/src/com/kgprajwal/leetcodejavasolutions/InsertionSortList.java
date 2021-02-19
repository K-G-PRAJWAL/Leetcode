package com.kgprajwal.leetcodejavasolutions;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode tmp = new ListNode(0);
        ListNode prev = tmp;
        while (head != null) {
            ListNode ptr = head.next;
            if (prev.val >= head.val) prev = tmp;
            while (prev.next != null && prev.next.val < head.val) prev = prev.next;
            head.next = prev.next;
            prev.next = head;
            head = ptr;
        }
        return tmp.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(6);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(8);
        ListNode n6 = new ListNode(7);
        ListNode n7 = new ListNode(2);
        ListNode n8 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        InsertionSortList o = new InsertionSortList();
        System.out.println(o.insertionSortList(n1));
    }
}
