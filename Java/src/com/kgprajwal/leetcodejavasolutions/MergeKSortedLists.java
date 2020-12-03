package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeKSortedLists {
    // O(N log N)
    public static ListNode mergeKLists(ListNode[] lists) {
        List<Integer> ans = new ArrayList<Integer>();
        for(ListNode NODE: lists) {
            while(NODE!=null) {
                ans.add(NODE.val);
                NODE = NODE.next;
            }
        }
        Collections.sort(ans);
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        for(int i : ans) {
            ListNode NEWNODE = new ListNode(i);
            ptr.next = NEWNODE;
            ptr = ptr.next;
        }
        ptr.next = null;
        return head.next;
    }

    // O(N log K)
    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode ptr = ans;
        while(l1!=null && l2!=null) {
            if(l1.val < l2.val) {
                ptr.next = l1;
                ptr = ptr.next;
                l1 = l1.next;
            } else {
                ptr.next = l2;
                ptr = ptr.next;
                l2 = l2.next;
            }
        }
        if(l1==null) ptr.next = l2;
        if(l2==null) ptr.next = l1;
        return ans.next;
    }

    public static ListNode mergeKListsFaster(ListNode[] lists) {
        if(lists.length==0){
            return null;
        }
        int interval = 1;
        while(interval<lists.length){
            System.out.println(lists.length);
            for (int i = 0; i + interval< lists.length; i=i+interval*2) {
                lists[i]=merge(lists[i],lists[i+interval]);
            }
            interval*=2;
        }
        return lists[0];
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(11);
        ListNode n2 = new ListNode(-11);
        ListNode n3 = new ListNode(111);
        ListNode n4 = new ListNode(10);
        ListNode n5 = new ListNode(9);
        ListNode n6 = new ListNode(8);
        ListNode n7 = new ListNode(-7);
        ListNode n8 = new ListNode(99);
        ListNode n9 = new ListNode(123);
        ListNode n10 = new ListNode(999);
        ListNode n11 = new ListNode(991);
        ListNode n12 = new ListNode(-1);
        n1.next = n2;
        n2.next = n3;
        n4.next = n5;
        n5.next = n6;
        n6.next = n12;
        n12.next = n11;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;
        ListNode[] ans = {n1, n4, n7};
        ListNode res = mergeKLists(ans);
        while(res!=null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
