package com.kgprajwal.leetcodejavasolutions;

import java.util.HashMap;
import java.util.Map;

class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    public RandomNode copyRandomList(RandomNode head) {
        if (head == null) return null;
        Map<RandomNode, RandomNode> map = new HashMap<>();
        RandomNode ptr = head;
        while (ptr != null) {
            map.put(ptr, new RandomNode(ptr.val));
            ptr = ptr.next;
        }
        ptr = head;
        while (ptr != null) {
            map.get(ptr).next = map.get(ptr.next);
            map.get(ptr).random = map.get(ptr.random);
            ptr = ptr.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        RandomNode n1 = new RandomNode(7);
        RandomNode n2 = new RandomNode(13);
        RandomNode n3 = new RandomNode(11);
        RandomNode n4 = new RandomNode(10);
        RandomNode n5 = new RandomNode(1);
        CopyListWithRandomPointer o = new CopyListWithRandomPointer();
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;
        System.out.println(o.copyRandomList(n1));
    }
}
