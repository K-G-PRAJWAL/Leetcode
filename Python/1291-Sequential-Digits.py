class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        ans = []

        for i in range(1, 10):
            curr_number = i
            next_digit = i+1

            while curr_number <= high and next_digit <= 9:
                curr_number = curr_number*10 + next_digit
                if high >= curr_number >= low:
                    ans.append(curr_number)
                next_digit += 1

        ans.sort()
        return ans

    def sequentialDigits(self, low: int, high: int) -> List[int]:
        nums = "123456789"
        ans = []

        for i in range(9):
            for j in range(i+1, 10):
                curr_number = int(nums[i:j])
                if low <= curr_number <= high:
                    ans.append(curr_number)

        ans.sort()
        return ans
