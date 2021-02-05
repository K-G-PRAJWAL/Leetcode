package com.kgprajwal.leetcodejavasolutions;

class TreeLinkNode {
    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;

    public TreeLinkNode() {
    }

    public TreeLinkNode(int _val) {
        val = _val;
    }

    public TreeLinkNode(int _val, TreeLinkNode _left, TreeLinkNode _right, TreeLinkNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulatingNextRightPointersInEachNode {
    public TreeLinkNode connect(TreeLinkNode root) {
        TreeLinkNode lvl = root;
        while (lvl != null) {
            TreeLinkNode curr = lvl;
            while (curr != null) {
                if (curr.left != null) curr.left.next = curr.right;
                if (curr.right != null && curr.next != null) curr.right.next = curr.next.left;
                curr = curr.next;
            }
            lvl = lvl.left;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n7 = new TreeLinkNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        PopulatingNextRightPointersInEachNode o = new PopulatingNextRightPointersInEachNode();
        o.connect(n1);
    }
}
