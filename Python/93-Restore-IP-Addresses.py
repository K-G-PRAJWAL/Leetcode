class Solution:
    def backtrack(self, s, i, ip, ans):
        if len(ip) == 4:
            if i == len(s):
                ans.append('.'.join(ip))
        else:
            for j in range(i+1, i+4):
                next = s[i:j]
                if j <= len(s) and 0 <= int(next) <= 255 and (next == '0' or not next.startswith('0')):
                    ip.append(next)
                    self.backtrack(s, j, ip, ans)
                    ip.pop()

    def restoreIpAddresses(self, s: str) -> List[str]:
        ip = []
        ans = []
        self.backtrack(s, 0, ip, ans)
        return ans
