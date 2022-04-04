package com.kgprajwal.leetcodejavasolutions;

public class SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head, slow = head;
        ListNode first = head, second = head;

        for (int i = 0; i < k - 1; i++) fast = fast.next;

        first = fast;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        second = slow;

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;

        return head;
    }
}
