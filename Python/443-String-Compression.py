class Solution:
    def compress(self, chars: List[str]) -> int:
        n = len(chars)
        if n == 1:
            return 1

        i = j = 0
        while i < n:
            count = 1
            while i < n - 1 and chars[i] == chars[i+1]:
                count += 1
                i += 1

            chars[j] = chars[i]
            j += 1

            if count > 1:
                for c in str(count):
                    chars[j] = c
                    j += 1

            i += 1

        return j
