package com.kgprajwal.leetcodejavasolutions;

public class PopulatingNextRightPointersInEachNodeII {
    public TreeLinkNode connect(TreeLinkNode root) {
        TreeLinkNode x = root;
        TreeLinkNode tmp = new TreeLinkNode(0);
        while (root != null) {
            TreeLinkNode curr = tmp;
            while (root != null) {
                if (root.left != null) {
                    curr.next = root.left;
                    curr = curr.next;
                }
                if (root.right != null) {
                    curr.next = root.right;
                    curr = curr.next;
                }
                root = root.next;
            }
            root = tmp.next;
            tmp.next = null;
        }
        return x;
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
        PopulatingNextRightPointersInEachNodeII o = new PopulatingNextRightPointersInEachNodeII();
        o.connect(n1);
    }
}
