class Solution:
    def modifyString(self, s):
        a = list(s)
        n = len(a)
        for i in range(n):
            if a[i]=="?":
                for letter in "abc":
                    if (i==0 or a[i-1]!=letter) and (i+1==n or a[i+1]!=letter):
                        a[i]=letter
                        break
        return "".join(a)


s = Solution()
print(s.modifyString("?zs"))
print(s.modifyString("ubv?w"))
print(s.modifyString("j?qg??b"))
