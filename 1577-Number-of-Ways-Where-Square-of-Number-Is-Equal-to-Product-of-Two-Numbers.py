import collections


class Solution:
    def numTriplets(self, nums1, nums2):
        d1 = collections.defaultdict(int)
        d2 = collections.defaultdict(int)
        for i in nums1:
            d1[i*i] += 1
        for i in nums2:
            d2[i*i] += 1
        ans = 0
        for i in range(len(nums1)-1):
            for j in range(i+1, len(nums1)):
                prod = nums1[i]*nums1[j]
                if prod in d2:
                    ans += d2[prod]
        for i in range(len(nums2)-1):
            for j in range(i+1, len(nums2)):
                prod = nums2[i]*nums2[j]
                if prod in d1:
                    ans += d1[prod]
        return ans


s = Solution()
print(s.numTriplets([7, 4], [5, 2, 8, 9]))
