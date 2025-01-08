class Node:
    def __init__(self):
        self.chain = [None]*26

    def _contains(self, ch) -> bool:
        return self.chain[ord(ch)-ord('a')] is not None

    def _put(self, ch, node) -> None:
        self.chain[ord(ch) - ord('a')] = node

    def _next(self, ch) -> "Node":
        return self.chain[ord(ch) - ord('a')]

class Trie:
    def __init__(self):
        self.root = Node()

    def insert(self, word):
        node = self.root
        for ch in word:
            if not node._contains(ch):
                node._put(ch, Node())
            node = node._next(ch)

    def starts_with(self, pfx):
        node = self.root
        for ch in pfx:
            if not node._contains(ch):
                return False
            node = node._next(ch)
        return True

class Solution:
    def countPrefixSuffixPairs(self, words):
        n = len(words)
        ans = 0

        for i in range(n):
            pfx_trie = Trie()
            sfx_trie = Trie()

            pfx_trie.insert(words[i])

            rev = words[i][::-1]
            sfx_trie.insert(rev)

            for j in range(i):
                if len(words[j]) > len(words[i]):
                    continue

                pfx_word = words[j]
                sfx_word = pfx_word[::-1]

                if pfx_trie.starts_with(pfx_word) and sfx_trie.starts_with(sfx_word):
                    ans += 1

        return ans

