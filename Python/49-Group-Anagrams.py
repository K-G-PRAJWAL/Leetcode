from collections import defaultdict


class Solution:
    def groupAnagrams(self, strs):
        # Solution 1
        d = defaultdict(list)
        for s in strs:
            sortedS = "".join(sorted(s))
            d[sortedS].append(s)
        return d.values()

        # Solution 2
        add, prod = 0, 1
        d = defaultdict(list)
        for i in strs:
            for j in i:
                add += ord(j)
                prod *= ord(j)
            ans = 2*add+prod
            d[ans].append(i)
            add, prod = 0, 1
        return d.values()

s = Solution()
print(s.groupAnagrams(["eat", "tea", "tan", "ate", "nat", "bat"]))
