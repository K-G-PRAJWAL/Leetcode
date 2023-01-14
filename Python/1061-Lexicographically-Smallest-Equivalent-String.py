class Solution:

    def find(self, root, a):
        if a == root[a]:
            return a
        else:
            return self.find(root, root[a])

    def union(self, root, x, y):
        x = self.find(root, x)
        y = self.find(root, y)
        if x != y:
            if x < y:
                root[y] = x
            else:
                root[x] = y
        return

    def smallestEquivalentString(self, s1: str, s2: str, baseStr: str) -> str:
        root = [i for i in range(26)]

        ans = ""
        for i in range(len(s1)):
            self.union(root, ord(s1[i]) - ord('a'), ord(s2[i]) - ord('a'))

        for letter in baseStr:
            ans += chr(self.find(root, ord(letter) - ord('a')) + ord('a'))

        return ans
