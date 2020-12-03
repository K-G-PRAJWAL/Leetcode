package com.kgprajwal.leetcodejavasolutions;

// O(N)
public class SwapNodesinPairs {
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode ptr = head;
        while(ptr!=null && ptr.next!=null) {
            ListNode after = ptr.next;
            ptr.next = after.next;
            after.next = ptr;
            prev.next = after;
            prev = ptr;
            ptr = ptr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode ans = swapPairs(n1);
        while(ans!=null) {
            System.out.println(ans.val);
            ans=ans.next;
        }
    }
}
