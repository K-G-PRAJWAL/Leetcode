class Solution:
    def countOdds(self, low: int, high: int) -> int:
        if low % 2 == 0:
            low += 1

        return 0 if low > high else (high - low)//2+1
