package com.kgprajwal.leetcodejavasolutions;

public class ReverseNodesInKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || head.next ==null || k==1)
            return head;
        ListNode start;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        start = dummy;
        int i=0;
        while (head != null){
            i++;
            if (i%k == 0){
                start = reverse(start, head.next);
                head = start.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }

    public static ListNode reverse(ListNode begin, ListNode end){
        ListNode ans = begin.next;
        ListNode tail = end, cur = ans, next;
        while (cur != end) {
            next = cur.next;
            begin.next = cur;
            cur.next = tail;
            tail = cur;
            cur = next;
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode ans = reverseKGroup(n1, 2);
        while(ans!=null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
