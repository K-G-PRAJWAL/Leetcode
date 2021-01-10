package com.kgprajwal.leetcodejavasolutions;

public class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode ptr = head;
        int n = 1;
        while (ptr.next != null) {
            ptr = ptr.next;
            n++;
        }
        ptr.next = head;
        k %= n;
        for (int i = 0; i < n - k; i++) ptr = ptr.next;
        head = ptr.next;
        ptr.next = null;
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
        ListNode ans = rotateRight(n1, 2);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
