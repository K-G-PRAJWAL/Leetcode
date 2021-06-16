package com.kgprajwal.leetcodejavasolutions;

public class MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode end = list1, start = null;
        for (int i = 0; i < b; i++) {
            if (i == a - 1) start = end;
            end = end.next;
        }
        start.next = list2;
        while (list2.next != null) list2 = list2.next;
        list2.next = end.next;
        end.next = null;
        return list1;
    }
}
