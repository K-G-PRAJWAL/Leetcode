package com.kgprajwal.leetcodejavasolutions;

public class ConvertSortedListToBinarySearchTree {
    /*public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        ListNode root = helper(head);
        TreeNode node = new TreeNode(root.val);
        if(head==root) return node;
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(root.next);
        return node;
    }

    ListNode helper(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!=null && fast.next!=null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev!=null) prev.next = null;
        return slow;
    }*/

    TreeNode sortedListToBST(ListNode head) {
        TreeNode root = null;
        if (head == null) return root;
        else if (head.next == null) return new TreeNode(head.val);
        ListNode slow = head, fast = head, prev = slow;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        prev.next = null;
        root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    public static void main(String[] args) {
        ConvertSortedListToBinarySearchTree obj = new ConvertSortedListToBinarySearchTree();
        ListNode n1 = new ListNode(-10);
        ListNode n2 = new ListNode(-3);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(9);
        TreeNode ptr = obj.sortedListToBST(n1);
        System.out.println(ptr);
    }
}
