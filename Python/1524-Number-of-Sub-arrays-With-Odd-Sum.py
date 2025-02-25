class Solution:
    def numOfSubarrays(self, arr: List[int]) -> int:
        n = len(arr)

        curr_sum = 0
        odd_cnt = 0
        even_cnt = 0
        res = 0
        MOD = 10**9+7

        for i in range(n):
            curr_sum += arr[i]
            if curr_sum%2==1:
                res += 1+even_cnt
                odd_cnt += 1
            else:
                res += odd_cnt
                even_cnt += 1

        return res%MOD
