package com.kgprajwal.leetcodejavasolutions;

public class MinStack {
    class MinStackNode {
        int val, min;
        MinStackNode next;

        MinStackNode(int val, int min) {
            this.val = val;
            this.min = min;
        }

        MinStackNode(int val, int min, MinStackNode next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }

    }

    MinStackNode head;

    public void push(int x) {
        if (head == null) head = new MinStackNode(x, x);
        else head = new MinStackNode(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}
