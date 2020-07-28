class Solution:
    def merge(self, nums1, m, nums2, n):
        i, j, k = m-1, n-1, m+n-1
        while k >= 0:
            if j < 0:
                break
            if nums1[i] > nums2[j] and i >= 0:
                nums1[k] = nums1[i]
                i -= 1
            else:
                nums1[k] = nums2[j]
                j -= 1
            k -= 1
        return nums1


s = Solution()
print(s.merge([1, 2, 3, 0, 0, 0], 3, [2, 5, 6], 3))
