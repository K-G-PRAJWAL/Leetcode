package com.kgprajwal.leetcodejavasolutions;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    private Queue<Integer> q = new LinkedList<Integer>();

    public MyStack() {

    }

    public void push(int x) {
        q.add(x);
        for (int i = 1; i < q.size(); i++) { //rotate the queue to make the tail be the head
            q.add(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
