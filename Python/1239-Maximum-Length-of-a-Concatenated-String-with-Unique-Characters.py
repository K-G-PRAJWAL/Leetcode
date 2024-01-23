class Solution:
    def maxLength(self, arr: List[str]) -> int:
        char_set = set()

        def common(char_set, s):
            map = Counter(char_set) + Counter(s)
            return max(map.values()) > 1

        def backtrack(i):
            if i == len(arr):
                return len(char_set)

            ans = 0
            if not common(char_set, arr[i]):
                for ch in arr[i]:
                    char_set.add(ch)
                ans = backtrack(i+1)
                for ch in arr[i]:
                    char_set.remove(ch)
            return max(ans, backtrack(i+1))

        return backtrack(0)
