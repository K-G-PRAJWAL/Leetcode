package com.kgprajwal.leetcodejavasolutions;

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode curr = head;
        ListNode prev = null;
        while (m > 1) {
            prev = curr;
            curr = curr.next;
            m--;
            n--;
        }
        ListNode target = prev;
        ListNode tail = curr;
        ListNode after = null;
        while (n > 0) {
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
            n--;
        }
        if (target != null) target.next = prev;
        else head = prev;
        tail.next = curr;
        return head;
    }

    public static void main(String[] args) {
        ReverseLinkedListII r = new ReverseLinkedListII();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode ans = r.reverseBetween(n1, 2, 4);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
