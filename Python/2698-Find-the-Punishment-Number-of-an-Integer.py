class Solution:
    def punishmentNumber(self, n: int) -> int:
        ans = 0

        def can_partition(str_square, target):
            if str_square == "" and target == 0:
                return True

            res = False
            for i in range(len(str_square)):
                l = str_square[:i+1]
                r = str_square[i+1:]
                l_num = int(l)
                check = can_partition(r, target - l_num)

                if check:
                    res = True
                    break
            return res

        for i in range(1, n+1):
            square = i*i
            if can_partition(str(square), i):
                ans += square

        return ans