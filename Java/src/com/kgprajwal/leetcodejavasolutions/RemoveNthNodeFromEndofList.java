package com.kgprajwal.leetcodejavasolutions;

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) {this.val=val;}
//    ListNode(int val, ListNode next) {this.val=val; this.next=next;}
//}

// O(L) : length of LL
public class RemoveNthNodeFromEndofList {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = 0;
        ListNode ptr = head;
        while(ptr!=null) {
            len++; ptr=ptr.next;
        }
        int toBeTraversed = len - n;
        ptr = dummy;
        while(toBeTraversed>0) {
            toBeTraversed--; ptr=ptr.next;
        }
        ptr.next = ptr.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEndAlternative(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        while(n>0) {
            fast=fast.next;
            --n;
        }
        if(fast==null) return head.next;
        while(fast.next!=null) {
            slow = slow.next;
            fast=fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode ptr = n1;
        removeNthFromEndAlternative(ptr, 2);
        while(ptr!=null) {
            System.out.println(ptr.val);
            ptr = ptr.next;
        }
    }
}
