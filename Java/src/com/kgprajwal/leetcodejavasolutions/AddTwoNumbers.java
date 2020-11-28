package com.kgprajwal.leetcodejavasolutions;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {this.val = val;}
    ListNode(int val, ListNode next) {this.val=val; this.next=next;}
}

// O(max(M, N))
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(0);
        ListNode ptr = tmp;
        int carry = 0;
        while (l1!=null || l2!=null || carry==1) {
            if(l1!=null) {
                carry+=l1.val;
                l1=l1.next;
            }
            if(l2!=null) {
                carry+=l2.val;
                l2=l2.next;
            }
            ptr.next = new ListNode(carry%10);
            ptr = ptr.next;
            carry = (int)carry/10;
        }
        return tmp.next;
    }

    // Driver
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(4);
        n4.next = n5;
        n5.next = n6;
        n6.next = null;
        ListNode ans = addTwoNumbers(n1, n4);
        while (ans!=null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
