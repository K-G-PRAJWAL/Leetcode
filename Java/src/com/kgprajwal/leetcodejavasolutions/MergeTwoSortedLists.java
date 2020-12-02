package com.kgprajwal.leetcodejavasolutions;

// O(N)
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode ptr = dummy;
        while(l1!=null && l2!=null) {
            if(l1.val < l2.val) {
                ptr.next = l1;
                l1 = l1.next;
            } else {
                ptr.next = l2;
                l2 = l2.next;
            }
            ptr = ptr.next;
        }
        if(l1==null) ptr.next = l2;
        else ptr.next = l1;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(11);
        ListNode n4 = new ListNode(94);
        ListNode n5 = new ListNode(55);
        n1.next = n2;
        n3.next = n4;
        n4.next = n5;
        ListNode ptr = mergeTwoLists(n1, n3);
        while(ptr!=null) {
            System.out.println(ptr.val);
            ptr = ptr.next;
        }
    }
}
