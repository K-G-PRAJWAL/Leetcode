class Solution:
    def findThePrefixCommonArray(self, A: List[int], B: List[int]) -> List[int]:
        # O(N^3)
        n = len(A)

        ans = [0]*n

        for i in range(n):
            common = 0

            for j in range(i+1):
                for k in range(i+1):
                    if A[j] == B[k]:
                        common += 1
                        break

            ans[i] = common

        return ans

    def findThePrefixCommonArray_2(self, A: List[int], B: List[int]) -> List[int]:
        # (O^2)
        n = len(A)
        ans = [0]*n

        a_set, b_set = set(), set()
        for i in range(n):
            a_set.add(A[i])
            b_set.add(B[i])

            common = 0
            for x in a_set:
                if x in b_set:
                    common += 1

            ans[i] = common

        return ans

    def findThePrefixCommonArray(self, A: List[int], B: List[int]) -> List[int]:
        # O(N)
        n = len(A)
        ans = [0]*n
        freq = [0]*(n+1)
        common = 0

        i = 0
        while i < n:
            freq[A[i]] += 1
            if freq[A[i]] == 2:
                common += 1

            freq[B[i]] += 1
            if freq[B[i]] == 2:
                common += 1

            ans[i] = common
            i+=1

        return ans