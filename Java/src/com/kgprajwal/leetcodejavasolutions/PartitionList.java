package com.kgprajwal.leetcodejavasolutions;

public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        ListNode bH = new ListNode(0);
        ListNode before = bH;
        ListNode aH = new ListNode(0);
        ListNode after = aH;
        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = aH.next;
        return bH.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode ans = partition(n1, 3);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
