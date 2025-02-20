class Solution:

    def gen(self, s, n, bin_set):
        if len(s) == n:
            if s not in bin_set:
                return s
            return ""
        add = self.gen(s+"0", n, bin_set)
        if add:
            return add
        return self.gen(s+"1", n, bin_set)

    def findDifferentBinaryString(self, nums: List[str]) -> str:
        n = len(nums)
        bin_set = set(nums)

        return self.gen("", n, bin_set)


# Optimized
class Solution:

    def gen(self, s, n, bin_set):
        if len(s) == n:
            if s not in bin_set:
                return s
            return ""
        add = self.gen(s+"0", n, bin_set)
        if add:
            return add
        return self.gen(s+"1", n, bin_set)

    def findDifferentBinaryString(self, nums: List[str]) -> str:
        n = len(nums)
        bin_set = set(nums)

        return self.gen("", n, bin_set)