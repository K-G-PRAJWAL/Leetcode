class DoublyLinkedList:
    class ListNode:
        def __init__(self, key=0, val=0, prev=None, next=None):
            self.key = key
            self.val = val
            self.freq = 1
            self.prev = prev
            self.next = next

    def __init__(self):
        self.size = 0
        self.head = self.ListNode()
        self.tail = self.ListNode()
        self.head.next = self.tail
        self.tail.prev = self.head

    def remove_node(self, node):
        node.next.prev = node.prev
        node.prev.next = node.next
        self.size -= 1

    def insert_head(self, node):
        self.head.next.prev = node
        node.next = self.head.next
        node.prev = self.head
        self.head.next = node
        self.size += 1

    def remove_tail(self):
        tail = self.tail.prev
        self.remove_node(tail)
        return tail


class LFUCache:

    def __init__(self, capacity: int):
        self.cache = {}
        self.freq_map = {}
        self.capacity = capacity
        self.min_freq = 0

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        node = self.cache[key]
        self.update_cache(node.key, node.val)
        return node.val

    def put(self, key: int, val: int) -> None:
        if self.capacity == 0:
            return

        if key in self.cache:
            self.update_cache(key, val)
        else:
            if len(self.cache) == self.capacity:
                lfu_node = self.freq_map[self.min_freq].remove_tail()
                del self.cache[lfu_node.key]
            self.min_freq = 1
            if self.min_freq not in self.freq_map:
                self.freq_map[self.min_freq] = DoublyLinkedList()
            node = DoublyLinkedList.ListNode(key, val)
            self.freq_map[self.min_freq].insert_head(node)
            self.cache[key] = node

    def update_cache(self, key, val):
        node = self.cache[key]
        node.val = val
        prev_freq = node.freq
        node.freq += 1
        self.freq_map[prev_freq].remove_node(node)
        if node.freq not in self.freq_map:
            self.freq_map[node.freq] = DoublyLinkedList()
        self.freq_map[node.freq].insert_head(node)
        if prev_freq == self.min_freq and self.freq_map[prev_freq].size == 0:
            del self.freq_map[prev_freq]
            self.min_freq += 1
