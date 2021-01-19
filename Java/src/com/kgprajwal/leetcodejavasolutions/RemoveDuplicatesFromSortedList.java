package com.kgprajwal.leetcodejavasolutions;

public class RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode ptr = head;
        while (ptr != null && ptr.next != null) {
            if (ptr.val == ptr.next.val) ptr.next = ptr.next.next;
            else ptr = ptr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        ListNode ans = deleteDuplicates(n1);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
