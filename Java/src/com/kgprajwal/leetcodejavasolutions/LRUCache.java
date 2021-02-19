package com.kgprajwal.leetcodejavasolutions;

import java.util.HashMap;
import java.util.Map;

class LRUNode {
    int key;
    int val;
    LRUNode next;
    LRUNode prev;

    LRUNode(int key, int value) {
        this.key = key;
        this.val = value;
    }
}

class LinkedNodeList {
    LRUNode dummyHead;
    LRUNode dummyTail;

    LinkedNodeList() {
        dummyHead = new LRUNode(0, 0);
        dummyTail = new LRUNode(0, 0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    void moveToHead(LRUNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        addToHead(node);
    }

    void addToHead(LRUNode node) {
        LRUNode tmp = dummyHead.next;
        dummyHead.next = node;
        node.next = tmp;
        node.prev = dummyHead;
        tmp.prev = node;
    }

    void removeTail() {
        LRUNode newTail = dummyTail.prev.prev;
        newTail.next = dummyTail;
        dummyTail.prev = newTail;
    }

    LRUNode getTail() {
        return dummyTail.prev;
    }

}

public class LRUCache {
    LinkedNodeList list;
    Map<Integer, LRUNode> map;
    Integer cap;

    public LRUCache(int capacity) {
        list = new LinkedNodeList();
        map = new HashMap(capacity);
        cap = capacity;
    }

    public int get(int key) {
        LRUNode node = map.get(key);
        if (node == null) {
            return -1;
        }
        list.moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        LRUNode node = map.get(key);
        if (node != null) {
            list.moveToHead(node);
            node.val = value;

        } else {
            LRUNode newNode = new LRUNode(key, value);
            if (map.size() == cap) {
                LRUNode tail = list.getTail();
                map.remove(tail.key);
                list.removeTail();
            }
            map.put(key, newNode);
            list.addToHead(newNode);
        }
    }
}
