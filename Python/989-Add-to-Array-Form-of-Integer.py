class Solution:
    def addToArrayForm(self, num: List[int], k: int) -> List[int]:
        num_str = ""
        for n in num:
            num_str += str(n)

        num_int = int(num_str)+k
        ans = []

        while num_int > 0:
            ans.append(num_int % 10)
            num_int //= 10
        return ans[::-1]
