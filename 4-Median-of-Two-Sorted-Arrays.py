class Solution:
    def findMedianSortedArrays(self, nums1, nums2) -> float:
        l = len(nums1)+len(nums2)
        if l & 1:
            return self.solve(nums1, nums2, l//2+1)
        else:
            return (self.solve(nums1, nums2, l//2+1) + self.solve(nums1, nums2, l//2))/2.0

    def solve(self, a, b, k):
        if len(a)+len(b) < k:
            return None
        i = 0
        j = 0
        flag = ''
        while k > 0:
            if i >= len(a):
                j += 1
                flag = False
            elif j >= len(b):
                i += 1
                flag = True
            elif a[i] <= b[j]:
                i += 1
                flag = True
            elif a[i] > b[j]:
                j += 1
                flag = False
            k -= 1

        if flag:
            return a[i-1]
        else:
            return b[j-1]


s = Solution()
print(s.findMedianSortedArrays([1, 2], [3, 4]))
