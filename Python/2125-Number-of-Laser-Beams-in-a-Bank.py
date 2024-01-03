class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        # nrows = len(bank)
        # ncols = len(bank[0])

        # prevDevices = 0
        # nlasers = 0

        # for i in range(nrows):
        #     currDevices = 0
        #     for j in range(ncols):
        #         if bank[i][j] == '1':
        #             currDevices += 1
            
        #     nlasers += currDevices * prevDevices
        #     if currDevices != 0:
        #         prevDevices = currDevices

        # return nlasers

        prev = 0
        ans = 0
        for i in range(len(bank)):
            curr = bank[i].count('1')
            if curr > 0:
                ans += curr * prev
                prev = curr
        
        return ans