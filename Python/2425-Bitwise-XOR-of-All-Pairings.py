class Solution:
    def xorAllNums(self, nums1: List[int], nums2: List[int]) -> int:
        m = len(nums1)
        n = len(nums2)

        freq = {}

        for num in nums1:
            freq[num] = freq.get(num, 0) + n
        for num in nums2:
            freq[num] = freq.get(num, 0) + m

        ans = 0
        for num in freq:
            if freq[num] % 2:
                ans ^= num

        return ans

    def xorAllNums_2(self, nums1: List[int], nums2: List[int]) -> int:
        xor1, xor2 = 0, 0
        len1, len2 = len(nums1), len(nums2)

        if len2%2:
            for n in nums1:
                xor1 ^= n

        if len1%2:
            for n in nums2:
                xor2 ^= n

        return xor1 ^ xor2