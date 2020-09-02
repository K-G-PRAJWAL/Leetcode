class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.trie = {}

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        dic = self.trie
        for letter in word:
            if letter not in dic:
                dic[letter] = {}
            dic = dic[letter]
        dic["checkWord"] = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        dic = self.trie
        for letter in word:
            if letter not in dic:
                return False
            dic = dic[letter]
        return "checkWord" in dic

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        dic = self.trie
        for letter in prefix:
            if letter not in dic:
                return False
            dic = dic[letter]
        return True


# Your Trie object will be instantiated and called as such:
trie = Trie()
print(trie.insert("apple"))
print(trie.search("apple"))
print(trie.search("app"))
print(trie.startsWith("app"))
print(trie.insert("app"))
print(trie.search("app"))
