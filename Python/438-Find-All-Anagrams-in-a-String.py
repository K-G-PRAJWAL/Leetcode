class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        ns, np = len(s), len(p)
        if np > ns:
            return []

        p_map, s_map = {}, {}

        for i in range(np):
            p_map[p[i]] = p_map.get(p[i], 0)+1
            s_map[s[i]] = s_map.get(s[i], 0)+1

        ans = [0] if p_map == s_map else []

        l = 0
        for r in range(np, ns):
            s_map[s[r]] = s_map.get(s[r], 0)+1
            s_map[s[l]] -= 1

            if s_map[s[l]] == 0:
                s_map.pop(s[l])

            l += 1
            if s_map == p_map:
                ans.append(l)

        return ans
