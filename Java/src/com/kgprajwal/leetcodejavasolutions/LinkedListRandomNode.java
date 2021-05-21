package com.kgprajwal.leetcodejavasolutions;

public class LinkedListRandomNode {
    /*

    // Fixed Range Sampling

    List<Integer> range = new ArrayList<>();

    public LinkedListRandomNode(ListNode head) {
        while (head != null) {
            this.range.add(head.val);
            head = head.next;
        }
    }


    // Returns a random node's value.
    public int getRandom() {
        int rand = (int) (Math.random() * this.range.size());
        return this.range.get(rand);
    }
    */

    // Reservoir Sampling
    ListNode head;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    int getRandom() {
        int scope = 1, rand = 0;
        ListNode ptr = this.head;
        while (ptr != null) {
            if (Math.random() < 1.0 / scope) {
                rand = ptr.val;
            }
            scope += 1;
            ptr = ptr.next;
        }
        return rand;
    }
}
