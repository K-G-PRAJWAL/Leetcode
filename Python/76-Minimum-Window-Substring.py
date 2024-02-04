class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if t == "":
            return ""

        count_t = {}
        window = {}

        for ch in t:
            count_t[ch] = 1 + count_t.get(ch, 0)

        have, need = 0, len(count_t)

        ans = [-1, -1]
        ans_len = float("infinity")

        start = 0
        for end in range(len(s)):
            ch = s[end]
            window[ch] = 1+window.get(ch, 0)

            if ch in count_t and window[ch] == count_t[ch]:
                have += 1

            while have == need:
                if end - start + 1 < ans_len:
                    ans = [start, end]
                    ans_len = end - start + 1
                window[s[start]] -= 1
                if s[start] in count_t and window[s[start]] < count_t[s[start]]:
                    have -= 1
                start += 1

        l, r = ans
        return s[l:r+1] if ans_len != float("infinity") else ""
