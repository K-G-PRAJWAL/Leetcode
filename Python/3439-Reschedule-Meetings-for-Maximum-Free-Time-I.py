class Solution:
    def maxFreeTime(self, eventTime: int, k: int, startTime: List[int], endTime: List[int]) -> int:
        n = len(startTime)

        gaps = [startTime[0]]
        for i in range(1, n):
            gaps.append(startTime[i]-endTime[i-1])
        gaps.append(eventTime - endTime[-1])

        if max(gaps) == 0:
            return 0

        ans = csum = sum(gaps[:k+1])

        for i in range(k+1, len(gaps)):
            csum += gaps[i] - gaps[i-k-1]
            ans = max(ans, csum)

        return ans