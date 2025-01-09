# Option 1
class Solution:
    def prefixCount(self, words: List[str], pref: str) -> int:
        n = len(words)
        cnt = 0

        for word in words:
            if word.startswith(pref):
                cnt += 1

        return cnt

# Option 2
class Solution:
    class Trie:
        class Node:
            def __init__(self):
                self.links = [None]*26
                self.cnt = 0

        def __init__(self):
            self.root = self.Node()

        def _add_word(self, word):
            curr = self.root
            for ch in word:
                idx = ord(ch) - ord('a')
                if curr.links[idx] is None:
                    curr.links[idx] = self.Node()
                curr = curr.links[idx]
                curr.cnt += 1

        def _count_prefix(self, pref):
            curr = self.root
            for ch in pref:
                idx = ord(ch) - ord('a')
                if curr.links[idx] is None:
                    return 0
                curr = curr.links[idx]
            return curr.cnt

    def prefixCount(self, words, pref):
        trie = self.Trie()
        for word in words:
            trie._add_word(word)
        return trie._count_prefix(pref)

